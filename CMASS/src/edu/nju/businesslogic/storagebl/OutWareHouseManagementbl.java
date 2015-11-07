package edu.nju.businesslogic.storagebl;

import edu.nju.businesslogicservice.storagelogicservice.OutWareHouseManagementService;
import edu.nju.po.OutWareHouseDocPO;
import edu.nju.vo.OutWareHouseDocVO;

public class OutWareHouseManagementbl implements OutWareHouseManagementService{

	OutWareHouseDocPO outWareHousePO;
	@Override
	public OutWareHouseDocVO getOutWareHouseDocVO_ZloadDoc(int ZloadDocID) {
		// 对运输模块有依赖，ZloadDoc getZloadDocPO(int ZloadDocID)
		////对自己数据层的依赖：ArrayList<RecordPO> getStorageItemList(int[] SendDocIDList)
		//对数据层依赖：获取该次出库单的编号
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
	public void updateOutWareHouseDoc(OutWareHouseDocVO out) {
		// 对数据层依赖：void updateOutWareHouseDoc(OutWareHouseDocPO out)
		
	}

}
