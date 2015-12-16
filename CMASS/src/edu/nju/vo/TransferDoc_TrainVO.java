package edu.nju.vo;

import edu.nju.po.TransferDocPO;
import edu.nju.po.TransferDoc_TrainPO;
import edu.nju.tools.Time;

public class TransferDoc_TrainVO extends TransferDocVO{
	public TransferDoc_TrainVO(TransferDocPO po) {
		super(po);
		this.date = Time.toDaysTime(po.getDate());
		this.ID = po.getTransferDocID();
		this.CarNum = po.getCarNum();
		this.from = po.getFrom();
		this.itemIDs = po.getItemIDs();
		this.targetCity = po.getTargetCity();
		this.watcher = po.getWatcher();
		this.price = String.valueOf(po.getPrice());
		this.corriage = po.getCorriage();
		this.tranceID = po.getTranceID();
	}
}
