package com.lane.feignconsumer.controller;

import com.lane.entity.User;
import com.lane.feignconsumer.service.HelloService;
import com.lane.feignconsumer.service.RefactorHelloService;
import org.apache.logging.log4j.LogManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

    //sfl4j
    private static final Logger logger = LoggerFactory.getLogger(ConsumerController.class);

    //log4j2
    private static final org.apache.logging.log4j.Logger log = LogManager.getLogger(ConsumerController.class);

    @Autowired
    private HelloService helloService;

    @Autowired
    private RefactorHelloService refactorHelloService;

    @RequestMapping(value = "/feign-consumer",method = RequestMethod.GET)
    public String helloConsumer(){
        logger.info("feign-consumer info!");
        logger.error("feign-consumer error!");
        logger.debug("feign-consumer debug!");
        System.out.println("-------------------------------------------------------------------------------------");
        log.info("feign-consumer info!");
        log.error("feign-consumer error!");
        log.debug("feign-consumer debug!");
        return helloService.hello();
    }

    @RequestMapping(value = "/feign-consumer2",method = RequestMethod.GET)
    public String helloConsumer2(){
        StringBuffer sb = new StringBuffer();
        sb.append(helloService.Hello("laneString")+"\n");
        sb.append(helloService.hello("lane2",33)+"\n");
        sb.append(helloService.hello(new User("laneUser",33))+"\n");
        return sb.toString();
    }

    @RequestMapping(value = "/feign-consumer3",method = RequestMethod.GET)
    public String helloConsumer3(){
        StringBuffer sb = new StringBuffer();
        sb.append(refactorHelloService.hello("laneString")+"\n");
        sb.append(refactorHelloService.hello("lane2",33)+"\n");
        sb.append(refactorHelloService.hello(new User("laneUser",33))+"\n");
        return sb.toString();
    }

}
