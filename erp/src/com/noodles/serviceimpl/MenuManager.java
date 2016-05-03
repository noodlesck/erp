package com.noodles.serviceimpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.noodles.daoimpl.BaseDao;
import com.noodles.model.Menu;
import com.noodles.service.MenuManagerI;
import com.noodles.vo.VMenu;


@Component
public class MenuManager implements MenuManagerI{
      BaseDao<Menu> menuDao;
      
      
      
	public BaseDao<Menu> getMenuDao() {
		return menuDao;
	}
    @Resource
	public void setMenuDao(BaseDao<Menu> menuDao) {
		this.menuDao = menuDao;
	}
	@Override
	public List<VMenu> getTreeNode(String id) {
		List<Menu> nl = new ArrayList<Menu>();
		List<VMenu> vnl = new ArrayList<VMenu>();
		Map<String ,Object> params = new HashMap<String ,Object>();
		String sql = null;
		if(id == null || id.equals("") ){
			sql = "from Menu m where m.tmenu is null";
			nl = menuDao.find(sql);
			
		}else{
			sql = "from Menu m where m.tmenu.id = :id";
			params.put("id",id);
			nl = menuDao.find(sql,params);
		}
		System.out.println(nl.size());
		if(nl !=null && nl.size() >0){
			
			Map<String,Object> attributes = new HashMap<String,Object>();
			for(Menu m:nl){
				VMenu vm = new VMenu();
				BeanUtils.copyProperties(m,vm);
				attributes.put("url",m.getUrl());
				vm.setAttributes(attributes);
				Set<Menu> set = m.getTmenus();
				if(set != null && set.size() >0){
					vm.setState("closed");
				}else{
					vm.setState("open");
				}
				vnl.add(vm);
				
			}
			
			
		}
		
		return vnl;
	}
	@Override
	public List<Menu> getTreeNoods() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
