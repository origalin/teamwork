package edu.nju.businesslogic.storagebl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import edu.nju.businesslogicservice.storagelogicservice.StorageQueryService;
import edu.nju.dataFactory.DataFactory;
import edu.nju.dataservice.storagedataservice.StorageDataService;
import edu.nju.po.RecordPO;
import edu.nju.po.WareHousePO;

public class StorageQuerybl implements StorageQueryService{

	@Override
	public ArrayList<RecordPO> getInWareHouseDocVO_Fly(String s) {
		StorageDataService storageDataService=DataFactory.getStorageImpl();
		ArrayList<RecordPO> list=new ArrayList<RecordPO>();
		try {
			list=storageDataService.getInWareHouseDocPO_Fly(s);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(list.isEmpty())
			JOptionPane.showMessageDialog(null, "航运区为空");
		return list;
	}

	@Override
	public ArrayList<RecordPO> getInWareHouseDocVO_Train(String s) {
		StorageDataService storageDataService=DataFactory.getStorageImpl();
		ArrayList<RecordPO> list=new ArrayList<RecordPO>();
		try {
			list=storageDataService.getInWareHouseDocPO_Train(s);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(list.isEmpty())
			JOptionPane.showMessageDialog(null, "货运区为空");
		return list;
	}

	@Override
	public ArrayList<RecordPO> getInWareHouseDocVO_Car(String s) {
		StorageDataService storageDataService=DataFactory.getStorageImpl();
		ArrayList<RecordPO> list=new ArrayList<RecordPO>();
		try {
			list=storageDataService.getInWareHouseDocPO_Car(s);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(list.isEmpty())
			JOptionPane.showMessageDialog(null, "汽运区为空");
		return list;
	}

	
	

	

}
