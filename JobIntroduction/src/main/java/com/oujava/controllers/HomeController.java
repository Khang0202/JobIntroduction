/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oujava.controllers;


import com.oujava.repository.impl.UserRepositoryImpl;
import com.oujava.service.EmploymentTypeService;
import com.oujava.service.JobService;
import com.oujava.service.UserService;
import java.util.Map;
import javax.persistence.Embeddable;
import javax.persistence.Query;
import org.eclipse.persistence.annotations.Properties;
import org.hibernate.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author nguye
 */
@Controller
@ControllerAdvice
@PropertySource("classpath:configs.properties")
public class HomeController {
    
    @Autowired
    private EmploymentTypeService employmentTypeService;
    @Autowired
    private JobService jobService;
    @Autowired
    private Environment env;
    
    
    @ModelAttribute
    public void commonAttr(Model model) {
        model.addAttribute("em", employmentTypeService.getAllEmType());
    }
    
    @RequestMapping("/")
    @Transactional
    public String index(Model model, @RequestParam Map<String, String> params){
        model.addAttribute("job",jobService.getJobs(params));
        
        int pageSize = Integer.parseInt(this.env.getProperty("PAGE_SIZE"));
        Long count = jobService.countJob();
        model.addAttribute("counter", Math.ceil(count*1.0/pageSize));
        
        return "home";
    }
}
