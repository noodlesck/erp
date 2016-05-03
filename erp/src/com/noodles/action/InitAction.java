package com.noodles.action;

import javax.annotation.Resource;

import com.noodles.daoimpl.BaseDao;
import com.noodles.model.Menu;
import com.noodles.model.User;
import com.noodles.serviceimpl.InitManager;

public class InitAction extends BaseAction {
    private InitManager initManager;
	
	
	
	public InitManager getInitManager() {
		return initManager;
	}


   @Resource
	public void setInitManager(InitManager initManager) {
		this.initManager = initManager;
	}



	public void init(){
    	
    	initManager.initMenu();
    }
    
    

	
}
