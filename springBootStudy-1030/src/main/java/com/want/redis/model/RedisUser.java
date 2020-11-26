package com.want.redis.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class RedisUser implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private int age;

}