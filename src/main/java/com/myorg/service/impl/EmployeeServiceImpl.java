package com.myorg.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.myorg.dao.BaseDao;
import com.myorg.dao.impl.EmployeeDao;
import com.myorg.entity.Employee;
import com.myorg.service.EmployeeService;

@Service("employeeService")
public class EmployeeServiceImpl extends BaseServiceImpl<Employee> implements EmployeeService{

	@Resource
	private EmployeeDao employeeDao; 
	
	@Resource
	public void setDao(BaseDao<Employee> dao) {
		super.setDao(employeeDao);
	}

	@Override
	public Employee login(Employee employee) {
		Employee existEmployee = employeeDao.findByUsernameAndPassword(employee);
		return existEmployee;
	}
	
}
