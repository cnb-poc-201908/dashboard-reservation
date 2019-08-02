package com.bmw.auth.interceptor;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import com.bmw.auth.OAuth2TokenProvider;

@Component
public class OAuth2HeaderInterceptor implements ClientHttpRequestInterceptor {
	@Autowired
	OAuth2TokenProvider oauth2TokenProvider;

	@Override
	public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
			throws IOException {
		HttpHeaders headers = request.getHeaders();
		headers.add("Authorization", "Bearer " + oauth2TokenProvider.getAccessToken());

		// 保证请求继续被执行
		return execution.execute(request, body);
	}
}
