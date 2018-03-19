/**
 * sf.gmq.net
 * Copyright (C) 2012-2018 All Rights Reserved.
 */
package service;

import entity.DepartmentDO;

/**
 * @author guominqiang
 * @version $Id DepartmentService.java, v 0.1 2018-03-19 14:59 guominqiang Exp $$
 */
public interface DepartmentService {

    /**
     * 保存部门数据
     *
     * @param departmentDO
     * @return
     */
    DepartmentDO saveDepartment(DepartmentDO departmentDO);

    /**
     * 根据部门id查找部门信息
     *
     * @param id
     * @return
     */
    DepartmentDO getDepartInfo(String id);
}
