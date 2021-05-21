/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.travelplanner.travelplanner.controller;

import com.travelplanner.travelplanner.model.CityWeather;
import com.travelplanner.travelplanner.model.TravelItenary;
import com.travelplanner.travelplanner.services.ItenaryService;
import com.travelplanner.travelplanner.services.WeatherDataFetchService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ashin
 */
@RestController
@CrossOrigin(origins="http://localhost:3000")
public class QueryController {
   
   
    @Autowired
    private ItenaryService itenaryService;
    
    @Autowired
    private WeatherDataFetchService weatherDataFetchService;
    
    @GetMapping("/searchCity")
    public CityWeather getWeatherData(@RequestParam("city") String city,@RequestParam("date") String date){
        System.out.println("in a get weatherdata method");
//        List<CityWeather> resultList=weatherDataFetchService.getForcastData(city);
        CityWeather result = weatherDataFetchService.filterwitDate(date,weatherDataFetchService.getForcastData(city));
        return result;
        
    }
    
  
    @GetMapping("/itenaries")
    public List<TravelItenary> getItenaries(){
        List itenaryList = itenaryService.getAllItenary();
        
        return itenaryList;
    }
    
    @PostMapping(value="/saveItenary",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public TravelItenary saveItenary(@RequestBody TravelItenary itenary){
      
        TravelItenary saved= itenaryService.createItenary(itenary);
        System.out.println("testing=="+saved.getLists().size());
        return saved;
    }
    
    @GetMapping("/itenary/{name}")
    public TravelItenary getItenary(@PathVariable String name){
        TravelItenary itenary = itenaryService.getItenary(name);
        return itenary;
    }
}
