package edu.nju.vo;

import edu.nju.po.YDeliverDocPO;
import edu.nju.tools.Time;
import edu.nju.vo.Doc;

public class YDeliverDocVO extends Doc{
	String date;
	String courier;
	String[] itemIDs;
	public YDeliverDocVO(YDeliverDocPO po) {
		this.ID = po.getID();
		this.date = Time.toDaysTime(po.getDate());
		this.courier = po.getCourier();
		this.itemIDs = po.getItemIDs();
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getCourier() {
		return courier;
	}
	public void setCourier(String courier) {
		this.courier = courier;
	}
	public String[] getItemIDs() {
		return itemIDs;
	}
	public void setItemIDs(String[] itemIDs) {
		this.itemIDs = itemIDs;
	}
	
}
