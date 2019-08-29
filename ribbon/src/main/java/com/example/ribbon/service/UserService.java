package com.example.ribbon.service;


import com.lane.entity.User;

import java.util.List;

public interface UserService {
    public User findUser(String id);
    public List<User> findUsers(String ids);
}
