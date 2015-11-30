package edu.nju.vo;

import edu.nju.po.TransferDoc_CarPO;
import edu.nju.tools.Time;

public class TransferDoc_CarVO extends TransferDocVO{
	public TransferDoc_CarVO(TransferDoc_CarPO po) {
		super(po);
		this.date = Time.toDaysTime(po.getDate());
		this.ID = po.getTransferDocID();
		this.CarNum = po.getCarNum();
		this.from = po.getFrom();
		this.itemIDs = po.getItemIDs();
		this.targetCity = po.getTargetCity();
		this.price = String.valueOf(po.getPrice());
	}
}
