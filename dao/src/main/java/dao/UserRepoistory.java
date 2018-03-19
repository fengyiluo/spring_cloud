/**
 * sf.gmq.net
 * Copyright (C) 2012-2018 All Rights Reserved.
 */
package dao;

import entity.UserDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

/**
 * @author guominqiang
 * @version $Id UserRepoistory.java, v 0.1 2018-03-19 14:10 guominqiang Exp $$
 */
@Repository
public interface UserRepoistory extends JpaRepository<UserDO, Long> {


    /**
     * 通过id和name查找用户
     *
     * @param id
     * @param userName
     * @return
     */
    UserDO findByIdAndName(String id, String userName);

    /**
     * 通过用户名称和密码查询用户
     *
     * @param userName
     * @param password
     * @return
     */
    UserDO findByNameAndPassword(String userName, String password);

    /**
     * 通过用户id和用户名称查找用户
     *
     * @param id
     * @param name
     * @return
     */
    UserDO findByIdOrName(String id, String name);

    /**
     * 查询在某一时间段之前登录的所有用户
     *
     * @param startTime
     * @return
     */
    List<UserDO> getByCreateDateLessThan(String startTime);

    /**
     * 查询在某一时间段之后登录的所有用户列表
     *
     * @param startTime
     * @return
     */
    List<UserDO> findByCreateDateGreaterThan(String startTime);

    List<UserDO> findByNameIsNull();

    /**
     * 查询已经登录的用户
     *
     * @param nameList
     * @return
     */
    List<UserDO> findByNameIn(Collection<String> nameList);
}
