package com.myorg.service;

import com.myorg.entity.Employee;

public interface EmployeeService extends BaseService<Employee> {

	Employee login(Employee employee);

}
