package com.want.servlet.listener;
 

 
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
 
@WebListener

public class listenerDemo02 implements ServletContextListener{
	    @Override
	    public void contextInitialized(ServletContextEvent servletContextEvent) {
	        System.out.println("ServletContex初始化------11111111111------");
	       System.out.println(servletContextEvent.getServletContext().getServerInfo());
	    }

	    @Override
	    public void contextDestroyed(ServletContextEvent servletContextEvent) {
	        System.out.println("ServletContex销毁------222222222------");
	    }
	}
	