/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oujava.service.impl;

import com.oujava.pojo.EmploymentType;
import com.oujava.repository.EmploymentTypeRepository;
import com.oujava.service.EmploymentTypeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author trann
 */
@Service
public class EmploymentTypeServiceImpl implements EmploymentTypeService {

    @Autowired
    private EmploymentTypeRepository employmentTypeRepository;

    @Override
    public List<EmploymentType> getAllEmType() {
        return employmentTypeRepository.getAllEmType();
    }

    @Override
    public void addEmType(EmploymentType employmentType) {
        employmentTypeRepository.addEmType(employmentType);
    }

    @Override
    public void editEmTypeById(int id, String newEmploymentType) {
        employmentTypeRepository.editEmTypeById(id, newEmploymentType);

    }

    @Override
    public void deleteEmTypeById(int id) {
        employmentTypeRepository.deleteEmTypeById(id);
    }

}
