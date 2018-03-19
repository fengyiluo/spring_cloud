/**
 * sf.gmq.net
 * Copyright (C) 2012-2018 All Rights Reserved.
 */
package entity;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 部门表数据模型
 *
 * @author guominqiang
 * @version $Id DepartmentDO.java, v 0.1 2018-03-19 13:57 guominqiang Exp $$
 */
@Entity
@Table(name = "tb_department")
public class DepartmentDO implements Serializable {

    /**
     * 部门id
     **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id")
    private String id;

    /**
     * 部门名称
     **/
    @Column(name = "department_name")
    private String depName;

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
     * Getter method for property <tt>depName</tt>.
     *
     * @return property value of depName
     */
    public String getDepName() {
        return depName;
    }

    /**
     * Setter method for property <tt>depName</tt>.
     *
     * @param depName value to be assigned to property depName
     */
    public void setDepName(String depName) {
        this.depName = depName;
    }
}