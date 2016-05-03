package com.noodles.vo;

import java.util.ArrayList;
import java.util.List;

public class DataGrid {
     private Long count = 0L;
     private List rows = new ArrayList();
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public List getRows() {
		return rows;
	}
	public void setRows(List rows) {
		this.rows = rows;
	}
     
     
}
