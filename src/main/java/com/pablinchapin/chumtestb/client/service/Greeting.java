/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablinchapin.chumtestb.client.service;


import com.fasterxml.jackson.annotation.JsonRootName;
/**
 *
 * @author pvargas
 */
@JsonRootName("Greeting")
public class Greeting {
    
    protected String content;
    
    protected Greeting(){
        this.content = "Hello!";
    }
    
    public Greeting(String content){
        this.content = content;
    }
    
    
    public String getContent(){
        return content;
    }
            
    
}
