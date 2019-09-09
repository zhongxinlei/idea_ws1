package com.lane.configclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class TestController2 {

    @Autowired
    private Environment evn;

    @RequestMapping("/from2")
    public String from2(){
        return evn.getProperty("from","undefined");
    }

}
