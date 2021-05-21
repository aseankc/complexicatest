/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.travelplanner.travelplanner.services;

import ch.qos.logback.classic.Logger;
import com.travelplanner.travelplanner.model.CityWeather;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ashin
 */
@Service
public class CityWeatherService {
    
   @Autowired
   private CityWeatherRepository cityWeatherRepository;
   
   public CityWeather createRecord(CityWeather city){
       return cityWeatherRepository.save(city);
   }
   
   public List<CityWeather> createRecords(List<CityWeather> cities){
       return cityWeatherRepository.saveAll(cities);
   }
   
   public CityWeather getCityWeatherbyId(Long id){
       return cityWeatherRepository.findById(id).orElse(null);
   }
   
   public List<CityWeather> getAllCitiesWeather(){
       return cityWeatherRepository.findAll();
   }
   
   public List<CityWeather> getCityWeatherbyCityName(String cityName){
       List<CityWeather> col = getAllCitiesWeather().stream().filter(city -> city.getName().equals(cityName)).collect(Collectors.toList());
       
       if(col.isEmpty()){
           return null;
       }
       return col;
   }
   
   public boolean deleteCityWeather(CityWeather cityWeather){
       try{
          cityWeatherRepository.delete(cityWeather); 
       }catch(Exception ex){
           ex.printStackTrace();
           return false;
       }
       
       return true;
   }
   
   /*
   Udate method is hardly used for this project.
   */
   public CityWeather updateWeather(CityWeather cityWeather){
       CityWeather oldCity = cityWeatherRepository.findById(cityWeather.getId()).orElse(null);
       if(oldCity != null){
           oldCity.setName(cityWeather.getName());
           oldCity.setCold(cityWeather.getCold());
         
       }
       return cityWeather;
   }
   
   
}
