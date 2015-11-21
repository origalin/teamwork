package edu.nju.vo;

import java.util.ArrayList;

import edu.nju.po.PositionPO;

public class PositionVO {
	String itemID;
	ArrayList<String> history;
	public PositionVO(String itemID, ArrayList<String> history) {
		super();
		this.itemID = itemID;
		this.history = history;
	}
	
	public PositionVO(PositionPO p){
		super();
		this.itemID=p.getItemID();
		this.history=p.getHistory();
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
