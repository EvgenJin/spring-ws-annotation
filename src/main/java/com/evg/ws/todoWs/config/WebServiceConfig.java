/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.evg.ws.todoWs.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

/**
 *
 * @author evgen
 */

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {
    
        @Bean
        public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
            MessageDispatcherServlet servlet = new MessageDispatcherServlet();
            servlet.setApplicationContext(applicationContext);
            servlet.setTransformWsdlLocations(true);
            return new ServletRegistrationBean(servlet, "/ws/*");
        }

	@Bean(name = "todo")
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema countriesSchema) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("todoPort");
		wsdl11Definition.setLocationUri("/todoWs/todo");
		wsdl11Definition.setTargetNamespace("http://evgenjin.com");
		wsdl11Definition.setSchema(countriesSchema);
		return wsdl11Definition;
	}

	@Bean
	public XsdSchema countriesSchema() {
		return new SimpleXsdSchema(new ClassPathResource("todo.xsd"));
	}
}