package com.raghu.dashboard.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.raghu.dashboard.dao.ITaskDAO;
import com.raghu.dashboard.dao.TaskDAOImpl;

@Import(MongoConfiguration.class)
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.raghu.dashboard.api", "com.raghu.dashboard.dao" })
public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

    protected Class<?>[] getRootConfigClasses() { return null;}

    protected Class<?>[] getServletConfigClasses() {
        return new Class[] { MongoConfiguration.class};
    }

    protected String[] getServletMappings() {
        return new String[]{"*.htm"}; 
    }
    
	@Bean(name = "taskDao")
	public ITaskDAO taskDao() {
		return new TaskDAOImpl();
	}
	
    @Bean
    public InternalResourceViewResolver getInternalResourceViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/pages/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

}
