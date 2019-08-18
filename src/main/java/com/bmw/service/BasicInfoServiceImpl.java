package com.bmw.service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

@Service
public class BasicInfoServiceImpl implements BasicInfoService{
	
	private static Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);
	
	@Override
	public String getAllBasicInfoList() {
		String customerData = "";
		ClassPathResource cpr = new ClassPathResource("basicinfo.json");
		try {
			byte[] bdata = FileCopyUtils.copyToByteArray(cpr.getInputStream());
			customerData = new String(bdata,StandardCharsets.UTF_8);
		}catch(IOException e) {
			logger.error("failed to get customer file}");
		}
		return customerData;
	}

	@Override
	public String getPackageList() {
		// TODO Auto-generated method stub
		
		String packageData = "";
		ClassPathResource cpr = new ClassPathResource("compackage.json");
		try {
			byte[] bdata = FileCopyUtils.copyToByteArray(cpr.getInputStream());
			packageData = new String(bdata,StandardCharsets.UTF_8);
		}catch(IOException e) {
			logger.error("failed to get customer file}");
		}
		return packageData;
	}

	@Override
	public String getPaintingPackageList() {
		// TODO Auto-generated method stub
		String packageData = "";
		ClassPathResource cpr = new ClassPathResource("paintpackage.json");
		try {
			byte[] bdata = FileCopyUtils.copyToByteArray(cpr.getInputStream());
			packageData = new String(bdata,StandardCharsets.UTF_8);
		}catch(IOException e) {
			logger.error("failed to get customer file}");
		}
		return packageData;
		
	}

	

}
