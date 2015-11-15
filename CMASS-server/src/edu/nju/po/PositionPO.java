package edu.nju.po;

import java.util.ArrayList;

public class PositionPO {
	int itemID;
	ArrayList<String> history;
	public PositionPO(int itemID, ArrayList<String> history) {
		super();
		this.itemID = itemID;
		this.history = history;
	}
	public int getItemID() {
		return itemID;
	}
	public void setItemID(int itemID) {
		this.itemID = itemID;
	}
	public ArrayList<String> getHistory() {
		return history;
	}
	public void setHistory(ArrayList<String> history) {
		this.history = history;
	}
	
}
