package edu.nju.vo;

import edu.nju.po.TransferDoc_PlanePO;
import edu.nju.tools.Time;

public class TransferDoc_PlaneVO extends TransferDocVO{
	public TransferDoc_PlaneVO(TransferDoc_PlanePO po) {
		this.date = Time.toDaysTime(po.getDate());
		this.ID = po.getTransferDocID();
		this.CarNum = po.getCarNum();
		this.from = po.getFrom();
		this.itemIDs = po.getItemIDs();
		this.targetCity = po.getTargetCity();
		this.price = String.valueOf(po.getPrice());
		this.container = po.getContainer();
	}
}
