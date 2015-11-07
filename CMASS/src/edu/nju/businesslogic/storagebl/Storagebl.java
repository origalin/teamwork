package edu.nju.businesslogic.storagebl;

import java.util.ArrayList;

import edu.nju.businesslogicservice.storagelogicservice.StorageLogicService;
import edu.nju.po.RecordPO;
import edu.nju.vo.InWareHouseDocVO;
import edu.nju.vo.OutWareHouseDocVO;

public class Storagebl implements StorageLogicService{

	@Override
	public InWareHouseDocVO getInWareHouseDocVO_Transfer(int TransferDocID) {
		// 对运输模块有依赖，TransferPO  getTransferPO(int TransferID)
//根据单号确定特快还是经济		
		//对数据层依赖：获取该次入库单的编号
		
		return null;  
	}
	

	@Override
	public InWareHouseDocVO getInWareHouseDocVO_YloadDoc(int YloadDocID) {
		// 对运输模块有依赖，YloadDocPO  getYloadDocPO(int YloadDocID)

		//对数据层依赖：获取该次入库单的编号
		return null;
	}

	@Override
	public OutWareHouseDocVO getOutWareHouseDocVO_Transfer(int TransferDocID) {
		// 对运输模块有依赖，TransferPO getTransferPO(int TransferID)
		//对自己数据层的依赖：ArrayList<RecordPO> getStorageItemList(int[] SendDocIDList)
		//对数据层依赖：获取该次出库单的编号
		return null;
	}

	@Override
	public OutWareHouseDocVO getOutWareHouseDocVO_ZloadDoc(int ZloadDocID) {
		// 对运输模块有依赖，ZloadDoc getZloadDocPO(int ZloadDocID)
		////对自己数据层的依赖：ArrayList<RecordPO> getStorageItemList(int[] SendDocIDList)
		//对数据层依赖：获取该次出库单的编号
		return null;
	}

	@Override
	public void updateOutWareHouseDoc(OutWareHouseDocVO out) {
		// 对数据层依赖：void updateOutWareHouseDoc(OutWareHouseDocPO out)
		
	}
	
	public void updateInWareHouseDoc(InWareHouseDocVO out) {
		// 对数据层依赖：void updateInWareHouseDoc(InWareHouseDocPO out)
		
	}

	@Override
	public void clear() {
		// 对自己数据层依赖：清空库存信息
		
	}

	@Override
	public void addNewStorageItem(RecordPO recordPO) {
		// 
		
	}

	@Override
	public void setAlarm(double p) {
		// 对自己数据层依赖：添加新的库存对象
		
	}

	@Override
	public void setPercent(double p) {
		// 对自己数据层依赖：设置调整机动区的百分比
		
	}
	@Override
	public void updateStorage(ArrayList<RecordPO> aList){}


	
	

}
