package com.myorg.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.myorg.dao.BaseDao;
import com.myorg.dao.impl.DepartmentDao;
import com.myorg.entity.Department;
import com.myorg.entity.Pager;
import com.myorg.service.DepartmentService;

@Service("departmentService")
public class DepartmentServiceImpl extends BaseServiceImpl<Department> implements
		DepartmentService {

	@Resource
	private DepartmentDao departmentDao;
	
	@Override
	public void setDao(BaseDao<Department> dao) {
		super.setDao(departmentDao);
	}

	@Override
	public Pager<Department> findByPage(Integer currPage) {
		Pager<Department> pager = new Pager<Department>();
		pager.setCurrPageNumber(currPage);
		int pageSize = 10;
		pager.setPageSize(pageSize);
		int totalCount = departmentDao.findCount();
		pager.setTotalRecord(totalCount);
		double tc = totalCount;
		Double num = Math.ceil(tc / pageSize);
		pager.setTotalPageNumber(num.intValue());
		int pageOffset = (currPage - 1) * pageSize;
		List<Department> list = departmentDao.findByPage(pageOffset, pageSize);
		pager.setDatas(list);
		return pager;
	}

}
