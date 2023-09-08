/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oujava.configs;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


/**
 *
 * @author nguye
 */
@Configuration
class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private Environment environment;  
    
     @Bean
    public Cloudinary cloudinary() {
        Cloudinary cloudinary
                = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", this.environment.getProperty("cloudinary.cloud_name"),
                "api_key", this.environment.getProperty("cloudinary.api_id"),
                "api_secret", this.environment.getProperty("cloudinary.api_secret"),
                "secure", true));
        return cloudinary;
    }
    
}
