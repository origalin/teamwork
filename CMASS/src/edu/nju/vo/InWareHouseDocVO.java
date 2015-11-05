package edu.nju.vo;

import java.util.ArrayList;

public class InWareHouseDocVO {
	ArrayList<InWareHouseDocLineItem> list;
	int ID;

	
	public InWareHouseDocVO() {
		super();
		
	}
	public InWareHouseDocVO(ArrayList<InWareHouseDocLineItem> list) {
		super();
		this.list = list;
	}

	public ArrayList<InWareHouseDocLineItem> getList() {
		return list;
	}

	public void setList(ArrayList<InWareHouseDocLineItem> list) {
		this.list = list;
	}
	
	

}
