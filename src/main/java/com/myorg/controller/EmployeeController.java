package com.myorg.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myorg.entity.Employee;
import com.myorg.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Resource
	private EmployeeService employeeService;

	@RequestMapping("/input")
	public String input() {
		return "employee/input";
	}

	@RequestMapping("/login")
	@ResponseBody
	public Map<String, Object> login(@RequestBody Employee employee,
			HttpServletRequest httpServletRequest) {
		Map<String, Object> map = new HashMap<String, Object>();
		Employee existEmployee = employeeService.login(employee);
		if (existEmployee == null) {
			map.put("status", "error");
			map.put("msg", "用户名或密码错误");
			return map;
		} else {
			HttpSession httpSession = httpServletRequest.getSession();
			httpSession.setAttribute("existEmployee", existEmployee);
			map.put("status", "success");
			map.put("msg", "登录成功");
			return map;
		}
	}

}
