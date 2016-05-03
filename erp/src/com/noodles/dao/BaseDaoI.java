package com.noodles.dao;

import java.util.List;
import java.util.Map;



public interface BaseDaoI<T> {
  
	public void add(T o);
	public void delete(T o);
	public void saveOrUpdate(T o);
	
	public T get(String sql,Map<String,Object> params);
	
	public List<T> find(String sql);
	public List<T> find(String sql,Map<String,Object> params);
	public List<T> find(String sql,int page,int rows);
	
	public long count(String sql);
	
}
