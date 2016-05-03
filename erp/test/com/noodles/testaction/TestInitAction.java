package com.noodles.testaction;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.noodles.action.InitAction;
import com.noodles.daoimpl.BaseDao;
import com.noodles.model.Menu;
import com.noodles.serviceimpl.InitManager;

public class TestInitAction {

	@Test
	public void test() {
		ApplicationContext ac = new ClassPathXmlApplicationContext(new String[] { "classpath:beans.xml"});
	    InitManager initManager = (InitManager) ac.getBean("initManager");
	    initManager.initMenu(); 
	}

}
