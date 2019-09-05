package com.lane.feignconsumer.service;

import com.lane.entity.User;
import com.lane.feignconsumer.configuration.FullLoggerConfiguration;
import com.lane.feignconsumer.service.impl.HelloServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "hello-service",fallback = HelloServiceFallback.class,configuration = FullLoggerConfiguration.class)
public interface HelloService {

    @RequestMapping("/hello/lane")
    String hello();

    @RequestMapping(value = "/hello/lane1",method = RequestMethod.GET)
    String Hello(@RequestParam("name") String name);

    @RequestMapping(value = "/hello/lane2",method = RequestMethod.GET)
    User hello(@RequestHeader("name") String name,@RequestHeader("age") Integer age);

    @RequestMapping(value = "/hello/lane3",method = RequestMethod.POST)
    String hello(@RequestBody User user);

}
