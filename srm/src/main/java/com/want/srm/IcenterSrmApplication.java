package com.want.srm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class IcenterSrmApplication {

	public static void main(String[] args) {
		SpringApplication.run(IcenterSrmApplication.class, args);
	}

}
