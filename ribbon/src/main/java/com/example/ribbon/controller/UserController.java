package com.example.ribbon.controller;

import com.example.ribbon.service.UserService;
import com.lane.entity.User;
import com.sun.jersey.core.util.StringIgnoreCaseKeyComparator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping("/getUser")
    public User getUser(String id){
        System.out.println("this is getUser");
        return userService.findUser(id);
    }

    @RequestMapping("/getUsers")
    public List<User> getUsers(String ids){
        return userService.findUsers(ids);
    }

}
