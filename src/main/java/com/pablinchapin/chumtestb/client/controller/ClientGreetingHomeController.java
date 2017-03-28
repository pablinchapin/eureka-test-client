/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablinchapin.chumtestb.client.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author pvargas
 */
@Controller
public class ClientGreetingHomeController {
    
    @RequestMapping("/")
    public String home(){
        return "index";
    }
            
}
