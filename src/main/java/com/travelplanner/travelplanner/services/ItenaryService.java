/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.travelplanner.travelplanner.services;

import com.travelplanner.travelplanner.model.TravelItenary;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ashin
 */
@Service
public class ItenaryService {
    
    @Autowired
    private ItenaryRepository itenaryRepository;
    
    public TravelItenary createItenary(TravelItenary itenary){
        
        return itenaryRepository.save(itenary);
    }
    
    public boolean deleteItenary(TravelItenary itenary){
         try{
          itenaryRepository.delete(itenary); 
       }catch(Exception ex){
           return false;
       }
       
       return true;
    }
    
    public List<TravelItenary> getAllItenary(){
        List<TravelItenary> result= itenaryRepository.findAll();
        result.forEach(item->{
            System.out.println("name"+item.getName());
            System.out.println("list of destination"+item.getLists().size());
        });
        return result;
    }
    
    public TravelItenary getItenary(String name){
        return itenaryRepository.findByname(name);
    }
}
