package edu.nju.po;

import java.util.ArrayList;

public class PositionPO {
	String itemID;
	ArrayList<String> history;
	public PositionPO(String itemID, ArrayList<String> history) {
		super();
		this.itemID = itemID;
		this.history = history;
	}
	public String getItemID() {
		return itemID;
	}
	public void setItemID(String itemID) {
		this.itemID = itemID;
	}
	public ArrayList<String> getHistory() {
		return history;
	}
	public void setHistory(ArrayList<String> history) {
		this.history = history;
	}
	public String toString(){
		String string="";
		string+=itemID+" ";
		for(String temp:history)
			string+=temp+",";
		string=string.substring(0,string.length()-1);
		return string;
	}
	
}
