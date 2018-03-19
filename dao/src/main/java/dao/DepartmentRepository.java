/**
 * sf.gmq.net
 * Copyright (C) 2012-2018 All Rights Reserved.
 */
package dao;

import entity.DepartmentDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author guominqiang
 * @version $Id DepartmentRepository.java, v 0.1 2018-03-19 14:08 guominqiang Exp $$
 */
@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentDO, Long> {

}
