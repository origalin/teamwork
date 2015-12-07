package edu.nju.vo;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import edu.nju.po.Doc;
import edu.nju.po.InWareHouseDocLineItem;
import edu.nju.po.InWareHouseDocPO;

public class InWareHouseDocVO extends Doc {
	String inID;
	String storageID;
	ArrayList<InWareHouseDocLineItem> list;

	public InWareHouseDocVO(InWareHouseDocPO po) {
		super();
		this.inID = po.getID();
		this.storageID = po.getStorageID();
		this.list = po.getList();
	}
	
	
	@Override
	public String toString() {
		String lString = "";
		for (InWareHouseDocLineItem temp : list)
			lString += temp;
		return "InWareHouseDocVO [ID=" + inID + ", storageID=" + storageID + ", list=" + lString + "]";
	}

	public InWareHouseDocVO(String iD, String storageID, ArrayList<InWareHouseDocLineItem> list) {
		super();
		inID = iD;
		this.storageID = storageID;
		this.list = list;
	}

	public InWareHouseDocVO(String iD, ArrayList<InWareHouseDocLineItem> list) {
		super();
		inID = iD;
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
		return inID;
	}

	public void setID(String iD) {
		inID = iD;
	}

	public InWareHouseDocPO unpack() {

		return new InWareHouseDocPO(this.inID, this.storageID, this.list);
	}

}
