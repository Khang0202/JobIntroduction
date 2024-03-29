/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oujava.configs;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.oujava.format.EmploymentTypeFormatter;
import com.oujava.format.RoleFormatter;
import java.text.SimpleDateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.format.FormatterRegistry;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 *
 * @author nguye
 */
@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages = {
    "com.oujava.controllers",
    "com.oujava.repository",
    "com.oujava.service"
})
@PropertySource("classpath:configs.properties")
public class WebAppContextConfig implements WebMvcConfigurer {

    @Autowired
    private Environment environment;

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    
    
    @Bean
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver resolver
                = new CommonsMultipartResolver();
        resolver.setDefaultEncoding("UTF-8");
        return resolver;
    }
    
//    @Bean
//    public MessageSource messageSource() {
//        ResourceBundleMessageSource m = new ResourceBundleMessageSource();
//
//        m.setBasenames("messages");
//
//        return m;
//    }
//
//    @Bean(name = "validator")
//    public LocalValidatorFactoryBean validator() {
//        LocalValidatorFactoryBean bean
//                = new LocalValidatorFactoryBean();
//        bean.setValidationMessageSource(messageSource());
//        return bean;
//    }
//
//    @Override
//    public Validator getValidator() {
//        return validator();
//    }
//
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(new RoleFormatter());
        registry.addFormatter(new EmploymentTypeFormatter());
    }
}
