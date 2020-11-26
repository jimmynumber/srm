package com.want.servlet.listener;

 
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
 
@WebListener
public class listenerDemo01 implements HttpSessionListener{
 
 
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        System.out.println("MyListener sessionCreated--11111111---");
    }
 
    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        System.out.println("MyListener sessionDestroyed---222222222--");
    }
}
 