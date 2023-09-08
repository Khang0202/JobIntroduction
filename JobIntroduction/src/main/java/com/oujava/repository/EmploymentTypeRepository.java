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
    Boolean addOrUpdateEmType(EmploymentType employmentType);
    Boolean deleteEmTypeById(int id);
}
