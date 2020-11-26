package com.want.controller;

import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.want.annotation.MyTestAnnotation;

@RestController
@EnableAspectJAutoProxy
@RequestMapping("/testAnnotation")
public class TestAnnotationController {
	
	// http://localhost:8081/testAnnotation/
    @RequestMapping("/")
    @MyTestAnnotation("测试Annotation")
    public String testAnnotation() {
        System.err.println("测试自定义注解");
        return "测试自定义注解";
    }

}