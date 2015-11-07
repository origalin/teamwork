package edu.nju.vo;

import java.util.ArrayList;

import edu.nju.po.Doc;

public class InWareHouseDocVO extends Doc{
	int ID;
	ArrayList<InWareHouseDocLineItem> list;
	

	
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
