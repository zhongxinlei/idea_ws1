package com.lane.feignconsumer.service.impl;

import com.lane.entity.User;
import com.lane.feignconsumer.service.HelloService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@Component
public class HelloServiceFallback implements HelloService {
    @Override
    public String hello() {
        return "hello error";
    }

    @Override
    public String Hello(@RequestParam("name") String name) {
        return "hello1 error: "+name;
    }

    @Override
    public User hello(@RequestHeader("name") String name, @RequestHeader("age") Integer age) {
        return new User("unkown name",0);
    }

    @Override
    public String hello(@RequestBody User user) {
        return "hello3 error";
    }
}
