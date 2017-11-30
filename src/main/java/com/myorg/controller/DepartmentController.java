package com.myorg.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myorg.entity.Department;
import com.myorg.entity.Pager;
import com.myorg.service.DepartmentService;

@Controller
@RequestMapping("/department")
public class DepartmentController {

	@Resource
	private DepartmentService departmentService;

	@RequestMapping("/list")
	public String findAll(
			ModelMap map,
			@RequestParam(value = "currPage", required = false, defaultValue = "1") Integer currPage) {
		Pager<Department> pager = departmentService.findByPage(currPage);
		map.put("pager", pager);
		return "department/list";
	}
	
	@RequestMapping("/input")
	public String input(){
		return "department/input";
	}

	
	@RequestMapping("/save")
	@ResponseBody
	public Map<String, Object> save(@RequestBody Department department){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			departmentService.add(department);
			map.put("status", "success");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("status", "failed");
		}
		return map;
	}
	
	@RequestMapping("/updatePage")
	public String updatePage(@RequestParam(value="did") Integer did, ModelMap map){
		Department department = departmentService.getById(did);
		map.put("department", department);
		return "department/update";
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public Map<String, Object> update(@RequestBody Department department){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			departmentService.update(department);
			map.put("status", "success");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("status", "failed");
		}
		return map;
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public Map<String, Object> delete(@RequestParam(value="did") Integer did){
		Map<String, Object> map = new HashMap<String, Object>();
		Department department = departmentService.getById(did);
		try {
			departmentService.delete(department);
			map.put("status", "success");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("status", "failed");
		}
		return map;
	}
}
