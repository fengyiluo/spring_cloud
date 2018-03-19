/**
 * sf.gmq.net
 * Copyright (C) 2012-2018 All Rights Reserved.
 */
package controller.server;

import model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import util.LoggerUtil;

import java.util.Arrays;
import java.util.List;

/**
 * 用户控制器(服务端)
 *
 * @author guominqiang
 * @version $Id UserServerController.java, v 0.1 2018-03-19 17:50 guominqiang Exp $$
 */
@RestController
public class UserServerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServerController.class);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    /**
     * 获取用户信息
     *
     * @param id
     * @return
     */
    @GetMapping("user/get/{id}")
    public User get(@PathVariable String id) {

        return this.restTemplate.getForObject("http://SPRINGCLOUD-PROVIDER-USER-SERVICE/get/id={1}", User.class, id);
    }

    /**
     * 登录
     *
     * @param name
     * @param password
     * @return
     */
    @PostMapping("/login")
    public User login(@RequestParam String name, @RequestParam String password) {

        LoggerUtil.info(LOGGER, "call user service login method");
        ResponseEntity<User> responseEntity = restTemplate.getForEntity(
                "http://SPRINGCLOUD-PROVIDER-USER-SERVICE/login?name={1},password={2}", User.class, name, password);
        return responseEntity.getBody();
    }

    /**
     * 查询用户列表
     *
     * @return
     */
    @GetMapping("/getUserList")
    public List<User> getUserList() {
        User[] users = restTemplate.getForObject("http://SPRINGCLOUD-PROVIDER-USER-SERVICE/list", User[].class);
        List<User> userList = Arrays.asList(users);
        return userList;
    }

    /**
     * ribbon负载均衡测试方法
     */
    @GetMapping("/log-user-service-instance")
    public void logUserServiceInstance() {

        ServiceInstance serviceInstance = this.loadBalancerClient.choose("springcloud-provider-user-service");

        LoggerUtil.info(LOGGER, "serviceInstance info ---> serviceId is  {0}, host is {1},port is {2}",
                serviceInstance.getServiceId(), serviceInstance.getHost(), serviceInstance.getPort());
    }
}