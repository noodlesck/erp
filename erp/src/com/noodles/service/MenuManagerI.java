package com.noodles.service;

import java.util.List;

import com.noodles.model.Menu;
import com.noodles.vo.VMenu;

public interface MenuManagerI {
      
       public List<Menu> getTreeNoods();
	List<VMenu> getTreeNode(String id);
}
