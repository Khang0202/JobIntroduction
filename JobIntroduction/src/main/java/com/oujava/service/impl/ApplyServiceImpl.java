/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oujava.service.impl;

import com.oujava.repository.ApplyRepository;
import com.oujava.service.ApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author trann
 */
@Service
public class ApplyServiceImpl implements ApplyService{

    @Autowired
    private ApplyRepository applyRepository;
    
    @Override
    public boolean addApply(int candidateId, int employerID) {
        return this.applyRepository.addApply(candidateId, employerID);
    }
    
}
