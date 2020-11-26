package com.want.entity;
import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class User implements Serializable  {
  
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//定义id
    private long id;
    //定义用户名
    private String name;
    //定义用户年龄
    private  int age;
	public User(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public User(long id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}
	
    
}
