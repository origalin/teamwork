package edu.nju.po;

import java.util.Date;

public class YArrivalDocPO extends Doc{
	Date date;
	String TransferDocID;
	String from;
	String[][] itemAndState;// -1==lost 0==fine 1==broken

	public YArrivalDocPO(String id,Date date, String transferDocID, String from, String[][] itemAndState) {
		super();
		this.ID = id;
		this.date = date;
		TransferDocID = transferDocID;
		this.from = from;
		this.itemAndState = itemAndState;
	}



	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
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
