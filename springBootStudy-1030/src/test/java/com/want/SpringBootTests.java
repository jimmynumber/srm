package com.want;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootTests {

	@Test
	void contextLoads() {
		System.out.println("SpringBootTests");
		
	}
	
	@Value("${myenvironment.name}")
	private String name;
	@Test
	public void getMyEnvironment() {
		System.out.println(name);

	}
}
