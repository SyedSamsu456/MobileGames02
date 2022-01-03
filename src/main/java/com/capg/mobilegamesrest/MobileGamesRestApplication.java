package com.capg.mobilegamesrest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MobileGamesRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(MobileGamesRestApplication.class, args);
	}

}
