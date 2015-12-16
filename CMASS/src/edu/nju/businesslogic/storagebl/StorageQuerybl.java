package edu.nju.businesslogic.storagebl;

import java.awt.HeadlessException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import edu.nju.businesslogic.infobl.Institution;
import edu.nju.businesslogic.systembl.SystemBl;
import edu.nju.businesslogicservice.infologicservice.InstitutionLogicService;
import edu.nju.businesslogicservice.storagelogicservice.StorageQueryService;
import edu.nju.dataFactory.DataFactory;
import edu.nju.dataservice.storagedataservice.StorageDataService;
import edu.nju.po.OperationPO;
import edu.nju.po.RecordPO;
import edu.nju.po.WareHousePO;

public class StorageQuerybl implements StorageQueryService{

	@Override
	public ArrayList<RecordPO> getInWareHouseDocVO_Fly(String currPersonID,String s) throws RemoteException{
		StorageDataService storageDataService=DataFactory.getStorageImpl();
		ArrayList<RecordPO> list=new ArrayList<RecordPO>();
		try {
			list=storageDataService.getInWareHouseDocPO_Fly(s);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(list.isEmpty())
			JOptionPane.showMessageDialog(null, "������Ϊ��");
		
		InstitutionLogicService institutionLogicService=new Institution();
		String staffName=institutionLogicService.getStaffName(currPersonID);
		OperationPO operationPO=new OperationPO(new Date(), currPersonID, staffName, "��ѯ��"+s+"�ֿ⺽�������");
		SystemBl systemBl=new SystemBl();
		systemBl.saveOperation(operationPO);
		return list;
	}

	@Override
	public ArrayList<RecordPO> getInWareHouseDocVO_Train(String currPersonID,String s) throws RemoteException {
		StorageDataService storageDataService=DataFactory.getStorageImpl();
		ArrayList<RecordPO> list=new ArrayList<RecordPO>();
		try {
			list=storageDataService.getInWareHouseDocPO_Train(s);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(list.isEmpty())
			JOptionPane.showMessageDialog(null, "������Ϊ��");
		
		InstitutionLogicService institutionLogicService=new Institution();
		String staffName=institutionLogicService.getStaffName(currPersonID);
		OperationPO operationPO=new OperationPO(new Date(), currPersonID, staffName, "��ѯ��"+s+"�ֿ���������");
		SystemBl systemBl=new SystemBl();
		systemBl.saveOperation(operationPO);
		return list;
	}

	@Override
	public ArrayList<RecordPO> getInWareHouseDocVO_Car(String currPersonID,String s) throws RemoteException {
		StorageDataService storageDataService=DataFactory.getStorageImpl();
		ArrayList<RecordPO> list=new ArrayList<RecordPO>();
		try {
			list=storageDataService.getInWareHouseDocPO_Car(s);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(list.isEmpty())
			JOptionPane.showMessageDialog(null, "������Ϊ��");
		

		InstitutionLogicService institutionLogicService=new Institution();
		String staffName=institutionLogicService.getStaffName(currPersonID);
		OperationPO operationPO=new OperationPO(new Date(), currPersonID, staffName, "��ѯ��"+s+"�ֿ���������");
		SystemBl systemBl=new SystemBl();
		systemBl.saveOperation(operationPO);
		return list;
	}

	
	

	

}
