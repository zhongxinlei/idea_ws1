package com.lane.demo.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/hello")
public class HelloController {

    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private Registration registration;

    @Autowired
    private DiscoveryClient client;

    public ServiceInstance serviceInstance() {
        List<ServiceInstance> list = client.getInstances(registration.getServiceId());
        if (list != null && list.size() > 0) {
            for(ServiceInstance itm : list){
                if(itm.getPort() == 8081||itm.getPort()==8082)
                    return itm;
            }
        }
        return null;
    }

    @RequestMapping("/lane")
    public String hello(){
        //sleep
        int sleepTime = new Random().nextInt(3000);
        logger.info("sleep time is: "+sleepTime);
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ServiceInstance instance = serviceInstance();
        logger.info("hello host: "+instance.getHost()+", serviceId: "+instance.getServiceId());
        return "hello lane!";
    }


}
