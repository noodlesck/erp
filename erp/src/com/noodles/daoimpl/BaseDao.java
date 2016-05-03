package com.noodles.daoimpl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.junit.Test;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.noodles.dao.BaseDaoI;
import com.noodles.model.User;

import junit.framework.Assert;

 @Component(value="baseDao")
 public class BaseDao<T> implements BaseDaoI<T> {
	
	private HibernateTemplate hibernateTemplate;
	private SessionFactory sessionFactory;
	
	
	
	
    @Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
    @Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	public void add(T o) {
		//Session session = this.hibernateTemplate.getSessionFactory().getCurrentSession();
		/*
		System.out.println(this.sessionFactory.toString());
	    Session session = this.sessionFactory.getCurrentSession();
		Transaction ts =  session.beginTransaction();
		session.save(u);
		ts.commit();
		this.sessionFactory.openSession().save(o);
		*/
		hibernateTemplate.save(o);
		
		
	}
	
	public T get(String sql){
		System.out.println(this.hibernateTemplate.toString());
		List<T> users = this.hibernateTemplate.find(sql);
		
		System.out.println("1111");
		if((users != null)&&(users.size()) > 0){
			
			
		return users.get(0);
		}
		return null;
	}
	@Override
	public void delete(T o) {
		hibernateTemplate.delete(o);
		
	}
	@Override
	public void saveOrUpdate(T o) {
		hibernateTemplate.saveOrUpdate(o);
		
	}
	@Override
	public T get(String sql, Map<String, Object> params) {
		List<T> list = hibernateTemplate.find(sql,params);
		return list.get(0);
	}
	@Override
	public List<T> find(String sql) {
		List<T> list = hibernateTemplate.find(sql);
		return list;
	}
	@Override
	public List<T> find(String sql, Map<String, Object> params) {
		
		Query q = this.sessionFactory.openSession().createQuery(sql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}
		return q.list();
	}
	@Override
	public List<T> find(String sql, int page, int rows) {
		
		DetachedCriteria criteria = DetachedCriteria.forClass(User.class);
		List<T> list = hibernateTemplate.findByCriteria(criteria,((page-1)*rows),(page*rows));
		return list;
	}
	@Override
	public long count(String sql) {
		List<T> list = hibernateTemplate.find(sql);
		
		long count = list.size();
				
		return count;
	}
	
    @Test
	public void findTest(String sql) {
		List<T> list = hibernateTemplate.find("from Menu t where t.menu is null");
		
       Assert.assertEquals(false, list.isEmpty());

    }
	
	
}
