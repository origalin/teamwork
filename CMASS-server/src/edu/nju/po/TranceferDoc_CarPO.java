package edu.nju.po;

public class TranceferDoc_CarPO extends TransferDocPO {

	public TranceferDoc_CarPO(int TransferDocID,long date,int carNum,int tranceID,String from,String targetCity,Double price,int[] itemIDs) {
		this.ID = TransferDocID;
		this.targetCity = targetCity;
		this.tranceID = tranceID;
		this.date = date;
		this.CarNum = carNum;
		this.targetCity = targetCity;
		this.itemIDs = itemIDs;
		// TODO �Զ����ɵĹ��캯�����
	}

}
