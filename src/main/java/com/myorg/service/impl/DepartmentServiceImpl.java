package com.myorg.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.myorg.dao.BaseDao;
import com.myorg.dao.impl.DepartmentDao;
import com.myorg.entity.Department;
import com.myorg.service.DepartmentService;

@Service("departmentService")
public class DepartmentServiceImpl extends BaseServiceImpl<Department> implements
		DepartmentService {

	@Resource
	private DepartmentDao departmentDao;
	
	@Resource
	public void setDao(BaseDao<Department> dao) {
		super.setDao(departmentDao);
	}

}
