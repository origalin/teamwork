package edu.nju.po;

import java.util.Date;

public class TransferDoc_PlanePO extends TransferDocPO{

	public TransferDoc_PlanePO(String ID,Date date,String planeNum,String corriage,String tranceID,String from,String targetCity,String watcher,Double price,String[] itemIDs) {

		this.ID = ID;
		this.from = from;
		this.targetCity = targetCity;
		this.tranceID = tranceID;
		this.date = date;
		this.watcher = watcher;
		this.planeNum = planeNum;
		this.corriage = corriage;
		this.itemIDs = itemIDs;
		// TODO 自动生成的构造函数存根
	}
}
