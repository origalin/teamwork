package edu.nju.po;

public class TranceferDoc_CarPO extends TransferDocPO{

	public TranceferDoc_CarPO(long TransferDocID,long date,int carNum,int tranceID,String from,String targetCity,Double price,int[] itemIDs) {
		this.TransferDocID = TransferDocID;
		this.targetCity = targetCity;
		this.tranceID = tranceID;
		this.date = date;
		this.CarNum = carNum;
		this.targetCity = targetCity;
		this.itemIDs = itemIDs;
		// TODO 自动生成的构造函数存根
	}

}
