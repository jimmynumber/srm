package com.want.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@ConfigurationProperties(prefix = "personinfo")
public class GetPersonInfoProperties {
	private String name;
	private int age;
}
