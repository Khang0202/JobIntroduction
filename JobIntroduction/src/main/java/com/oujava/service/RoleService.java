/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.oujava.service;

import com.oujava.pojo.Role;
import java.util.List;
import java.util.Map;

/**
 *
 * @author trann
 */
public interface RoleService {
    List<Role> getAllRole(Map<String, String> params);
}
