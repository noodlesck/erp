package com.noodles.action;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.beans.factory.annotation.Autowired;


import com.noodles.serviceimpl.MenuManager;
import com.noodles.vo.VMenu;
import com.opensymphony.xwork2.ModelDriven;

@ParentPackage("basePackage")
@Namespace("/")
@Action(value = "menu")
public class MenuAction extends BaseAction implements ModelDriven{
    private VMenu vmenu = new VMenu();
	@Override
	public VMenu getModel() {
		
		return vmenu;
	}
	
	
	private MenuManager menuManager;

    
    public MenuManager getMenuManager() {
		return menuManager;
	}

    @Resource
	public void setMenuManager(MenuManager menuManager) {
		this.menuManager = menuManager;
	}

    
	public void getTree(){
    	super.writeJson(menuManager.getTreeNode(vmenu.getId()));
    }


    
} 
