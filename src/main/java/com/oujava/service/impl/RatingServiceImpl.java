/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oujava.service.impl;

import com.oujava.pojo.Rating;
import com.oujava.repository.RatingRepository;
import com.oujava.service.RatingService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author trann
 */
@Service
public class RatingServiceImpl implements RatingService{

    @Autowired
    private RatingRepository ratingRepo;
    
    @Override
    public List<Rating> getAllRating() {
        return this.ratingRepo.getAllRating();
    }

    @Override
    public void deleteRatingById(int id) {
        ratingRepo.deleteRatingById(id);
    }
    
}
