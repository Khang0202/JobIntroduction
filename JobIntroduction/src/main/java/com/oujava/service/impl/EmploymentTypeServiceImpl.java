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
        return this.employmentTypeRepository.getAllEmType();
    }

    @Override
    public boolean addOrUpdateEmType(EmploymentType employmentType) {
        if(!employmentType.getEmployment().isEmpty()){
            return this.employmentTypeRepository.addOrUpdateEmType(employmentType);
        }else{
            return false;
        }
    }

    @Override
    public boolean deleteEmTypeById(int id) {
        if(id >= 1){
            return this.employmentTypeRepository.deleteEmTypeById(id);
        }else{
            return false;
        }
    }

    @Override
    public EmploymentType getEmTypeByName(String string) {
        return this.employmentTypeRepository.getEmTypeByName(string);
    }

    @Override
    public EmploymentType getEmTypeById(int id) {
        return this.employmentTypeRepository.getEmTypeById(id);
    }

}
