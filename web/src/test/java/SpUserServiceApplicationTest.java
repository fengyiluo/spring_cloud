/**
 * sf.gmq.net
 * Copyright (C) 2012-2018 All Rights Reserved.
 */

import entity.DepartmentDO;
import entity.UserDO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;
import service.DepartmentService;
import service.UserService;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 测试用例
 *
 * @author guominqiang
 * @version $Id SpUserServiceApplicationTest.java, v 0.1 2018-03-19 16:21 guominqiang Exp $$
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ComponentScan("sp_cloud")
public class SpUserServiceApplicationTest {

    /**
     * 日志记录
     **/
    private static final Logger LOGGER = LoggerFactory.getLogger(SpUserServiceApplicationTest.class);

    private static final SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static final SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");

    @Test
    public void contextLoads() {
    }


    @Autowired
    private DepartmentService departmentService;


    @Autowired
    private UserService userService;


    @Test
    public void testDepartmentService() {

        DepartmentDO department = new DepartmentDO();
        department.setDepName("dev");
        DepartmentDO result = departmentService.saveDepartment(department);

        LOGGER.info("add result " + result);


        String id = "1";
        result = departmentService.getDepartInfo(id);
        LOGGER.info("get department " + result);
    }


    @Test
    public void testUserRegister() throws Exception {
        UserDO user = new UserDO();
        user.setUserName("gmq");
        user.setPassword("123***456");
        user.setCreateDate(sdf1.format(new Date()));
        DepartmentDO department = departmentService.getDepartInfo("1");
        user.setDepartment(department);
        UserDO result = userService.register(user);
        LOGGER.info("register result " + result);

    }


    @Test
    public void testWriteOff() throws Exception {
        UserDO user = new UserDO();
        user.setUserName("gmq");
        user.setPassword("123***456");
        userService.logout(user);

    }


    @Test
    public void testUserLogin() throws Exception {
        UserDO user = new UserDO();
        user.setUserName("gmq");
        user.setPassword("123***456");
        UserDO result = userService.login(user.getUserName(), user.getPassword());
        LOGGER.info("login  " + result);

    }

    @Test
    public void testUserIsExist() throws Exception {

        UserDO user = new UserDO();
        user.setId("4");
        boolean result = userService.isExists(user);
        LOGGER.info("isExist  " + result);

    }

}