/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.oujava.service;

import com.oujava.pojo.Rating;
import java.util.List;

/**
 *
 * @author trann
 */
public interface RatingService {
    List<Rating> getAllRating();
    void deleteRatingById(int id);
}
