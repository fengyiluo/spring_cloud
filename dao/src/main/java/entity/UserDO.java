/**
 * sf.gmq.net
 * Copyright (C) 2012-2018 All Rights Reserved.
 */
package entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * 用户数据模型
 *
 * @author guominqiang
 * @version $Id UserDO.java, v 0.1 2018-03-19 14:01 guominqiang Exp $$
 */
@Entity
@Table(name = "tb_user")
public class UserDO implements Serializable {

    /**
     * 用户id
     **/
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 用户姓名
     **/
    @Column(name = "user_name")
    private String userName;

    /**
     * 用户密码
     **/
    @Column(name = "password")
    private String password;

    /**
     * 创建时间
     **/
    @Column(name = "user_create_date")
    private String createDate;

    /**
     * 部门
     **/
    @ManyToOne
    @JoinColumn(name = "department_id")
    @JsonBackReference
    private DepartmentDO department;

    /**
     * 角色列表
     **/
    @ManyToMany(cascade = {}, fetch = FetchType.EAGER)
    @JoinTable(name = "springboot_user_role", joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")}
    )
    private List<RoleDO> roleList;

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
     * Getter method for property <tt>userName</tt>.
     *
     * @return property value of userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Setter method for property <tt>userName</tt>.
     *
     * @param userName value to be assigned to property userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
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
    public DepartmentDO getDepartment() {
        return department;
    }

    /**
     * Setter method for property <tt>department</tt>.
     *
     * @param department value to be assigned to property department
     */
    public void setDepartment(DepartmentDO department) {
        this.department = department;
    }

    /**
     * Getter method for property <tt>roleList</tt>.
     *
     * @return property value of roleList
     */
    public List<RoleDO> getRoleList() {
        return roleList;
    }

    /**
     * Setter method for property <tt>roleList</tt>.
     *
     * @param roleList value to be assigned to property roleList
     */
    public void setRoleList(List<RoleDO> roleList) {
        this.roleList = roleList;
    }
}