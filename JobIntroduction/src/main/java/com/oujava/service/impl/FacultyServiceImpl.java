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
         return facultyRepository.getAllFacultys();
    }


    @Override
    public void editFacultyById(int id, String updatedFaculty) {
         facultyRepository.editFacultyById(id, updatedFaculty);
    }

    @Override
    public void deleteFacultyById(int id) {
        facultyRepository.deleteFacultyById(id);
    }

    @Override
    public void addFaculty(Faculty faculty) {
        facultyRepository.addFaculty(faculty);
    }
    
}
