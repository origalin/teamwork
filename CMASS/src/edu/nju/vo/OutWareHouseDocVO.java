package edu.nju.vo;

import java.util.ArrayList;
import java.util.Date;

import edu.nju.po.OutRecord;
import edu.nju.po.OutWareHouseDocPO;

public class OutWareHouseDocVO extends Doc{
	ArrayList<OutWareHouseDocLineItem> list=new ArrayList<OutWareHouseDocLineItem>();
	String outWareHouseDocID; 
	String storageID;
	String transferPattern;
	Date date;
	@Override
	public String getID(){
		return outWareHouseDocID;
	}
	public OutWareHouseDocVO(OutWareHouseDocPO po){
		ArrayList<OutWareHouseDocLineItem> lineItems=new ArrayList<OutWareHouseDocLineItem>();
		ArrayList<OutRecord> outRecords=po.getOutRecords();
		for(OutRecord temp:outRecords){
			OutWareHouseDocLineItem lineItem=new OutWareHouseDocLineItem(temp.getItemID(),temp.getDestination());
			lineItems.add(lineItem);
		}
		
		this.list=lineItems;
		this.outWareHouseDocID=po.getOutWareHouseDocID();
		this.storageID=po.getStorageID();
		this.transferPattern=po.getTransferPattern();
		this.date=po.getOutDate();
	}
	public OutWareHouseDocVO(ArrayList<OutWareHouseDocLineItem> list, String outWareHouseDocID, String storageID,
			Date date) {
		super();
		this.list = list;
		this.outWareHouseDocID = outWareHouseDocID;
		this.storageID = storageID;
		this.date = date;
	}
	public ArrayList<OutWareHouseDocLineItem> getList() {
		return list;
	}
	public void setList(ArrayList<OutWareHouseDocLineItem> list) {
		this.list = list;
	}
	public String getOutWareHouseDocID() {
		return outWareHouseDocID;
	}
	public void setOutWareHouseDocID(String outWareHouseDocID) {
		this.outWareHouseDocID = outWareHouseDocID;
	}
	public String getStorageID() {
		return storageID;
	}
	public void setStorageID(String storageID) {
		this.storageID = storageID;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
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
	@Override
	public void setID(String outWareHouseDocID) {
		this.outWareHouseDocID = outWareHouseDocID;
	}
	
	
	public String getTransferPattern() {
		return transferPattern;
	}
	public void setTransferPattern(String transferPattern) {
		this.transferPattern = transferPattern;
	}
	
	public OutWareHouseDocPO unpack(){
		ArrayList<OutRecord> outRecords=new ArrayList<OutRecord>();
		for(OutWareHouseDocLineItem temp:list){
			OutRecord outRecord=new OutRecord(temp.getSendDocID(), temp.getDestination(), outWareHouseDocID);
			outRecords.add(outRecord);
		}
		
		return new OutWareHouseDocPO(outWareHouseDocID, date, transferPattern, storageID, outRecords);
		
	}
	
	
}
