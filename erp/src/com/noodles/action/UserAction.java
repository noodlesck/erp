package com.noodles.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.noodles.model.User;
import com.noodles.serviceimpl.UserManager;
import com.noodles.vo.Json;
import com.noodles.vo.VUser;
import com.opensymphony.xwork2.ModelDriven;


@ParentPackage("basePackage")
@Namespace("/")
@Action(value = "user")
public class UserAction extends BaseAction implements ModelDriven<VUser>{
	private UserManager um;
	private VUser user = new VUser();
	
	public VUser getModel() {
		
		return user;
	}
	
	
	
    
     /*
     String name = ServletActionContext.getRequest().getParameter("username");
     String password = ServletActionContext.getRequest().getParameter("password");
	 */
     public UserManager getUm() {
		return um;
	}
    @Resource
	public void setUm(UserManager um) {
		this.um = um;
	}
	
    public void reg(){
    	Json j = new Json();
    	try {
    		 
    		System.out.println(user.getName());
    		System.out.println(user.getName());
    		User u = new User();
    		u.setName(user.getName());
    		u.setPassword(user.getPassword());
    		
			um.addUser(u);
			j.setSuccess(true);
	    	j.setMsg("注册成功");
		} catch (Exception e) {
			j.setMsg("注册失败");
			e.printStackTrace();
		}
    	System.out.println(j.getMsg());
    	super.writeJson(j);
    }
    
    public void login(){
    	User u = um.login(user);
    	Json j = new Json();
    	if(u!= null){
    		j.setSuccess(true);
    		j.setMsg("登陆成功");
    	}else{
    		j.setMsg("登陆失败");
    	}
    	super.writeJson(j);
    }
    
    public void dataGrid(){
    	super.writeJson(um.dataGrid());
    }
	
	
}
