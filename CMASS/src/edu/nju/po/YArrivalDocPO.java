package edu.nju.po;

public class YArrivalDocPO extends Doc{
	long date;
	int TransferDocID;
	String from;
	String[][] itemAndState;// -1==lost 0==fine 1==broken

	public YArrivalDocPO(long date, int transferDocID, String from, String[][] itemAndState) {
		super();

		this.date = date;
		TransferDocID = transferDocID;
		this.from = from;
		this.itemAndState = itemAndState;
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

	public String[][] getItemAndState() {
		return itemAndState;
	}

	public void setItemAndState(String[][] itemAndState) {
		this.itemAndState = itemAndState;
	}

}
