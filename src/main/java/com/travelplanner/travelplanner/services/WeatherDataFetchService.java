/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.travelplanner.travelplanner.services;

import com.travelplanner.travelplanner.model.CityWeather;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author ashin
 */
@Service
public class WeatherDataFetchService {
    
 
  private String forcastWeatherAPI = "http://api.openweathermap.org/data/2.5/forecast?q=";
  private String units = "&units=metric"; // metric
  private String lang = "&lang=en";
  private String apiKey = "&appid=e77b7491f30385e3573037cc23f7bd8e";
 
  @Autowired
  private CityWeatherService cityWeatherService;
  
  @Cacheable(cacheNames= "weatherData", key = "#cityName")
  public List<CityWeather> getForcastData(String cityName){
      System.out.println("printing the request");
      RestTemplate restTemplate = new RestTemplate();
      ResponseEntity<String> responseEntity = restTemplate.getForEntity(forcastWeatherAPI+cityName+units+lang+apiKey, String.class);
      String responseString = responseEntity.getBody();
      
      List<CityWeather> returnList = new ArrayList<>();
      try {
          returnList=parseJsonResponse(responseString);
      } catch (Exception ex) {
          Logger.getLogger(WeatherDataFetchService.class.getName()).log(Level.SEVERE, null, ex);
      }
      
      return returnList;
   }
  
  private List<CityWeather> parseJsonResponse(String responseString) throws Exception{
      JSONObject jObj = new JSONObject(responseString);
      JSONObject citydetails = jObj.getJSONObject("city");
      List<CityWeather> weatherList = new ArrayList();
      JSONArray listofForcast = jObj.getJSONArray("list");
      
     listofForcast.forEach(item -> {
         JSONObject jobj = (JSONObject)item;
         String dateAndTime =jobj.has("dt_txt")?jobj.getString("dt_txt"):"";
         
         
            CityWeather cObj = new CityWeather();
            cObj.setpDate(getDateString(dateAndTime));
            cObj.setpTime(getTimeString(dateAndTime));
            cObj.setName(citydetails.getString("name"));
            cObj.setCountrycode(citydetails.getString("country"));
         
            cObj.setWeatherdesc(jobj.getJSONArray("weather").getJSONObject(0).get("description").toString());
            cObj.setWeathermain(jobj.getJSONArray("weather").getJSONObject(0).get("main").toString());
            cObj.setAvgTemp(Double.parseDouble(jobj.getJSONObject("main").get("temp").toString()));
            cObj.setMaxTemp(Double.parseDouble(jobj.getJSONObject("main").get("temp_max").toString()));
            cObj.setMinTemp(Double.parseDouble(jobj.getJSONObject("main").get("temp_min").toString()));
            weatherList.add(cObj);
     
         
     });
     System.out.println("printing the size of the list "+weatherList.size());
     saveSearchHistory(weatherList);
     return weatherList; 
  }
  
  private String getDateString(String dateString){
      String dateStr = dateString.substring(0,10);
      return dateStr;
  }
  
  private String getTimeString(String dateString){
       String timeStr = dateString.substring(11, 19);
       return timeStr;
  }
  
  private void saveSearchHistory(List<CityWeather> list){
      cityWeatherService.createRecords(list);
      
      System.out.println("checking the save");
      System.out.println("--"+cityWeatherService.getAllCitiesWeather().size());
  }

  // Method to filter date on the format of yyyy-mm-dd
    public CityWeather filterwitDate(String date,List<CityWeather> list) {
        System.out.println("in filter method");
       
        CityWeather filtered = list.stream().filter(item-> (item.getpDate() == null ? date == null : item.getpDate().equals(date)) && "15:00:00".equals(item.getpTime())).findFirst().orElse(list.get(0));
        return filtered;
    }
  

}
