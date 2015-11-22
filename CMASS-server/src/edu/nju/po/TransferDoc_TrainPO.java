package edu.nju.po;

import java.util.Date;

public class TransferDoc_TrainPO extends TransferDocPO{
	public TransferDoc_TrainPO(String id,Date date,String trainNum,String corriage,String tranceID,String from,String targetCity,Double price,String[] itemIDs) {
		this.ID = id;
		this.from = from;
		this.targetCity = targetCity;
		this.tranceID = tranceID;
		this.date = date;
		this.TrainNum = trainNum;
		this.corriage = corriage;
		this.itemIDs = itemIDs;
		// TODO 自动生成的构造函数存根
	}
}
