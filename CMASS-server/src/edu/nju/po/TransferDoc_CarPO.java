package edu.nju.po;

import java.util.Date;

public class TransferDoc_CarPO extends TransferDocPO {


	public TransferDoc_CarPO(String id,Date date,String carNum,String tranceID,String from,String targetCity,String watcher,Double price,String[] itemIDs) {
		this.ID = id;
		this.from = from;
		this.watcher = watcher;
		this.targetCity = targetCity;
		this.tranceID = tranceID;
		this.date = date;
		this.CarNum = carNum;
		this.itemIDs = itemIDs;
		// TODO �Զ����ɵĹ��캯�����
	}

}
