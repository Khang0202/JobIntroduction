/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.oujava.repository;

import com.oujava.pojo.EmploymentType;
import java.util.List;

/**
 *
 * @author trann
 */
public interface EmploymentTypeRepository {
    List<EmploymentType> getAllEmType();
    boolean addOrUpdateEmType(EmploymentType employmentType);
    boolean deleteEmTypeById(int id);
    EmploymentType getEmTypeByName(String string);
    EmploymentType getEmTypeById(int id);
}
