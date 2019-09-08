package com.lane.user.controller;

import com.lane.entity.User;
import org.apache.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/user")
public class UserController {

//    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
//
//    private static final org.apache.logging.log4j.Logger log = LogManager.getLogger(UserController.class);

    //log4j1
    private static final Logger logger = Logger.getLogger(UserController.class);

    private List<User> userList = new ArrayList<User>();

    public void init(){
        User u1=new User();
        u1.setId("1");
        u1.setName("lane1");
        User u2=new User();
        u2.setId("2");
        u2.setName("lane2");
        User u3=new User();
        u3.setId("3");
        u3.setName("lane3");
        userList.add(u1);
        userList.add(u2);
        userList.add(u3);
    }

    @ResponseBody
    @RequestMapping(value = "/getUser")
    public User getUser(String id){
        logger.info("info: before users init");
        logger.error("error: before users init");
        init();
        logger.info("info: after users init");
        logger.error("error: after users init");
        return userList.get(Integer.parseInt(id));
    }

    @ResponseBody
    @RequestMapping(value = "/getUsers")
    public List<User> getUsers(String ids){
        init();
        List<User> retUsers=new ArrayList<User>();
        String[] id = ids.split(",");
        for (int i = 0;i<id.length;i++){
            retUsers.add(userList.get(Integer.parseInt(id[i])));
        }
        return retUsers;
    }
}
