/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oujava.DTO;

import com.oujava.pojo.Role;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author nguye
 */
@Getter
@Setter
public class CustomerDTO {
    private String firstname;
    private String lastname;
    private String image;
    private String email;
    private String phone;
    private String username;
    private String password;
    private String birth;
    private String sex;
    private Role roleId;
    
    public CustomerDTO (String firstname, String lastname, String image, String email, String phone, String username, String password,
            String birth, String sex, Role roleId) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.image = image;
        this.email = email;
        this.phone = phone;
        this.username = username;
        this.password = password;
        this.birth = birth;
        this.sex = sex;
        this.roleId = roleId;
    }
}
