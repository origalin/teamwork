package edu.nju.po;

public class TranceferDoc_TrainPO extends TransferDocPO{
	public TranceferDoc_TrainPO(String TransferDocID,long date,int trainNum,int corriage,String tranceID,String from,String targetCity,Double price,String[] itemIDs) {

		this.ID = TransferDocID;
		this.from = from;
		this.targetCity = targetCity;
		this.tranceID = tranceID;
		this.date = date;
		this.TrainNum = trainNum;
		this.corriage = corriage;
		this.itemIDs = itemIDs;
		// TODO �Զ����ɵĹ��캯�����
	}
}