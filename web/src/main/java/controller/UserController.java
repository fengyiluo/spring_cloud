/**
 * sf.gmq.net
 * Copyright (C) 2012-2018 All Rights Reserved.
 */
package controller;

import entity.UserDO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import service.UserService;
import util.LoggerUtil;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 用户控制器
 *
 * @author guominqiang
 * @version $Id UserController.java, v 0.1 2018-03-19 15:09 guominqiang Exp $$
 */
@RestController
public class UserController {

    /**
     * 日志打印
     **/
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);


    private static final SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static final SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private UserService userService;

    /**
     * 搜索用户列表
     *
     * @return
     */
    @GetMapping("/searchUserList")
    public List<UserDO> searchUserList() {
        ServiceInstance instance = discoveryClient.getLocalServiceInstance();
        LoggerUtil.info(LOGGER, "call user/list service  host is  {0} service_id is {1}",
                instance.getHost(), instance.getServiceId());
        return userService.getAllUser();
    }

    /**
     * 用户登陆
     *
     * @param name
     * @param password
     * @return
     */
    @PostMapping("/login")
    public UserDO login(@RequestParam String name, @RequestParam String password) {
        UserDO user = userService.login(name, password);
        return user;
    }

    /**
     * 用户注册
     *
     * @param user
     * @return
     */
    @PostMapping("/register")
    public String register(@ModelAttribute UserDO user) {
        UserDO result = userService.register(user);
        return result != null ? "success" : "fail";
    }

    /**
     * 获取用户信息
     *
     * @param id
     * @return
     */
    @GetMapping("/get/{id}")
    public UserDO get(@PathVariable String id) {

        return userService.getUserById(id);
    }

    /**
     * 更新用户信息
     *
     * @param id
     * @param user
     * @return
     */
    @PutMapping("/update/{id}")
    public String update(@PathVariable String id, @ModelAttribute UserDO user) {

        UserDO updatedUser = userService.getUserById(id);
        updatedUser.setUserName(user.getUserName());
        updatedUser.setPassword(user.getPassword());
        updatedUser.setCreateDate(sdf1.format(new Date()));
        UserDO result = userService.register(updatedUser);
        return result != null ? "success" : "fail";

    }

    /**
     * 用户注销
     *
     * @param id
     * @return
     */

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable String id) {

        UserDO user = new UserDO();
        user.setId(id);
        userService.logout(user);

        return "success";
    }
}