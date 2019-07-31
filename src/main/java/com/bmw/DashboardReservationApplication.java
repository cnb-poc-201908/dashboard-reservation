package com.bmw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class DashboardReservationApplication {

	public static void main(String[] args) {
		SpringApplication.run(DashboardReservationApplication.class, args);
	}

}
