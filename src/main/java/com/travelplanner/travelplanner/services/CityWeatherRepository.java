/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.travelplanner.travelplanner.services;

import com.travelplanner.travelplanner.model.CityWeather;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author ashin
 */
public interface CityWeatherRepository extends JpaRepository<CityWeather, Long>{
    
}
