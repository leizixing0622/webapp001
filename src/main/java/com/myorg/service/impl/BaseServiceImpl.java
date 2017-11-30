package com.myorg.service.impl;

import com.myorg.dao.BaseDao;
import com.myorg.entity.Department;
import com.myorg.entity.Pager;
import com.myorg.service.BaseService;

import javax.annotation.Resource;

import java.util.List;

public abstract class BaseServiceImpl<T> implements BaseService<T> {

    private BaseDao<T> dao;

    public void setDao(BaseDao<T> dao) {
        this.dao = dao;
    }

    public T getById(int id) {
        return dao.getById(id);
    }

    public T loadById(int id) {
        return dao.loadById(id);
    }

    public void add(T t) {
        dao.add(t);
    }

    public void update(T t) {
        dao.update(t);
    }

    public void delete(T t) {
        dao.delete(t);
    }

    public List<T> list(String hql, Object[] args) {
        return dao.list(hql, args);
    }

    public List<T> list(String hql, Object arg) {
        return dao.list(hql, arg);
    }

    public List<T> list(String hql) {
        return dao.list(hql);
    }

    public List<Object> listObj(String hql, Object[] args) {
        return dao.listObj(hql, args);
    }

    public List<Object> listObj(String hql, Object arg) {
        return dao.listObj(hql, arg);
    }

    public List<Object> listObj(String hql) {
        return dao.listObj(hql);
    }

    public Pager<T> getPage(String hql, Object[] args) {
        return dao.getPage(hql, args);
    }

    public Pager<T> getPage(String hql, Object arg) {
        return dao.getPage(hql, arg);
    }

    public Pager<T> getPage(String hql) {
        return dao.getPage(hql);
    }

    public Pager<Object> getObjPage(String hql, Object[] args) {
        return dao.getObjPage(hql, args);
    }

    public Pager<Object> getObjPage(String hql, Object arg) {
        return dao.getObjPage(hql, arg);
    }

    public Pager<Object> getObjPage(String hql) {
        return dao.getObjPage(hql);
    }

    public Object queryByHql(String hql, Object[] args) {
        return dao.queryByHql(hql, args);
    }

    public Object queryByHql(String hql, Object arg) {
        return dao.queryByHql(hql, arg);
    }

    public Object queryByHql(String hql) {
        return dao.queryByHql(hql);
    }

    public void executeByHql(String hql, Object[] args) {
        dao.executeByHql(hql, args);
    }

    public void executeByHql(String hql, Object arg) {
        dao.executeByHql(hql, arg);
    }

    public void executeByHql(String hql) {
        dao.executeByHql(hql);
    }

	@Override
	public Pager<T> findByPage(Integer currPage) {
		Pager<T> pager = new Pager<T>();
		pager.setCurrPageNumber(currPage);
		int pageSize = 10;
		pager.setPageSize(pageSize);
		int totalCount = dao.findCount();
		pager.setTotalRecord(totalCount);
		double tc = totalCount;
		Double num = Math.ceil(tc / pageSize);
		pager.setTotalPageNumber(num.intValue());
		int pageOffset = (currPage - 1) * pageSize;
		List<T> list = dao.findByPage(pageOffset, pageSize);
		pager.setDatas(list);
		return pager;
	}
    
}
