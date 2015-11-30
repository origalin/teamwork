package edu.nju.vo;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import edu.nju.po.Doc;
import edu.nju.po.InWareHouseDocLineItem;
import edu.nju.po.InWareHouseDocPO;

public class InWareHouseDocVO extends Doc{
	String ID;
	String storageID;
	ArrayList<InWareHouseDocLineItem> list;
	
public String toString(){
	String reString=ID;
	for(InWareHouseDocLineItem temp:list)
		reString+=temp.toString();
	return reString;
}
	
	public InWareHouseDocVO(String iD, String storageID, ArrayList<InWareHouseDocLineItem> list) {
	super();
	ID = iD;
	this.storageID = storageID;
	this.list = list;
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

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}
	
	public InWareHouseDocPO unpack(){
		
		return new InWareHouseDocPO(this.ID,this.storageID,this.list);
	}
	
	

}
