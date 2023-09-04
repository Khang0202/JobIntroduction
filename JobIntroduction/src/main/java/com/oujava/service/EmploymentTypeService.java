/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.oujava.service;

import com.oujava.pojo.EmploymentType;
import java.util.List;

/**
 *
 * @author trann
 */
public interface EmploymentTypeService {

    List<EmploymentType> getAllEmType();

    void addEmType(EmploymentType employmentType);

    void editEmTypeById(int id, String newEmploymentType);

    void deleteEmTypeById(int id);
}
