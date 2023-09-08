/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.oujava.repository;

import com.oujava.pojo.Rating;
import java.util.List;

/**
 *
 * @author trann
 */
public interface RatingRepository {
    List<Rating> getRatingOfCusId(int id);
    Boolean addOrUpdateRating(Rating rating);
    Boolean deleteRatingById(int id);
}
