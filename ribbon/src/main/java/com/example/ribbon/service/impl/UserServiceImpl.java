package com.example.ribbon.service.impl;

import com.example.ribbon.service.UserService;
import com.lane.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public User findUser(String id) {
        System.out.println("findUser id: "+id);
        return restTemplate.getForObject("http://USER-SERVICE/user/getUser?id={1}",User.class,id);
    }

    @Override
    public List<User> findUsers(String ids) {
        return restTemplate.getForObject("http://USER-SERVICE/user/getUsers?ids={1}",List.class,ids);
    }
}
