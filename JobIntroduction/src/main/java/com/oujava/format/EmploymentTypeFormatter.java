/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oujava.format;

import com.oujava.pojo.EmploymentType;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author nguye
 */
public class EmploymentTypeFormatter implements Formatter<EmploymentType>{

    @Override
    public String print(EmploymentType object, Locale locale) {
        return String.valueOf(object.getId());
    }

    @Override
    public EmploymentType parse(String text, Locale locale) throws ParseException {
        EmploymentType r = new EmploymentType();
        r.setId(Integer.parseInt(text));
        return r;
    }
    
}
