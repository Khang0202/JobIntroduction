/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oujava.format;

import com.oujava.pojo.Role;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author nguye
 */
public class RoleFormatter  implements Formatter<Role>{

    @Override
    public String print(Role object, Locale locale) {
        return String.valueOf(object.getId());
    }

    @Override
    public Role parse(String text, Locale locale) throws ParseException {
        Role r = new Role();
        r.setId(Integer.parseInt(text));
        return r;
    }
    
}
