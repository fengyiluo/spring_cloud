/**
 * sf.gmq.net
 * Copyright (C) 2012-2018 All Rights Reserved.
 */
package service.impl;

import dao.DepartmentRepository;
import entity.DepartmentDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.DepartmentService;

import javax.transaction.Transactional;

/**
 * @author guominqiang
 * @version $Id DepartmentServiceImpl.java, v 0.1 2018-03-19 15:02 guominqiang Exp $$
 */
@Transactional
@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDO saveDepartment(DepartmentDO departmentDO) {
        return departmentRepository.save(departmentDO);
    }

    @Override
    public DepartmentDO getDepartInfo(String id) {
        return departmentRepository.findOne(Long.parseLong(id));
    }
}