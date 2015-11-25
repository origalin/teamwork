package edu.nju.businesslogic.storagebl;

import edu.nju.businesslogic.transformbl.TransferDoc;
import edu.nju.businesslogicservice.storagelogicservice.InWareHouseManagementService;
import edu.nju.po.InWareHouseDocPO;
import edu.nju.po.TransferDocPO;
import edu.nju.vo.InWareHouseDocVO;

public class InWareHouseManagementbl implements InWareHouseManagementService{

	InWareHouseDocPO inWareHouseDocPO;
	@Override
	public InWareHouseDocVO getInWareHouseDocVO_Transfer(String TransferDocID) {
		// 对运输模块有依赖，TransferDocPO  getTransferPO(int TransferID)
		//根据单号确定特快还是经济		
				//对数据层依赖：获取该次入库单的编号       获得对仓库的引用
		TransferDoc transferDoc=new TransferDoc();
		TransferDocPO transferDocPO=transferDoc.geTransferDocPOByID(TransferDocID);
		
		return null;
	}

	@Override
	public InWareHouseDocVO getInWareHouseDocVO_YloadDoc(String YloadDocID) {
		// 对运输模块有依赖，YloadDocPO  getYloadDocPO(int YloadDocID)

				//对数据层依赖：获取该次入库单的编号
		return null;
	}

	@Override
	public void updateInWareHouseDoc(InWareHouseDocVO out) {
		// 对数据层依赖：void updateInWareHouseDoc(InWareHouseDocPO out)
		
	}
	
	public String getAddressDatail(String ItemID){
		//依赖运输层
		return null;
	}

}
