package com.lane.feignconsumer.service;

import com.lane.service.HelloService;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("hello-service")
public interface RefactorHelloService extends HelloService {
}
