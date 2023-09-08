/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oujava.service.impl;

import com.oujava.pojo.Rating;
import com.oujava.repository.RatingRepository;
import com.oujava.repository.UserRepository;
import com.oujava.service.RatingService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author trann
 */
@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepository ratingRepo;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Rating> getRatingOfCusId(int id) {
        return ratingRepo.getRatingOfCusId(id);

    }

    @Override
    public Boolean addOrUpdateRating(Rating rating) {
        if (!rating.getComment().isEmpty() || !rating.getComment().equals("")) {
            if (!rating.getComment().isEmpty()) {
                return ratingRepo.addOrUpdateRating(rating);
            }else{
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public Boolean deleteRatingById(int id) {
        if(id >= 1){
            return ratingRepo.deleteRatingById(id);
        }else{
            return false;
        }
    }

}
