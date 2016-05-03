package com.noodles.serviceimpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.noodles.daoimpl.BaseDao;
import com.noodles.model.Menu;
import com.noodles.model.User;


@Component(value="initManager")
public class InitManager {
	
	public InitManager(){
		System.out.println("init");
	}
	
	public BaseDao<Menu> getMenuDao() {
		return menuDao;
	}
    @Resource
	public void setMenuDao(BaseDao<Menu> menuDao) {
		this.menuDao = menuDao;
	}

	public BaseDao<User> getUserDao() {
		return userDao;
	}
    @Resource
	public void setUserDao(BaseDao<User> userDao) {
		this.userDao = userDao;
	}

	private BaseDao<Menu> menuDao; 
    private BaseDao<User> userDao;

	public void initMenu() {
		Menu root = new Menu();
		root.setId("0");
		root.setText("首页");
		root.setTmenu(null);
		root.setUrl("");
		menuDao.saveOrUpdate(root);
		
		Menu xtgl = new Menu();
		xtgl.setId("xtgl");
		xtgl.setTmenu(root);
		xtgl.setText("系统管理");
		xtgl.setUrl("");
		menuDao.saveOrUpdate(xtgl);

		Menu yhgl = new Menu();
		yhgl.setId("yhgl");
		yhgl.setTmenu(xtgl);
		yhgl.setText("用户管理");
		yhgl.setUrl("/admin/yhgl.jsp");
		menuDao.saveOrUpdate(yhgl);

		Menu jsgl = new Menu();
		jsgl.setId("jsgl");
		jsgl.setTmenu(xtgl);
		jsgl.setText("角色管理");
		menuDao.saveOrUpdate(jsgl);

		Menu qxgl = new Menu();
		qxgl.setId("qxgl");
		qxgl.setTmenu(xtgl);
		qxgl.setText("权限管理");
		menuDao.saveOrUpdate(qxgl);

		Menu cdgl = new Menu();
		cdgl.setId("cdgl");
		cdgl.setTmenu(xtgl);
		cdgl.setText("菜单管理");
		menuDao.saveOrUpdate(cdgl);

		Menu buggl = new Menu();
		buggl.setId("buggl");
		buggl.setTmenu(xtgl);
		buggl.setText("BUG管理");
		menuDao.saveOrUpdate(buggl);
		
		
	}
}
