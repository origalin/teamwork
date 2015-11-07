package edu.nju.businesslogic.storagebl;

import edu.nju.businesslogicservice.storagelogicservice.StorageModifyService;
import edu.nju.po.WareHousePO;

public class StorageModifybl implements StorageModifyService
{

	WareHousePO wareHousePO;
	@Override
	public void setAlarm(double p) {
		// 对自己数据层依赖：添加新的库存对象
		
	}

	@Override
	public void setPercent(double p) {
		// 对自己数据层依赖：设置调整机动区的百分比
		
	}

}
