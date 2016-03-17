package com.raghu.dashboard.config;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.raghu.dashboard.filter.CORSFilter;


public class AppInitalizer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext)
			throws ServletException {
		WebApplicationContext context = getContext();
        servletContext.addListener(new ContextLoaderListener(context));
        
        FilterRegistration.Dynamic springSecurityFilterChain = servletContext.addFilter("corsFilter", new CORSFilter());
        springSecurityFilterChain.addMappingForUrlPatterns(null, false, "/*");
        springSecurityFilterChain.setAsyncSupported(true);
        
        
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("DispatcherServlet", new DispatcherServlet(context));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/*");
	}
	
	private AnnotationConfigWebApplicationContext getContext() {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(com.raghu.dashboard.config.WebConfig.class);
        context.scan("com.raghu.dashboard.api");
        return context;
    }
	
}
