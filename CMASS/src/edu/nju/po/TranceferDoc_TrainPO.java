package edu.nju.po;

public class TranceferDoc_TrainPO extends TransferDocPO{
	public TranceferDoc_TrainPO(long TransferDocID,long date,int trainNum,int corriage,int tranceID,String from,String targetCity,Double price,int[] itemIDs) {
		this.TransferDocID = TransferDocID;
		this.targetCity = targetCity;
		this.tranceID = tranceID;
		this.date = date;
		this.TrainNum = trainNum;
		this.corriage = corriage;
		this.targetCity = targetCity;
		this.itemIDs = itemIDs;
		// TODO �Զ����ɵĹ��캯�����
	}
}