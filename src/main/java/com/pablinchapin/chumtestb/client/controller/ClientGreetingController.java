/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablinchapin.chumtestb.client.controller;

import com.pablinchapin.chumtestb.client.service.ClientGreetingService;
import com.pablinchapin.chumtestb.client.service.Greeting;
import java.util.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author pvargas
 */
@Controller
public class ClientGreetingController {
    
    protected ClientGreetingService helloWorldService;
    
    protected Logger logger = Logger.getLogger(ClientGreetingController.class.getName());
    
    public ClientGreetingController(ClientGreetingService helloWorldService){
        this.helloWorldService = helloWorldService;
    }
    
    @RequestMapping("/greeting")
    public String goHome(){
        return "index";
    }
    
    
    @RequestMapping("/greeting/{name}")
    public String greeting(Model model, @PathVariable("name") String name){
        
        logger.info("helloWorld-service greeting() invoked :" +name);
        
        Greeting greeting = helloWorldService.greeting(name);
        
        logger.info("helloWorld-service greeting() found :" +greeting.getContent());
        
        model.addAttribute("greeting", greeting.getContent());
        
        return "greeting";
    }
    
    
}