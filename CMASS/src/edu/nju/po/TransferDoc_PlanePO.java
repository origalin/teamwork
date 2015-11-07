package edu.nju.po;

public class TransferDoc_PlanePO extends TransferDocPO{
	public TransferDoc_PlanePO(long TransferDocID,long date,int planeNum,int corriage,int tranceID,String from,String targetCity,Double price,int[] itemIDs) {
		this.TransferDocID = TransferDocID;
		this.targetCity = targetCity;
		this.tranceID = tranceID;
		this.date = date;
		this.planeNum = planeNum;
		this.corriage = corriage;
		this.targetCity = targetCity;
		this.itemIDs = itemIDs;
		// TODO 自动生成的构造函数存根
	}
}
