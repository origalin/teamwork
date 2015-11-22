package edu.nju.po;

import java.util.Date;

public class ZArrivalDocPO extends Doc{
	Date date;
	String fromID;
	String from;
	String[][] itemAndState;// -1==lost 0==fine 1==broken

	public ZArrivalDocPO(String id, Date date, String fromID, String from, String[][] itemAndState) {
		super();
		this.ID = id;
		this.date = date;
		this.fromID = fromID;
		this.from = from;
		this.itemAndState = itemAndState;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getfromID() {
		return fromID;
	}

	public void setfromID(String fromID) {
		this.fromID = fromID;
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
