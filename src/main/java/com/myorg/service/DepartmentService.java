package com.myorg.service;

import com.myorg.entity.Department;
import com.myorg.entity.Pager;

public interface DepartmentService extends BaseService<Department> {

	Pager<Department> findByPage(Integer currPage);

}
