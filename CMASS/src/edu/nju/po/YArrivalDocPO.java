package edu.nju.po;

public class YArrivalDocPO {
	int yArrivalDocID;
	long date;
	int TransferDocID;
	String from;
	int[][] itemAndState;//-1==lost 0==fine 1==broken
	public YArrivalDocPO(int yArrivalDocID, long date, int transferDocID,
			String from, int[][] itemAndState) {
		super();
		this.yArrivalDocID = yArrivalDocID;
		this.date = date;
		TransferDocID = transferDocID;
		this.from = from;
		this.itemAndState = itemAndState;
	}
	public int getyArrivalDocID() {
		return yArrivalDocID;
	}
	public void setyArrivalDocID(int yArrivalDocID) {
		this.yArrivalDocID = yArrivalDocID;
	}
	public long getDate() {
		return date;
	}
	public void setDate(long date) {
		this.date = date;
	}
	public int getTransferDocID() {
		return TransferDocID;
	}
	public void setTransferDocID(int transferDocID) {
		TransferDocID = transferDocID;
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
