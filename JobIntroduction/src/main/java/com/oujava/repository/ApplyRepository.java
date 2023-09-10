/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oujava.repository;

import com.oujava.pojo.User;

/**
 *
 * @author trann
 */
public interface ApplyRepository {
    boolean addApply(int candidateId,int employerID);
}
