package com.niit.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.coll.config.DBConfiguration;

public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		System.out.println("----getRootConfig classes----");
		return new Class[] {WebResolver.class, DBConfiguration.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		System.out.println("-----getServletConfigClasses------");
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		System.out.println("-----getServletMappings----");
		return null;
	}

}
