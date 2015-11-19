package edu.nju.po;

public class TransferDoc_PlanePO extends TransferDocPO{

	public TransferDoc_PlanePO(String TransferDocID,long date,int planeNum,int corriage,String tranceID,String from,String targetCity,Double price,String[] itemIDs) {

		this.ID = TransferDocID;
		this.from = from;
		this.targetCity = targetCity;
		this.tranceID = tranceID;
		this.date = date;
		this.planeNum = planeNum;
		this.corriage = corriage;
		this.itemIDs = itemIDs;
		// TODO 自动生成的构造函数存根
	}
}
