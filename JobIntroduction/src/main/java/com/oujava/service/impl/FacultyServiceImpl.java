/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oujava.service.impl;

import com.oujava.pojo.Faculty;
import com.oujava.repository.FacultyRepository;
import com.oujava.service.FacultyService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author trann
 */
@Service
public class FacultyServiceImpl implements FacultyService{

    @Autowired
    private FacultyRepository facultyRepository;
    
    @Override
    public List<Faculty> getAllFacultys() {
         return this.facultyRepository.getAllFacultys();
    }
    
    @Override
    public boolean addOrUpdateFaculty(Faculty faculty) {
        if (!faculty.getFaculty().isEmpty()) {
            return this.facultyRepository.addOrUpdateFaculty(faculty);
        } else {
            return false;
        }
    }
    @Override
    public boolean deleteFacultyById(int id) {
        if(id >= 1){
            return this.facultyRepository.deleteFacultyById(id);
        }else{
            return false;
        }
    }

    
    
}
