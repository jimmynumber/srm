package com.want.aop;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import com.want.annotation.MyTestAnnotation;

@Aspect
@Component
public class TestAnnotationAspect {
    //拦截被TestAnnotation注解的方法；如果需要拦截指定package指定规则名称的方法，可以使用表达式execution(...)
    @Pointcut("@annotation(com.want.annotation.MyTestAnnotation)")
    public void myAnnotationPointCut() {
    }

    @Before("myAnnotationPointCut()")
    public void before(JoinPoint joinPoint) throws Throwable {
        MethodSignature sign = (MethodSignature) joinPoint.getSignature();
        Method method = sign.getMethod();
        MyTestAnnotation annotation = method.getAnnotation(MyTestAnnotation.class);
        //获取注解参数
        System.out.print("打印TestAnnotation 参数：" + annotation.value());

    }


}
