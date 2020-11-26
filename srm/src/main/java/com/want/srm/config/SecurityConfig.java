package com.want.srm.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.want.srm.interceptor.TokenFilter;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private TokenFilter tokenFilter;

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring()
        // Swagger
        .antMatchers("/v2/api-docs", "/swagger-resources/**", "/swagger/**", "/swagger-ui.html", "/webjars/**", "/images/**", "/statics/**", "/wantTopImage/**");
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		 httpSecurity
         .cors()
         .and()
         .csrf()
         .disable()
         .exceptionHandling()
         .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
         .and()
         .authorizeRequests()
         // 静态图片
         .antMatchers("/static/**").permitAll()
         // 登录
         .antMatchers(HttpMethod.POST, "/login").permitAll()
         // 登出
         .antMatchers(HttpMethod.POST, "/logout").permitAll()
         // validateToken
         .antMatchers(HttpMethod.POST, "/WebService/validateToken").permitAll()
         //企业微信登录
         .antMatchers(HttpMethod.POST, "/iwwLogin").permitAll()
         // 版本更新
         .antMatchers(HttpMethod.POST, "/base/update").permitAll()
         // 返回所有接口
         .antMatchers(HttpMethod.POST, "/base/InterfaceList").permitAll()
         // 其他请求需要认证
         .anyRequest().permitAll();//authenticated()
		 //.and().addFilterBefore(tokenFilter, UsernamePasswordAuthenticationFilter.class)
		 //.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
	
	

}
