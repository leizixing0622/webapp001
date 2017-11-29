package com.myorg.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.myorg.entity.Employee;

@Repository("employeeDao")
public class EmployeeDao extends BaseDaoImpl<Employee> {

	public Employee findByUsernameAndPassword(Employee employee) {
		String hql = "from Employee where username = ? and password = ?";
		List<Employee> list = list(hql, new Object[]{employee.getUsername(), employee.getPassword()});
		if(list.size() > 0){
			return list.get(0);
		}
		return null;
	}

}
