package edu.nju.po;

public class TranceferDoc_CarPO extends TransferDocPO {


	public TranceferDoc_CarPO(String TransferDocID,long date,int carNum,String tranceID,String from,String targetCity,Double price,String[] itemIDs) {
		this.ID = TransferDocID;
		this.from = from;
		this.targetCity = targetCity;
		this.tranceID = tranceID;
		this.date = date;
		this.CarNum = carNum;
		this.itemIDs = itemIDs;
		// TODO 自动生成的构造函数存根
	}

}
