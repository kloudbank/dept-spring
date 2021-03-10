package com.htdp1.deptspring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.htdp1.deptspring.interceptor.LoggerInterceptor;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class WebConfig implements WebMvcConfigurer {

	public @Value("${session.enabled}") boolean enabled;

	/*
	 * 로그인 인증 Intercepter 설정
	 */
	@Autowired
	LoggerInterceptor loggerInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		log.debug("enabled => " + enabled);
		
		if (enabled) {
			log.debug("enabled => " + enabled);
			registry.addInterceptor(loggerInterceptor)
				//.addPathPatterns("/v1/*")
			;
		}
	}

}