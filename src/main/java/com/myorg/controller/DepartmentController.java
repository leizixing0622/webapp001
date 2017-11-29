package com.myorg.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myorg.entity.Department;
import com.myorg.entity.Pager;
import com.myorg.service.DepartmentService;

@Controller
@RequestMapping("/department")
public class DepartmentController {

	@Resource
	private DepartmentService departmentService;

	private Integer currPage;

	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}

	@RequestMapping("/findAll")
	public String findAll() {
		Pager<Department> pager = departmentService.findByPage(currPage);
	}

}
