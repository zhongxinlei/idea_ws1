package com.example.ribbon.controller;

import com.example.ribbon.service.UserService;
import com.lane.entity.User;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    //slf4j
//    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    //log4j2
    public static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping("/getUser")
    public User getUser(String id){
        log.info("log4j2 info: this is getUser");
        log.debug("log4j2 debug:this is getUser");
        log.error("log4j2 error:this is getUser");
        System.out.println("---------------------------------------------------------------");
//        logger.info("slf4j info: this is getUser");
//        logger.debug("slf4j debug:this is getUser");
//        logger.error("slf4j error:this is getUser");
        return userService.findUser(id);
    }

    @RequestMapping("/getUsers")
    public List<User> getUsers(String ids){
        return userService.findUsers(ids);
    }

}
