package edu.nju.businesslogic.storagebl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import edu.nju.businesslogic.transformbl.TransferDoc;
import edu.nju.businesslogic.transformbl.ZLoadDoc;
import edu.nju.businesslogicservice.storagelogicservice.OutWareHouseManagementService;
import edu.nju.data.StorageDataServiceImpl.StorageLocation;
import edu.nju.dataFactory.DataFactory;
import edu.nju.dataservice.storagedataservice.StorageDataService;
import edu.nju.po.InWareHouseDocLineItem;
import edu.nju.po.OutWareHouseDocPO;
import edu.nju.po.TransferDocPO;
import edu.nju.po.ZLoadDocPO;
import edu.nju.vo.InWareHouseDocVO;
import edu.nju.vo.OutWareHouseDocLineItem;
import edu.nju.vo.OutWareHouseDocVO;

public class OutWareHouseManagementbl implements OutWareHouseManagementService {

	OutWareHouseDocPO outWareHousePO;
	TransferDocPO tran;

	@Override
	public OutWareHouseDocVO getOutWareHouseDocVO_ZloadDoc(String ZloadDocID, String currInstitution) {
		// ������ģ����������ZloadDoc getZloadDocPO(int ZloadDocID)
		//// ���Լ����ݲ��������ArrayList<RecordPO> getStorageItemList(int[]
		// SendDocIDList)
		// �����ݲ���������ȡ�ôγ��ⵥ�ı��

		return this.getOutWareHouseDocVO(ZloadDocID, currInstitution, false);
	}

	@Override
	public OutWareHouseDocVO getOutWareHouseDocVO_Transfer(String TransferDocID, String currInstitution) {

		// ������ģ����������TransferPO getTransferPO(int TransferID)
		// ���Լ����ݲ��������ArrayList<RecordPO> getStorageItemList(int[] SendDocIDList)
		// �����ݲ���������ȡ�ôγ��ⵥ�ı��

		

		return this.getOutWareHouseDocVO(TransferDocID, currInstitution, true);

	}

	public OutWareHouseDocVO getOutWareHouseDocVO(String sourceID, String currInstitution, boolean control) {
		StorageDataService storageDataService = DataFactory.getStorageImpl();
		String[] itemsID;
		if (control == true) {
			TransferDoc transferDoc = null;
			try {
				transferDoc = new TransferDoc();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			TransferDocPO transferDocPO = null;
			try {

				transferDocPO = transferDoc.geTransferDocPOByID(sourceID);
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			if (transferDocPO == null) {
				JOptionPane.showMessageDialog(null, "δ�ҵ�����ת��");
				return null;//ʧ��ֱ�ӷ���null
			}

			itemsID = transferDocPO.getItemIDs();
		} else {
			ZLoadDoc zLoadDoc = new ZLoadDoc();
			ZLoadDocPO zLoadDocPO = null;
			try {
				zLoadDocPO = zLoadDoc.getZLoadDocPO(sourceID);
			} catch (RemoteException e) {
				JOptionPane.showMessageDialog(null, "Զ�̻�ȡװ������Ϣʧ��");
				e.printStackTrace();
			}

			if (zLoadDocPO == null){
				JOptionPane.showMessageDialog(null, "δ�ҵ���װ����");
				return null;//ʧ��ֱ�ӷ���null
			}
			itemsID=zLoadDocPO.getItemIDs();
				
		}

		// �����outLineItems
		ArrayList<OutWareHouseDocLineItem> list = new ArrayList<OutWareHouseDocLineItem>();
		for (String temp : itemsID) {
			OutWareHouseDocLineItem lineItem = new OutWareHouseDocLineItem(temp, new Date());
			list.add(lineItem);
		}

		// ��ѯ�����ڵĳ��ⵥID
		String currOutWareID = "";
		try {
			currOutWareID = storageDataService.getCurrOutWare_ID();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// ��������ʼ����������ȥ�½�һ��vo
		OutWareHouseDocVO outWareHouseDocVO = new OutWareHouseDocVO(list, currOutWareID, currInstitution,new Date());

		return outWareHouseDocVO;
	}

	@Override
	public void updateOutWareHouseDoc(OutWareHouseDocVO out) {
		// �����ݲ�������void updateOutWareHouseDoc(OutWareHouseDocPO out)

		StorageDataService storageDataService = DataFactory.getStorageImpl();
		try {
			storageDataService.updateOutWareHouseDoc(out.unpack());
		} catch (RemoteException e) {
			JOptionPane.showMessageDialog(null, "���³��ⵥʱ������������쳣");
			e.printStackTrace();
		}
		
		
		
	}

}
