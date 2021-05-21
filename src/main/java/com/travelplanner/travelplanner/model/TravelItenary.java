/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.travelplanner.travelplanner.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author ashin
 */
@Entity
public class TravelItenary implements Serializable {
   
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    
   @ElementCollection
    private List<DayWeather> lists= new ArrayList();

   

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<DayWeather> getLists() {
        return lists;
    }

    public void setLists(List<DayWeather> lists) {
        
        this.lists=lists;
    }
    
    
    
}
