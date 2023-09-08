/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.oujava.repository;

import com.oujava.pojo.Role;
import java.util.List;
import java.util.Map;

/**
 *
 * @author trann
 */
public interface RoleRepository {
    List<Role> getAllRole(Map<String, String> params);
}
