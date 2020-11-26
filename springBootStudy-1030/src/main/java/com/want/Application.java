package com.want;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@ServletComponentScan  //在启动类使用@ServletComponentScan扫描带@WebFilter、@WebServlet、@WebListener并将帮我们注入bean
//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class,JpaRepositoriesAutoConfiguration.class,HibernateJpaAutoConfiguration.class})
@SpringBootApplication
@EnableReactiveMongoRepositories
@EnableJpaAuditing
@EnableSwagger2
@EnableCaching
//@Configuration
//@EnableAutoConfiguration
//@ComponentScan
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
//	public static void main(String[] args) {
//		SpringApplication springApplication = new SpringApplication(Application.class);
//		springApplication.run();
//		springApplication.setBannerMode(Banner.Mode.OFF);
//		springApplication.run(args);
//	}

    /*
    // Description: 注册一个bean 对象
    @Bean
    public ServletRegistrationBean<ServletDemo01> ServletDemo01() {
     // Description: 注册ServletRegistrationBean获得相应的控制
     return new ServletRegistrationBean<ServletDemo01>(new ServletDemo01(), "/ServletDemo01/*");
    }
    */
}
