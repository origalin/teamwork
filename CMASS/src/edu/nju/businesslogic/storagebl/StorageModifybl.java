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
		// ���Լ����ݲ�����������µĿ�����
		
	}

	@Override
	public void setPercent(double p) {
		// ���Լ����ݲ����������õ����������İٷֱ�
		
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
