package com.noodles.action;

import java.io.IOException;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;

import com.alibaba.fastjson.JSON;


@ParentPackage("basePackage")
@Namespace("/")
public class BaseAction {
    
	public void writeJson(Object o){
		
		try {
		String json = JSON.toJSONStringWithDateFormat(o,"yyyy-MM-dd HH:mm:ss");
	
		ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
		ServletActionContext.getResponse().getWriter().write(json);
		System.out.println(json);
		ServletActionContext.getResponse().getWriter().flush();
		ServletActionContext.getResponse().getWriter().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
