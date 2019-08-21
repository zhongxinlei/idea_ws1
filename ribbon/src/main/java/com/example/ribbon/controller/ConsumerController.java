package com.example.ribbon.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ConsumerController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/ribbon-consumer",method = RequestMethod.GET)
    public String helloConsumer(){
        return restTemplate.getForEntity("http://HELLO-SERVICE/hello/lane",String.class).getBody();
    }

    public static void main(String[] args) {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("a","A");
        map.put("b","B");
        System.out.println(map.entrySet());
        System.out.println(map.toString());
        for (Map.Entry<String,Object> entry:map.entrySet()){
            System.out.println(entry.getKey());
        }
    }
}
