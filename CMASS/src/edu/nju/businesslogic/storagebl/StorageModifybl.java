package edu.nju.businesslogic.storagebl;

import java.util.ArrayList;

import edu.nju.businesslogicservice.storagelogicservice.StorageModifyService;
import edu.nju.po.RecordPO;
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
		
	}@Override
	public ArrayList<RecordPO> getInWareHouseDocVO_Fly() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<RecordPO> getInWareHouseDocVO_Train() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<RecordPO> getInWareHouseDocVO_Car() {
		// TODO Auto-generated method stub
		return null;
	}

}
