package edu.nju.po;

import java.io.Serializable;
import java.util.ArrayList;




public class InWareHouseDocPO extends Doc implements Serializable{
	String ID;
	String storageID;
	ArrayList<InWareHouseDocLineItem> list;
	public void listAppend(InWareHouseDocLineItem in){
		list.add(in);
	}
public String getStorageID() {
		return storageID;
	}

	public void setStorageID(String storageID) {
		this.storageID = storageID;
	}


	
	@Override
	public String toString() {
		return "InWareHouseDocPO [ID=" + ID + ", storageID=" + storageID + ", list=" + list + "]";
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
@Override
	public String getID() {
		return ID;
	}
@Override
	public void setID(String iD) {
		ID = iD;
	}
	
}
