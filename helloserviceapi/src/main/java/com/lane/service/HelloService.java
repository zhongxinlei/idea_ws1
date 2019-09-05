package com.lane.service;

import com.lane.entity.User;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/refactor")
public interface HelloService {

    @RequestMapping(value = "/lane4",method = RequestMethod.GET)
    public String hello(@RequestParam String name);

    @RequestMapping(value = "/lane5",method = RequestMethod.GET)
    public User hello(@RequestHeader String name, @RequestHeader Integer age);

    @RequestMapping(value = "/lane6",method = RequestMethod.POST)
    public String hello(@RequestBody User user);
}
