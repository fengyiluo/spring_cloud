/**
 * sf.gmq.net
 * Copyright (C) 2012-2018 All Rights Reserved.
 */
package model;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.util.List;

/**
 * 用户 领域模型
 *
 * @author guominqiang
 * @version $Id User.java, v 0.1 2018-03-19 17:54 guominqiang Exp $$
 */
public class User {
    /**
     * 用户id
     **/
    private String id;

    /**
     * 用户姓名
     **/
    private String name;

    /**
     * 用户密码
     **/
    private String password;

    /**
     * 创建时间
     **/
    private String createDate;

    /**
     * 部门
     **/
    private Department department;

    /**
     * 角色列表
     */
    private List<Role> roleList;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

    /**
     * Getter method for property <tt>id</tt>.
     *
     * @return property value of id
     */
    public String getId() {
        return id;
    }

    /**
     * Setter method for property <tt>id</tt>.
     *
     * @param id value to be assigned to property id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Getter method for property <tt>name</tt>.
     *
     * @return property value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter method for property <tt>name</tt>.
     *
     * @param name value to be assigned to property name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter method for property <tt>password</tt>.
     *
     * @return property value of password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter method for property <tt>password</tt>.
     *
     * @param password value to be assigned to property password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Getter method for property <tt>createDate</tt>.
     *
     * @return property value of createDate
     */
    public String getCreateDate() {
        return createDate;
    }

    /**
     * Setter method for property <tt>createDate</tt>.
     *
     * @param createDate value to be assigned to property createDate
     */
    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    /**
     * Getter method for property <tt>department</tt>.
     *
     * @return property value of department
     */
    public Department getDepartment() {
        return department;
    }

    /**
     * Setter method for property <tt>department</tt>.
     *
     * @param department value to be assigned to property department
     */
    public void setDepartment(Department department) {
        this.department = department;
    }

    /**
     * Getter method for property <tt>roleList</tt>.
     *
     * @return property value of roleList
     */
    public List<Role> getRoleList() {
        return roleList;
    }

    /**
     * Setter method for property <tt>roleList</tt>.
     *
     * @param roleList value to be assigned to property roleList
     */
    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }
}