package edu.nju.vo;

import edu.nju.vo.Doc;

import java.util.Date;

import edu.nju.po.YArrivalDocPO;
import edu.nju.tools.Time;

public class YArrivalDocVO extends Doc{
	String date;
	String TransferDocID;
	String from;
	String[][] itemAndState;// -1==lost 0==fine 1==broken

	public YArrivalDocVO(YArrivalDocPO po) {
		this.date = Time.toDaysTime(po.getDate());
		this.TransferDocID = po.getID();
		this.ID = po.getID();
		this.from = po.getFrom();
		this.itemAndState = po.getItemAndState();
	}



	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTransferDocID() {
		return TransferDocID;
	}

	public void setTransferDocID(String transferDocID) {
		TransferDocID = transferDocID;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String[][] getItemAndState() {
		return itemAndState;
	}

	public void setItemAndState(String[][] itemAndState) {
		this.itemAndState = itemAndState;
	}

}
