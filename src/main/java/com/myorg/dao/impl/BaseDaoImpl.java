package com.myorg.dao.impl;

import com.myorg.dao.BaseDao;
import com.myorg.entity.Pager;
import com.myorg.entity.SystemContext;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.ParameterizedType;
import java.util.List;

@SuppressWarnings("unchecked")
public abstract class BaseDaoImpl<T> implements BaseDao<T> {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    private Class<T> cls;
    
	public BaseDaoImpl() {
        ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
        cls = (Class<T>) type.getActualTypeArguments()[0];
    }

    public T getById(int id) {
        return (T) getSession().get(cls, id);
    }

    public T loadById(int id) {
        return (T) getSession().load(cls, id);
    }

    public void add(T t) {
        getSession().save(t);
    }

    public void update(T t) {
        getSession().update(t);
    }

    public void delete(T t) {
        getSession().delete(t);
    }

    public List<T> list(String hql, Object[] args) {
        Query query = getSession().createQuery(hql);
        for (int i = 0; i < args.length; i++) {
            query.setParameter(i, args[i]);
        }
        return query.list();
    }

    public List<T> list(String hql, Object arg) {
        return this.list(hql, new Object[]{arg});
    }

    public List<T> list(String hql) {
        return this.list(hql, null);
    }

    public Pager<T> getPage(String hql, Object[] args) {
        int pageSize = SystemContext.getPageSize();
        int pageOffset = SystemContext.getPageOffset();
        if (pageSize <= 0) pageSize = 10;
        if (pageOffset <= 0) pageOffset = 0;
        Query query = getSession().createQuery(hql);
        for (int i = 0; i < args.length; i++) {
            query.setParameter(i, args[i]);
        }
        query.setFirstResult(pageOffset).setMaxResults(pageSize);
        String cHql = getCountFromHql(hql);
        Query cQuery = getSession().createQuery(cHql);
        for (int i = 0; i < args.length; i++) {
            query.setParameter(i, args[i]);
        }
        Pager<T> pager = new Pager<T>();
        pager.setPageOffset(pageOffset);
        pager.setPageSize(pageSize);
        List<T> list = query.list();
        pager.setDatas(list);
        Long totalRecord = (Long) cQuery.uniqueResult();
        pager.setTotalRecord(totalRecord);
        return pager;
    }

    public String getCountFromHql(String hql) {
        String s = hql.substring(0, hql.indexOf("from"));
        if (s == null || s.equals("")) {
            hql = "SELECT COUNT(*) " + hql;
        }
        hql = hql.replace(s, "SELECT COUNT(*) ");
        hql = hql.replace("FETCH", "");
        return hql;
    }

    public Pager<T> getPage(String hql, Object arg) {
        return this.getPage(hql, new Object[]{arg});
    }

    public Pager<T> getPage(String hql) {
        return this.getPage(hql, null);
    }

    public Object queryByHql(String hql, Object[] args) {
        Query query = getSession().createQuery(hql);
        for (int i = 0; i < args.length; i++) {
            query.setParameter(i, args[i]);
        }
        return query.uniqueResult();
    }

    public List<Object> listObj(String hql, Object[] args) {
        Query query = getSession().createQuery(hql);
        for (int i = 0; i < args.length; i++) {
            query.setParameter(i, args[i]);
        }
        return query.list();
    }

    public List<Object> listObj(String hql, Object arg) {
        return this.listObj(hql, new Object[]{arg});
    }

    public List<Object> listObj(String hql) {
        return this.listObj(hql, null);
    }

    public Pager<Object> getObjPage(String hql, Object[] args) {
        int pageSize = SystemContext.getPageSize();
        int pageOffset = SystemContext.getPageOffset();
        if (pageSize == 0) pageSize = 10;
        if (pageOffset == 0) pageOffset = 0;
        Query query = getSession().createQuery(hql);
        for (int i = 0; i < args.length; i++) {
            query.setParameter(i, args[i]);
        }
        query.setFirstResult(pageOffset).setMaxResults(pageSize);
        String cHql = getCountFromHql(hql);
        Query cQuery = getSession().createQuery(cHql);
        for (int i = 0; i < args.length; i++) {
            query.setParameter(i, args[i]);
        }
        Pager<Object> pager = new Pager<Object>();
        pager.setPageOffset(pageOffset);
        pager.setPageSize(pageSize);
        List<Object> list = query.list();
        pager.setDatas(list);
        Long totalRecord = (Long) cQuery.uniqueResult();
        pager.setTotalRecord(totalRecord);
        return pager;
    }

    public Pager<Object> getObjPage(String hql, Object arg) {
        return this.getObjPage(hql, new Object[]{arg});
    }

    public Pager<Object> getObjPage(String hql) {
        return this.getObjPage(hql, null);
    }

    public Object queryByHql(String hql, Object arg) {
        return this.queryByHql(hql, new Object[]{arg});
    }

    public Object queryByHql(String hql) {
        return this.queryByHql(hql, null);
    }

    public void executeByHql(String hql, Object[] args) {
        Query query = getSession().createQuery(hql);
        for (int i = 0; i < args.length; i++) {
            query.setParameter(i, args[i]);
        }
        query.executeUpdate();
    }

    public void executeByHql(String hql, Object arg) {
        this.executeByHql(hql, new Object[]{arg});
    }

    public void executeByHql(String hql) {
        this.executeByHql(hql, null);
    }

	@Override
	public List<T> findByPage(int pageOffset, int pageSize) {
		if (pageOffset <= 0) pageOffset = 0;
		if (pageSize <= 0) pageSize = 10;
		Criteria criteria = getSession().createCriteria(cls);
		criteria.setFirstResult(pageOffset);
		criteria.setMaxResults(pageSize);
		return criteria.list();
	}

	@Override
	public int findCount() {
		Criteria criteria = getSession().createCriteria(cls);
		return criteria.list().size();
	}
	
}
