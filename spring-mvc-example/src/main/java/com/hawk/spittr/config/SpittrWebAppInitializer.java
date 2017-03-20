package com.hawk.spittr.config;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.hawk.spittr.web.WebConfig;

/**
 * 注册 dispatchservlet
 * @author pzhang1
 *
 */
public class SpittrWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] { RootConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] { WebConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

	@Override
	protected void customizeRegistration(Dynamic registration) {
		registration.setMultipartConfig(new MultipartConfigElement("c:/tmp/spittr/uploads", 2097152, 4194304, 0));
	}
	
	/**
	 * 注册的filter 只 处理 dispatchservlet 处理的链接
	 */
	@Override
	protected Filter[] getServletFilters() {
		return super.getServletFilters();
	}
	

}
