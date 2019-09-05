package com.lane.demo.controller;

import com.lane.entity.User;
import com.lane.service.HelloService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RefactorController implements HelloService {
    @Override
    public String hello(@RequestParam("name") String name) {
        return "refactor "+name;
    }

    @Override
    public User hello(@RequestHeader("name") String name, @RequestHeader("age") Integer age) {
        return new User("cat",29);
    }

    @Override
    public String hello(@RequestBody User user) {
        return "refactor "+user.getName()+" age:"+user.getAge();
    }

}
