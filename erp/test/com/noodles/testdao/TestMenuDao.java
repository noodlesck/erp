package com.noodles.testdao;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.noodles.daoimpl.BaseDao;
import com.noodles.model.Menu;

public class TestMenuDao {
	

	@Test
	public void test() {
		ApplicationContext ac = new ClassPathXmlApplicationContext(new String[] { "classpath:beans.xml"});
		BaseDao<Menu> menuDao = (BaseDao<Menu>) ac.getBean("baseDao");
		System.out.println(menuDao.toString());
		Menu m = new Menu();
		m.setId("111");
		m.setText("SSSS");
		menuDao.add(m);
		System.out.println(menuDao.toString());
		
	}

}
