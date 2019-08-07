package com.bmw.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UriComponentsBuilder;

import com.bmw.common.BMWPocConstants;
import com.bmw.entity.RepairOrder;
import com.bmw.entity.response.RepairOrderListResponse;

@Configuration
public class RestConfig implements WebMvcConfigurer {

	private static Logger logger = LoggerFactory.getLogger(RestConfig.class);

	private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.clear();
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converters.add(converter);
    }

	@Value("${api.gatewayUri}")
	private String gatewayUri;

	@Value("${api.endpoints.repairOrders}")
	private String endpoint;

	@Autowired
	RestTemplate restTemplate;

    @Bean
    public CorsFilter corsFilter() {
        //1.添加CORS配置信息
        CorsConfiguration config = new CorsConfiguration();
          //放行哪些原始域
          config.addAllowedOrigin("*");
          //是否发送Cookie信息
          config.setAllowCredentials(true);
          //放行哪些原始域(请求方式)
          config.addAllowedMethod("*");
          //放行哪些原始域(头部信息)
          config.addAllowedHeader("*");

        //2.添加映射路径
        UrlBasedCorsConfigurationSource configSource = new UrlBasedCorsConfigurationSource();
        configSource.registerCorsConfiguration("/**", config);

        //3.返回新的CorsFilter.
        return new CorsFilter(configSource);
    }

    /* *
     * this is only a workaround to fetch list from API V1 and fetch detail from API V2
     * due to the issue of API V2, will be refactored when the API V2 issue get fixed.
     * */
//    @Bean
//    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
//    public RepairOrderListResponse cachedRepairOrderList() {
//		List<RepairOrder> orderList = new ArrayList<>();
//		RepairOrderListResponse respData = new RepairOrderListResponse();
//		respData.setItems(orderList);
//		try {
//	    	StringBuilder urlBuilder = new StringBuilder();
//	    	urlBuilder.append(gatewayUri)
//	    			 .append(BMWPocConstants.API_V1)
//	    			 .append(endpoint);
//
//	    	UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(urlBuilder.toString())
//	    	        .queryParam("DueInDateFrom", BMWPocConstants.DEFAULT_JULIAN_DATE)
//	    			.queryParam("PageSize", BMWPocConstants.REPAIRORDER_PAGE_SIZE);
//
//	    	String result = restTemplate.getForObject(builder.build().toString(), String.class);
//	    	RepairOrderListResponse orderResp = objectMapper.readValue(result, RepairOrderListResponse.class);
//	    	for(RepairOrder order : orderResp.getItems()) {
//	    		getRepairOrderById(orderList, urlBuilder, order);
//	    	}
//	    	respData.setTotalPages(1);
//	    	respData.setTotalItems(orderList.size());
//		} catch (RestClientResponseException rce) {
//			logger.error("failed to get repair order list, id is {}", rce);
//		} catch (IOException e) {
//			logger.error("failed to parse json object of repair order list, id is {}", e);
//		}
//
//    	return respData;
//    }

	private void getRepairOrderById(List<RepairOrder> orderList, StringBuilder urlBuilder, RepairOrder order) {
		String result;
		String repairOrderId = order.getRepairOrderId();
		try {
			urlBuilder.setLength(0);
			urlBuilder.append(gatewayUri)
				.append(BMWPocConstants.API_V2)
				.append(endpoint)
				.append("/")
				.append(repairOrderId);
			result = restTemplate.getForObject(urlBuilder.toString(), String.class);
			RepairOrder repairOrder = objectMapper.readValue(result, RepairOrder.class);
			orderList.add(repairOrder);
		} catch (RestClientResponseException rce) {
			logger.error("failed to get repairOrder, id is {}", repairOrderId);
		} catch (IOException e) {
			logger.error("failed to parse json object of repair order list, id is {}", e);
		}
	}
}
