package edu.nju.po;

public class ZArrivalDocPO {
	int zArrivalDocID;
	long date;
	int YLoadDocID;
	String from;
	int[][] itemAndState;//-1==lost 0==fine 1==broken
	public ZArrivalDocPO(int zArrivalDocID, long date, int YLoadDocID,
			String from, int[][] itemAndState) {
		super();
		this.zArrivalDocID = zArrivalDocID;
		this.date = date;
		this.YLoadDocID = YLoadDocID;
		this.from = from;
		this.itemAndState = itemAndState;
	}
	public int getZArrivalDocID() {
		return zArrivalDocID;
	}
	public void setyArrivalDocID(int zArrivalDocID) {
		this.zArrivalDocID = zArrivalDocID;
	}
	public long getDate() {
		return date;
	}
	public void setDate(long date) {
		this.date = date;
	}
	public int getYLoadDocID() {
		return YLoadDocID;
	}
	public void setYLoadDocID(int YLoadDocID) {
		this.YLoadDocID = YLoadDocID;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public int[][] getItemAndState() {
		return itemAndState;
	}
	public void setItemAndState(int[][] itemAndState) {
		this.itemAndState = itemAndState;
	}
	
}
