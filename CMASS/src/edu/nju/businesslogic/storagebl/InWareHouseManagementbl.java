package edu.nju.businesslogic.storagebl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.xml.crypto.Data;

import edu.nju.businesslogic.infobl.Institution;
import edu.nju.businesslogic.systembl.SystemBl;
import edu.nju.businesslogic.transferbl.TransferDoc;
import edu.nju.businesslogic.transferbl.YLoadDoc;
import edu.nju.businesslogicservice.infologicservice.InstitutionLogicService;
import edu.nju.businesslogicservice.storagelogicservice.InWareHouseManagementService;
import edu.nju.data.StorageDataServiceImpl.StorageLocation;
import edu.nju.dataFactory.DataFactory;
import edu.nju.dataservice.storagedataservice.StorageDataService;
import edu.nju.exception.DatabaseNULLException;
import edu.nju.po.InWareHouseDocLineItem;
import edu.nju.po.InWareHouseDocPO;
import edu.nju.po.OperationPO;
import edu.nju.po.TransferDocPO;
import edu.nju.po.YLoadDocPO;
import edu.nju.vo.InWareHouseDocVO;

public class InWareHouseManagementbl implements InWareHouseManagementService {

	InWareHouseDocPO inWareHouseDocPO;

	@Override
	public InWareHouseDocVO getInWareHouseDocVO_Transfer(String TransferDocID, String currInstitutionID) throws DatabaseNULLException {
		// 对运输模块有依赖，TransferDocPO getTransferPO(int TransferID)
		// 根据单号确定特快还是经济
		// 对数据层依赖：获取该次入库单的编号 获得对仓库的引用

		StorageDataService storageDataService = DataFactory.getStorageImpl();
		TransferDoc transferDoc = null;
		try {
			transferDoc = new TransferDoc();
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		TransferDocPO transferDocPO = null;
		try {
			transferDocPO = transferDoc.geTransferDocPOByID(TransferDocID);
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// System.out.println(transferDocPO);
		// StorageDataService storageDataService = DataFactory.getStorageImpl();
		// storageDataService.
		if (transferDocPO == null) {
			JOptionPane.showMessageDialog(null, "未找到该中转单");
			return null;
		}

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
				storageLocation = storageDataService.getValidLocation(currInstitutionID, district);
				System.out.println("currInstitution=" + currInstitutionID + ";district:" + district);
			} catch (RemoteException e) {
				System.out.println("获取有效位置出错");
				e.printStackTrace();
			}

			InWareHouseDocLineItem lineItem = new InWareHouseDocLineItem(temp, new Date(), district,
					storageLocation.getLocation());
			list.add(lineItem);
		}

		String currInWareID = "";
		try {
			currInWareID = storageDataService.getCurrInWare_ID();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		InWareHouseDocVO inWareHouseDocVO = new InWareHouseDocVO(currInWareID, currInstitutionID, list);

		return inWareHouseDocVO;
	}

	@Override
	public InWareHouseDocVO getInWareHouseDocVO_YloadDoc(String YloadDocID, String currInstitutionID) throws DatabaseNULLException, RemoteException {
		StorageDataService storageDataService = DataFactory.getStorageImpl();
		YLoadDoc yLoadDoc  = new YLoadDoc();

		YLoadDocPO yLoadDocPO = null;
		try {
			yLoadDocPO = yLoadDoc.getYloadDocPOByID(YloadDocID);
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// StorageDataService storageDataService = DataFactory.getStorageImpl();
		// storageDataService.
		if (yLoadDocPO == null) {
			JOptionPane.showMessageDialog(null, "未找到该装车单");
			return null;
		}
		String[] itemsID = yLoadDocPO.getItemIDs();
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
				storageLocation = storageDataService.getValidLocation(currInstitutionID, district);
				// System.out.println("currInstitution="+currInstitutionID+";district:"+district);
			} catch (RemoteException e) {
				System.out.println("获取有效位置出错");
				e.printStackTrace();
			}

			InWareHouseDocLineItem lineItem = new InWareHouseDocLineItem(temp, new Date(), district,
					storageLocation.getLocation());
			list.add(lineItem);
		}

		String currInWareID = "";
		try {
			currInWareID = storageDataService.getCurrInWare_ID();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		InWareHouseDocVO inWareHouseDocVO = new InWareHouseDocVO(currInWareID, currInstitutionID, list);

		return inWareHouseDocVO;

	}

	@Override
	public void updateInWareHouseDoc(InWareHouseDocVO in,String currPersonID) {
		// 对数据层依赖：void updateInWareHouseDoc(InWareHouseDocPO out)

		StorageDataService storageDataService = DataFactory.getStorageImpl();
		try {
			System.out.println("逻辑层的VO in:" + in);
			
			InstitutionLogicService institutionLogicService=new Institution();
			String staffName=institutionLogicService.getStaffName(currPersonID);
			OperationPO operationPO=new OperationPO(new Date(), currPersonID, staffName, "新建了"+in.getID()+"入库单");
			SystemBl systemBl=new SystemBl();
			systemBl.saveOperation(operationPO);
			
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
	
	public void saveInWareHouseDoc(InWareHouseDocPO in) throws RemoteException{
		StorageDataService storageDataService=DataFactory.getStorageImpl();
		
		storageDataService.saveInWareHouseDoc(in);
	}

}
