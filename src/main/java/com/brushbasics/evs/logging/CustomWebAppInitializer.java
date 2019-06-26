package com.brushbasics.evs.logging;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class CustomWebAppInitializer implements WebApplicationInitializer {
	public void onStartup(ServletContext container) {

				
		container.addFilter("customRequestLoggingFilter", CustomeRequestLoggingFilter.class)
				.addMappingForServletNames(null, false, "dispatcher");
	}
}