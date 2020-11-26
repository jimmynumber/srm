package com.want;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import com.want.properties.GetPersonInfoProperties;
@SpringBootTest
public class propertTest {
    //获取配置文件中的age
    @Value("${age}")
    private int age;

    //获取配置文件中的name
    @Value("${name}")
    private String name;

    @Test
    public void getAge() {
        System.out.println(age);
    }

    @Test
    public void getName() {
        System.out.println(name);
    }

    @Autowired
    private GetPersonInfoProperties getPersonInfoProperties;
    @Test
    public void getPersonproperties() {
        System.out.println(getPersonInfoProperties.getName()+getPersonInfoProperties.getAge());
    }
}