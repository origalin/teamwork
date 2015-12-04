package edu.nju.vo;

import java.util.ArrayList;

public class OutWareHouseDocVO {
	ArrayList<OutWareHouseDocLineItem> list=new ArrayList<OutWareHouseDocLineItem>();
	String outWareHouseDocID; 
	String storageID;
	
	
	public OutWareHouseDocVO(ArrayList<OutWareHouseDocLineItem> list, String outWareHouseDocID, String storageID) {
		super();
		this.list = list;
		this.outWareHouseDocID = outWareHouseDocID;
		this.storageID = storageID;
	}
	public OutWareHouseDocVO(ArrayList<OutWareHouseDocLineItem> outWareHouseDocVO, String outWareHouseDocID) {
		super();
		this.list = outWareHouseDocVO;
		this.outWareHouseDocID = outWareHouseDocID;
	}
	public OutWareHouseDocVO() {
		super();
	}
	
	
	
	public ArrayList<OutWareHouseDocLineItem> getLineItemList() {
		return list;
	}
	public void setLineItemList(ArrayList<OutWareHouseDocLineItem> outWareHouseDocVO) {
		this.list = outWareHouseDocVO;
	}
	public String getID() {
		return outWareHouseDocID;
	}
	public void setID(String outWareHouseDocID) {
		this.outWareHouseDocID = outWareHouseDocID;
	}
	public String toString(){
		String result="";
			for(OutWareHouseDocLineItem temp:list)
				result+=temp.toString2();
			
			return result;
		
	}

}
