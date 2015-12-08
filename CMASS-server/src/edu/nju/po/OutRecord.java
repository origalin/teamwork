package edu.nju.po;

import java.io.Serializable;

public class OutRecord implements Serializable{
	String itemID;

	String destination;
	String outWareHouseDocID;

	public OutRecord(String itemID, String destination, String outWareHouseDocID) {
		super();
		this.itemID = itemID;
		this.destination = destination;
		this.outWareHouseDocID = outWareHouseDocID;
	}

	public String getItemID() {
		return itemID;
	}

	public void setItemID(String itemID) {
		this.itemID = itemID;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getOutWareHouseDocID() {
		return outWareHouseDocID;
	}

	public void setOutWareHouseDocID(String outWareHouseDocID) {
		this.outWareHouseDocID = outWareHouseDocID;
	}

	@Override
	public String toString() {
		return "OutRecord [itemID=" + itemID + ", destination=" + destination + ", outWareHouseDocID="
				+ outWareHouseDocID + "]";
	}

}
