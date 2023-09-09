/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.oujava.service;

import com.oujava.pojo.Faculty;
import java.util.List;

/**
 *
 * @author trann
 */
public interface FacultyService {

    List<Faculty> getAllFacultys();

    boolean addOrUpdateFaculty(Faculty faculty);

    boolean deleteFacultyById(int id);
}
