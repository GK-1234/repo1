package com.stylus.springwebclass.configuration;


import java.util.Arrays;

import org.h2.server.web.WebServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfiguration {
	
	  @Bean
	    ServletRegistrationBean myServletRegistration () {
	        ServletRegistrationBean srb = new ServletRegistrationBean();
	        srb.setServlet(new WebServlet());
	        srb.setUrlMappings(Arrays.asList("/console/*"));
	        return srb;
	    }
	/*
	@Bean
     ServletRegistrationBean<HttpServelet> h2servletRegistration(){
        ServletRegistrationBean<GenericServlet> registrationBean = new ServletRegistrationBean<GenericServlet>(new WebServlet());
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new WebServlet());
        registrationBean.addUrlMappings("/console/*");

        return registrationBean;
    }
*/
}
