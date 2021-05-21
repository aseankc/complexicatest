/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.travelplanner.travelplanner.services;

import com.travelplanner.travelplanner.model.TravelItenary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ashin
 */
@Repository
public interface ItenaryRepository extends JpaRepository<TravelItenary, Long>{
    
    
    TravelItenary findByname(String name);
}
