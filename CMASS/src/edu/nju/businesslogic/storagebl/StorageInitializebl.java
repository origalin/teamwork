package edu.nju.businesslogic.storagebl;

import edu.nju.businesslogicservice.storagelogicservice.StorageInitializeService;
import edu.nju.po.RecordPO;
import edu.nju.po.WareHousePO;

public class StorageInitializebl implements StorageInitializeService{

	WareHousePO wareHousePO;
	@Override
	public void clear() {
		// 对自己数据层依赖：清空库存信息
		
	}

	@Override
	public void addNewStorageItem(RecordPO recordPO) {
		// TODO Auto-generated method stub
		
	}

}
