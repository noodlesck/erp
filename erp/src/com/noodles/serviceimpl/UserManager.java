package com.noodles.serviceimpl;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.noodles.daoimpl.BaseDao;

import com.noodles.model.User;
import com.noodles.service.UserManagerI;
import com.noodles.vo.DataGrid;
import com.noodles.vo.VUser;


@Component
public class UserManager implements UserManagerI{
    private BaseDao<User> userDao;

	public BaseDao<User> getBaseDao() {
		return userDao;
	}
    
    public BaseDao<User> getUserDao() {
		return userDao;
	}
    @Resource
	public void setUserDao(BaseDao<User> userDao) {
		this.userDao = userDao;
	}
	
	public User login(VUser u){
		Map<String,Object> params = new HashMap<String,Object>(); 
		params.put("name",u.getName());
		params.put("password",u.getPassword());
		User user = userDao.get("from User u where u.name = '"+u.getName()+"'");
		System.out.println(user.getName());
		return user;
		
		
	}
	@Override
	public void addUser(User u) {
		this.userDao.add(u);
		
	}

	@Override
	public DataGrid dataGrid() {
		DataGrid dg = new DataGrid();
		String sql = "from User u";
		
		List<User> l = this.userDao.find(sql);
		System.out.println(l.size());
		List<VUser> v = new ArrayList<VUser>();
		modelExchange(l, v);
		System.out.println(v.size());
		dg.setRows(v);
		Long count = this.userDao.count(sql);
		dg.setCount(count);
		return dg;
		
	}
	public void modelExchange(List<User> s,List<VUser> t){
		
		for(User u:s){
			VUser v = new VUser();
			System.out.println(u.getName());
			BeanUtils.copyProperties(u, v);
			System.out.println(v.getName());
			t.add(v);
		}
		
	}
	
	
}
