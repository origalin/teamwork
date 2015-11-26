package edu.nju.vo;

import java.util.ArrayList;

import edu.nju.po.Doc;

public class InWareHouseDocVO extends Doc{
	String ID;
	ArrayList<InWareHouseDocLineItem> list;
	
public String toString(){
	String reString=ID;
	for(InWareHouseDocLineItem temp:list)
		reString+=temp.toString();
	return reString;
}
	
	public InWareHouseDocVO(String iD, ArrayList<InWareHouseDocLineItem> list) {
		super();
		ID = iD;
		this.list = list;
	}
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
