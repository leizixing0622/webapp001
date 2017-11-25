package com.myorg.service;

import com.myorg.entity.Pager;

import java.util.List;

public interface BaseService<T> {

    public T getById(int id);

    public T loadById(int id);

    public void add(T t);

    public void update(T t);

    public void delete(T t);

    public List<T> list(String hql, Object[] args);

    public List<T> list(String hql, Object arg);

    public List<T> list(String hql);

    public List<Object> listObj(String hql, Object[] args);

    public List<Object> listObj(String hql, Object arg);

    public List<Object> listObj(String hql);

    public Pager<T> getPage(String hql, Object[] args);

    public Pager<T> getPage(String hql, Object arg);

    public Pager<T> getPage(String hql);

    public Pager<Object> getObjPage(String hql, Object[] args);

    public Pager<Object> getObjPage(String hql, Object arg);

    public Pager<Object> getObjPage(String hql);

    public Object queryByHql(String hql, Object[] args);

    public Object queryByHql(String hql, Object arg);

    public Object queryByHql(String hql);

    public void executeByHql(String hql, Object[] args);

    public void executeByHql(String hql, Object arg);

    public void executeByHql(String hql);

}
