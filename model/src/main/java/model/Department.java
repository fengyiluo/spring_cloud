/**
 * sf.gmq.net
 * Copyright (C) 2012-2018 All Rights Reserved.
 */
package model;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 部门 领域模型
 *
 * @author guominqiang
 * @version $Id Department.java, v 0.1 2018-03-19 17:57 guominqiang Exp $$
 */
public class Department {

    /**
     * 部门id
     **/
    private String id;

    /**
     * 部门名称
     **/
    private String departmentName;

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
     * Getter method for property <tt>departmentName</tt>.
     *
     * @return property value of departmentName
     */
    public String getDepartmentName() {
        return departmentName;
    }

    /**
     * Setter method for property <tt>departmentName</tt>.
     *
     * @param departmentName value to be assigned to property departmentName
     */
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}