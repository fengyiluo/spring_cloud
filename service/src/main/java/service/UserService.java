/**
 * sf.gmq.net
 * Copyright (C) 2012-2018 All Rights Reserved.
 */
package service;

import entity.UserDO;

import java.util.List;

/**
 * 用户服务类
 * @author guominqiang
 * @version $Id UserService.java, v 0.1 2018-03-19 14:30 guominqiang Exp $$
 */
public interface UserService {

    /**
     * 用户登录
     * @param userName
     * @param password
     * @return
     */
    UserDO login(String userName, String password);

    /**
     * 用户注册
     * @param userDO
     * @return
     */
    UserDO register(UserDO userDO);

    /**
     * 用户注销
     * @param userDO
     */
    void logout(UserDO userDO);

    /**
     * 检查当前用户是否已经存在
     * @param userDO
     * @return
     */
    boolean isExists(UserDO userDO);

    List<UserDO> getAllUser();

    UserDO getUserById(String id);

}
