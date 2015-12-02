package edu.nju.businesslogic.storagebl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import edu.nju.businesslogic.transformbl.TransferDoc;
import edu.nju.businesslogicservice.storagelogicservice.InWareHouseManagementService;
import edu.nju.data.StorageDataServiceImpl.StorageLocation;
import edu.nju.dataFactory.DataFactory;
import edu.nju.dataservice.storagedataservice.StorageDataService;
import edu.nju.po.InWareHouseDocLineItem;
import edu.nju.po.InWareHouseDocPO;
import edu.nju.po.TransferDocPO;

import edu.nju.vo.InWareHouseDocVO;

public class InWareHouseManagementbl implements InWareHouseManagementService {

	InWareHouseDocPO inWareHouseDocPO;

	@Override
	public InWareHouseDocVO getInWareHouseDocVO_Transfer(String TransferDocID,String currInstitutionID) {
		// 对运输模块有依赖，TransferDocPO getTransferPO(int TransferID)
		// 根据单号确定特快还是经济
		// 对数据层依赖：获取该次入库单的编号 获得对仓库的引用

		StorageDataService storageDataService = DataFactory.getStorageImpl();
		TransferDoc transferDoc = new TransferDoc();
		System.out.println("linqing");
		TransferDocPO transferDocPO = transferDoc.geTransferDocPOByID(TransferDocID);
		System.out.println(transferDocPO);
//		StorageDataService storageDataService = DataFactory.getStorageImpl();
//		storageDataService.
		
		String[] itemsID = transferDocPO.getItemIDs();
		StorageLocation storageLocation = null;
		ArrayList<InWareHouseDocLineItem> list = new ArrayList<InWareHouseDocLineItem>();
		for (String temp : itemsID) {
			String district = "";
			if (temp.charAt(0) == '0')
				district = "航运区";
			else if (temp.charAt(0) == '1')
				district = "货运区";
			else
				district = "汽运区";

			try {
				storageLocation=storageDataService.getValidLocation(currInstitutionID, district);
				System.out.println("currInstitution="+currInstitutionID+";district:"+district);
			} catch (RemoteException e) {
				System.out.println("获取有效位置出错");
				e.printStackTrace();
			}
			
			InWareHouseDocLineItem lineItem=new InWareHouseDocLineItem(temp, new Date(), district, storageLocation.getLocation());
			list.add(lineItem);
		}
		
		String currInWareID = "";
		try {
			currInWareID = storageDataService.getCurrInWare_ID();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		InWareHouseDocVO inWareHouseDocVO = new InWareHouseDocVO(currInWareID,currInstitutionID, list);

		return inWareHouseDocVO;
	}

	@Override
	public InWareHouseDocVO getInWareHouseDocVO_YloadDoc(String YloadDocID) {
		// 对运输模块有依赖，YloadDocPO getYloadDocPO(int YloadDocID)

		// 对数据层依赖：获取该次入库单的编号
		return null;
	}

	@Override
	public void updateInWareHouseDoc(InWareHouseDocVO in) {
		// 对数据层依赖：void updateInWareHouseDoc(InWareHouseDocPO out)
		

		
		StorageDataService storageDataService=DataFactory.getStorageImpl();
		try {
			System.out.println("逻辑层的VO in:"+in);
			storageDataService.updateInWareHouseDoc(in.unpack());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public String getAddressDatail(String ItemID) {
		// 依赖运输层
		return null;
	}

}
