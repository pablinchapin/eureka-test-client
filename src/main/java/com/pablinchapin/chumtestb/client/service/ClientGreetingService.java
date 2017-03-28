/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablinchapin.chumtestb.client.service;

import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author pvargas
 */
@Service
public class ClientGreetingService {
    
    @Autowired
    @LoadBalanced
    
    protected RestTemplate restTemplate;
    protected String serviceUrl;
    
    protected Logger logger = Logger.getLogger(ClientGreetingService.class.getName());
    
    
    public ClientGreetingService(String serviceUrl){
        this.serviceUrl = serviceUrl.startsWith("http") ? serviceUrl : "http://"+serviceUrl;
    }
    
    
    @PostConstruct
    public void demoOnly(){
        logger.warning("Re RestTemplate request factory is "+restTemplate.getRequestFactory());
    }
    
    public Greeting greeting(String name){
        
        logger.info("greeting() invoked for " + name);
        
        Greeting greeting = restTemplate.getForObject(serviceUrl + "/greeting/{name}",Greeting.class, name);
        
        return greeting;
    }
    
    
}
