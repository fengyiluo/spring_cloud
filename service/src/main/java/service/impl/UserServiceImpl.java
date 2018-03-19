/**
 * sf.gmq.net
 * Copyright (C) 2012-2018 All Rights Reserved.
 */
package service.impl;

import dao.UserRepoistory;
import entity.UserDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.UserService;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author guominqiang
 * @version $Id UserServiceImpl.java, v 0.1 2018-03-19 14:46 guominqiang Exp $$
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepoistory userRepoistory;

    @Override
    public UserDO login(String userName, String password) {
        return userRepoistory.findByNameAndPassword(userName, password);
    }

    @Override
    public UserDO register(UserDO userDO) {
        return userRepoistory.save(userDO);
    }

    @Override
    public void logout(UserDO userDO) {
        userRepoistory.delete(userDO);
    }

    @Override
    public boolean isExists(UserDO userDO) {
        return userRepoistory.findOne(Long.parseLong(userDO.getId())) != null ? true : false;
    }

    @Override
    public List<UserDO> getAllUser() {
        return userRepoistory.findAll();
    }

    @Override
    public UserDO getUserById(String id) {
        return userRepoistory.findOne(Long.parseLong(id));
    }
}