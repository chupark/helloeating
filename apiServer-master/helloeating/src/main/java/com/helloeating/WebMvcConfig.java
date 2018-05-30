package com.helloeating;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.helloeating.util.Interceptor;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter{

	@Autowired
	private Interceptor interceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(interceptor)
				.addPathPatterns("/**")
				.excludePathPatterns("/user/**")
				.excludePathPatterns("/error/**");
	}
}
