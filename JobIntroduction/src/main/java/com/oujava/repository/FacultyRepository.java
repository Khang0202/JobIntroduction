/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.oujava.repository;

import com.oujava.pojo.Faculty;
import java.util.List;

/**
 *
 * @author nguye
 */
public interface FacultyRepository {
    List<Faculty> getAllFacultys();
    Boolean addOrUpdateFaculty(Faculty faculty);
    Boolean deleteFacultyById(int id);
}
