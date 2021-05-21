/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.travelplanner.travelplanner.model;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 *
 * @author ashin
 */
@Embeddable
public class DayWeather implements Serializable {
    private String name;
    private String countrycode;
    private String pDate;
    private int pTime;
    private double minTemp;
    private double maxTemp;
    private String clouds;
    private String rain;
    private String cold;
    private double windspeed;
    private String weatherdesc;
    private String weathermain;
    private double avgTemp;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountrycode() {
        return countrycode;
    }

    public void setCountrycode(String countrycode) {
        this.countrycode = countrycode;
    }

    public String getpDate() {
        return pDate;
    }

    public void setpDate(String pDate) {
        this.pDate = pDate;
    }

    public int getpTime() {
        return pTime;
    }

    public void setpTime(int pTime) {
        this.pTime = pTime;
    }

    public double getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(double minTemp) {
        this.minTemp = minTemp;
    }

    public double getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(double maxTemp) {
        this.maxTemp = maxTemp;
    }

    public String getClouds() {
        return clouds;
    }

    public void setClouds(String clouds) {
        this.clouds = clouds;
    }

    public String getRain() {
        return rain;
    }

    public void setRain(String rain) {
        this.rain = rain;
    }

    public String getCold() {
        return cold;
    }

    public void setCold(String cold) {
        this.cold = cold;
    }

    public double getWindspeed() {
        return windspeed;
    }

    public void setWindspeed(double windspeed) {
        this.windspeed = windspeed;
    }

    public String getWeatherdesc() {
        return weatherdesc;
    }

    public void setWeatherdesc(String weatherdesc) {
        this.weatherdesc = weatherdesc;
    }

    public String getWeathermain() {
        return weathermain;
    }

    public void setWeathermain(String weathermain) {
        this.weathermain = weathermain;
    }

    public double getAvgTemp() {
        return avgTemp;
    }

    public void setAvgTemp(double avgTemp) {
        this.avgTemp = avgTemp;
    }
    
}
