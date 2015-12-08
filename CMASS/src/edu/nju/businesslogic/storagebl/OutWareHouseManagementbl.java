package edu.nju.businesslogic.storagebl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import edu.nju.businesslogic.transferbl.TransferDoc;
import edu.nju.businesslogic.transferbl.ZLoadDoc;
import edu.nju.businesslogicservice.storagelogicservice.OutWareHouseManagementService;
import edu.nju.data.StorageDataServiceImpl.StorageLocation;
import edu.nju.dataFactory.DataFactory;
import edu.nju.dataservice.storagedataservice.StorageDataService;
import edu.nju.exception.DatabaseNULLException;
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
	public OutWareHouseDocVO getOutWareHouseDocVO_ZloadDoc(String ZloadDocID, String currInstitution)
			throws DatabaseNULLException, RemoteException {
		// ������ģ����������ZloadDoc getZloadDocPO(int ZloadDocID)
		//// ���Լ����ݲ��������ArrayList<RecordPO> getStorageItemList(int[]
		// SendDocIDList)
		// �����ݲ���������ȡ�ôγ��ⵥ�ı��

		return this.getOutWareHouseDocVO(ZloadDocID, currInstitution, false);
	}

	@Override
	public OutWareHouseDocVO getOutWareHouseDocVO_Transfer(String TransferDocID, String currInstitution)
			throws DatabaseNULLException, RemoteException {

		// ������ģ����������TransferPO getTransferPO(int TransferID)
		// ���Լ����ݲ��������ArrayList<RecordPO> getStorageItemList(int[] SendDocIDList)
		// �����ݲ���������ȡ�ôγ��ⵥ�ı��

		return this.getOutWareHouseDocVO(TransferDocID, currInstitution, true);

	}

	public OutWareHouseDocVO getOutWareHouseDocVO(String sourceID, String currInstitution, boolean control)
			throws DatabaseNULLException, RemoteException {
		StorageDataService storageDataService = DataFactory.getStorageImpl();
		String[] itemsID;
		if (control == true) {
			TransferDoc transferDoc = new TransferDoc();

			TransferDocPO transferDocPO = transferDoc.geTransferDocPOByID(sourceID);

			if (transferDocPO == null) {
				JOptionPane.showMessageDialog(null, "δ�ҵ�����ת��");
				return null;// ʧ��ֱ�ӷ���null
			}

			itemsID = transferDocPO.getItemIDs();
		} else {
			ZLoadDoc zLoadDoc = new ZLoadDoc();
			ZLoadDocPO zLoadDocPO = zLoadDoc.getZLoadDocPO(sourceID);

			if (zLoadDocPO == null) {
				JOptionPane.showMessageDialog(null, "δ�ҵ���װ����");
				return null;// ʧ��ֱ�ӷ���null
			}
			itemsID = zLoadDocPO.getItemIDs();

		}

		// �����outLineItems
		ArrayList<OutWareHouseDocLineItem> list = new ArrayList<OutWareHouseDocLineItem>();
		for (String temp : itemsID) {
			OutWareHouseDocLineItem lineItem = new OutWareHouseDocLineItem(temp);
			list.add(lineItem);
		}

		// ��ѯ�����ڵĳ��ⵥID
		String currOutWareID = "";

		currOutWareID = storageDataService.getCurrOutWare_ID();

		// ��������ʼ����������ȥ�½�һ��vo
		OutWareHouseDocVO outWareHouseDocVO = new OutWareHouseDocVO(list, currOutWareID, currInstitution, new Date());

		return outWareHouseDocVO;
	}

	@Override
	public void updateOutWareHouseDoc(OutWareHouseDocVO out) {
		// �����ݲ�������void updateOutWareHouseDoc(OutWareHouseDocPO out)

		StorageDataService storageDataService = DataFactory.getStorageImpl();
		try {
			OutWareHouseDocPO po=out.unpack();
			System.out.println(po);
			storageDataService.updateOutWareHouseDoc(po);
		} catch (RemoteException e) {
			JOptionPane.showMessageDialog(null, "���³��ⵥʱ������������쳣");
			e.printStackTrace();
		}
		
		System.out.println(out);

	}

}
