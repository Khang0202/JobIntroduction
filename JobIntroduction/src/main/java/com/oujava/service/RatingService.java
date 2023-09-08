/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.oujava.service;

import com.oujava.pojo.Rating;
import com.oujava.pojo.User;
import java.util.List;

/**
 *
 * @author trann
 */
public interface RatingService {
    List<Rating> getRatingOfCusId(int id);
    Boolean addOrUpdateRating(Rating rating);
    Boolean deleteRatingById(int id);
}
