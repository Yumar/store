/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.polasoft.online.store.model.repository;

import com.polasoft.online.store.model.entity.Rating;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author yumar
 */
public interface RatingRepository extends CrudRepository<Rating, Long> {
    
}
