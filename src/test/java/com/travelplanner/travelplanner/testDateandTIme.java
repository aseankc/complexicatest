/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.travelplanner.travelplanner;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ashin
 */
public class testDateandTIme {
    
    
    public static void main(String[] args) {
        Long timestamp = new Long(1621414800);
        String dateString = "2021-05-24 15:00:00";
        String dateT = dateString.substring(0,10);
        String timeT = dateString.substring(11, 19);
        System.out.println("date"+dateT+"time"+timeT);
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//LocalDateTime localDateTime = LocalDateTime.parse(dateString, formatter);
//        LocalDate date1 = LocalDate.parse(dateString, formatter);
//            System.out.println(localDateTime.getHour());
       
      
        
//        Date date = new Date();
//        date.parse("2021-05-24 03:00:00");
//        System.out.println("converted date:"+date.toLocaleString());
        
        Calendar mydate = Calendar.getInstance();
        mydate.setTimeInMillis(timestamp * 1000);
        System.out.println(mydate.get(Calendar.DAY_OF_MONTH)+"-"+(mydate.get(Calendar.MONTH)+1)+"-"+mydate.get(Calendar.YEAR));
        
        System.out.println("parshin"+ Integer.parseInt("55"));
        
    }
}
