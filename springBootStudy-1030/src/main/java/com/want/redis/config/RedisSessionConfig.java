package com.want.redis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@Configuration
@EnableRedisHttpSession
//spring-session-data-redis提供的,加了spring-boot-starter-data-redis之后要加
//spring-session-data-redis依赖
public class RedisSessionConfig {

	/**
	 * 用于spring session，防止每次创建一个线程
	 * @return
	 */
	@Bean
	public ThreadPoolTaskExecutor springSessionRedisTaskExecutor(){
	  ThreadPoolTaskExecutor springSessionRedisTaskExecutor = new ThreadPoolTaskExecutor();
	  springSessionRedisTaskExecutor.setCorePoolSize(8);
	  springSessionRedisTaskExecutor.setMaxPoolSize(16);
	  springSessionRedisTaskExecutor.setKeepAliveSeconds(10);
	  springSessionRedisTaskExecutor.setQueueCapacity(1000);
	  springSessionRedisTaskExecutor.setThreadNamePrefix("Spring session redis executor thread: ");
	  return springSessionRedisTaskExecutor;
	}
}
