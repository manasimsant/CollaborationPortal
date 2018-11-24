package com.niit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

//same as dispatcher servlet.xml file
@Configuration
@ComponentScan("com.niit")
@EnableWebMvc
public class WebResolver {
	
	@Bean
	public InternalResourceViewResolver getViewResolver() {
		System.out.println("view resolver bean creation");
		InternalResourceViewResolver iResolver = new InternalResourceViewResolver();
		iResolver.setPrefix("/WEB-INF/jsp");
		iResolver.setSuffix(".jsp");
		return iResolver;

	}

}
