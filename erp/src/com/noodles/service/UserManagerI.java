package com.noodles.service;

import java.util.List;

import com.noodles.model.User;
import com.noodles.vo.DataGrid;


public interface UserManagerI {
     void addUser(User u);
     
	DataGrid dataGrid();
   
}
