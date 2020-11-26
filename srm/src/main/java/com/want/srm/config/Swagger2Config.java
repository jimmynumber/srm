package com.want.srm.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Config extends WebMvcConfigurationSupport {
 
    @Bean
    public Docket createApi(){
    	List<Parameter> parameterList = new ArrayList<>();
        parameterList.add(new ParameterBuilder().name("token").description("請輸入token")
                .modelRef(new ModelRef("string")).parameterType("header").required(false).build());
        
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .globalOperationParameters(parameterList)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.want.srm.controller"))
                .paths(PathSelectors.any())
                .build();
    }
 
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("供应商对账系统")
                .description("RESTful API接口")
                .version("1.0.1")
                .build();
    }
 
    /**
     * 解决swagger-ui.html 404无法访问的问题
     */
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 解决静态资源无法访问
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/");
        // 解决swagger无法访问
        registry.addResourceHandler("/swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        // 解决swagger的js文件无法访问
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }	
}
