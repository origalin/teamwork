package edu.nju.po;

import java.util.ArrayList;




public class InWareHouseDocPO extends Doc{
	String ID;
	String storageID;
	ArrayList<InWareHouseDocLineItem> list;
	
public String getStorageID() {
		return storageID;
	}

	public void setStorageID(String storageID) {
		this.storageID = storageID;
	}

public String toString(){
	String reString=ID;
	for(InWareHouseDocLineItem temp:list)
		reString+=temp.toString();
	return reString;
}
	
	public InWareHouseDocPO(String iD, String storageID, ArrayList<InWareHouseDocLineItem> list) {
	super();
	ID = iD;
	this.storageID = storageID;
	this.list = list;
}

	public InWareHouseDocPO(String iD, ArrayList<InWareHouseDocLineItem> list) {
		super();
		ID = iD;
		this.list = list;
	}
	public InWareHouseDocPO() {
		super();
		
	}
	public InWareHouseDocPO(ArrayList<InWareHouseDocLineItem> list) {
		super();
		this.list = list;
	}

	public ArrayList<InWareHouseDocLineItem> getList() {
		return list;
	}

	public void setList(ArrayList<InWareHouseDocLineItem> list) {
		this.list = list;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}
	
}
