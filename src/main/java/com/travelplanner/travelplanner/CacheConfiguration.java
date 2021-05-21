/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.travelplanner.travelplanner;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

/**
 *
 * @author ashin
 * Class for Cache configuration to override CacheManager
 */
@Configuration
@ConditionalOnProperty(name = "spring.cache.names")
@EnableCaching
public class CacheConfiguration extends CachingConfigurerSupport{

    @Value("${spring.cache.names}")
    public String[] cacheNames;

    @Autowired
    public CacheManager cacheManager;

    @Bean
    @Override
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager("weatherData");
        
    }

    @ConditionalOnProperty(name = "spring.cache.autoexpiry", value = "true")
    @Scheduled(fixedDelayString = "${spring.cache.expire.delay:60}")
    public void cacheEvict() {
        cacheManager().getCacheNames().stream()
                .map(cacheManager::getCache)
                .forEach(Cache::clear);
    }
}
