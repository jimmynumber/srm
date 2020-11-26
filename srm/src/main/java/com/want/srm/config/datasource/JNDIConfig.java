//package com.want.srm.config.datasource;
//
//import org.apache.catalina.Context;
//import org.apache.catalina.startup.Tomcat;
//import org.apache.tomcat.util.descriptor.web.ContextResource;
//import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
//import org.springframework.boot.web.embedded.tomcat.TomcatWebServer;
//import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//
//@Configuration
//public class JNDIConfig {
//	@Bean(name = "webServerFactory")
//	@Primary
//	public ServletWebServerFactory webServerFactory() {
//		return new TomcatServletWebServerFactory() {
//			@Override
//			protected TomcatWebServer getTomcatWebServer(Tomcat tomcat) {
//				// 启用默认禁用的JNDI命名
//				tomcat.enableNaming();
//				return super.getTomcatWebServer(tomcat);
//			}
//
//			@Override
//			protected void postProcessContext(Context context) {
//				ContextResource resource = new ContextResource();
//				resource.setName("jdbc/mysql205/srmdb");
//				resource.setType("org.apache.tomcat.jdbc.pool.DataSource");
//				resource.setProperty("factory", "org.apache.tomcat.jdbc.pool.DataSourceFactory");
//				resource.setProperty("driverClassName", "com.mysql.cj.jdbc.Driver");
//				resource.setProperty("url", "jdbc:mysql:@10.128.85.205:3306:srmdb");
//				resource.setProperty("username", "srmdb");
//				resource.setProperty("password", "Srmdb@123..");
//				context.getNamingResources().addResource(resource);
//				super.postProcessContext(context);
//			}
//		};
//	}
//}
