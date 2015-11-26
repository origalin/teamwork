package edu.nju.businesslogic.storagebl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import edu.nju.businesslogic.transformbl.TransferDoc;
import edu.nju.businesslogicservice.storagelogicservice.InWareHouseManagementService;
import edu.nju.dataFactory.DataFactory;
import edu.nju.dataservice.storagedataservice.StorageDataService;
import edu.nju.po.InWareHouseDocPO;
import edu.nju.po.TransferDocPO;
import edu.nju.vo.InWareHouseDocLineItem;
import edu.nju.vo.InWareHouseDocVO;

public class InWareHouseManagementbl implements InWareHouseManagementService {

	InWareHouseDocPO inWareHouseDocPO;

	@Override
	public InWareHouseDocVO getInWareHouseDocVO_Transfer(String TransferDocID) {
		// ������ģ����������TransferDocPO getTransferPO(int TransferID)
		// ���ݵ���ȷ���ؿ컹�Ǿ���
		// �����ݲ���������ȡ�ô���ⵥ�ı�� ��öԲֿ������

		TransferDoc transferDoc = new TransferDoc();
		TransferDocPO transferDocPO = transferDoc.geTransferDocPOByID(TransferDocID);
//		StorageDataService storageDataService = DataFactory.getStorageImpl();
//		storageDataService.
		
		String[] itemsID = transferDocPO.getItemIDs();
		ArrayList<InWareHouseDocLineItem> list = new ArrayList<InWareHouseDocLineItem>();
		for (String temp : itemsID) {
			String district = "";
			if (temp.charAt(0) == '0')
				district = "������";
			else if (temp.charAt(0) == '1')
				district = "������";
			else
				district = "������";

			InWareHouseDocLineItem lineItem = new InWareHouseDocLineItem(temp, new Date(), district);
			list.add(lineItem);
		}
		StorageDataService storageDataService = DataFactory.getStorageImpl();
		String currInWareID = "";
		try {
			currInWareID = storageDataService.getCurrInWare_ID();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		InWareHouseDocVO inWareHouseDocVO = new InWareHouseDocVO(currInWareID, list);

		return inWareHouseDocVO;
	}

	@Override
	public InWareHouseDocVO getInWareHouseDocVO_YloadDoc(String YloadDocID) {
		// ������ģ����������YloadDocPO getYloadDocPO(int YloadDocID)

		// �����ݲ���������ȡ�ô���ⵥ�ı��
		return null;
	}

	@Override
	public void updateInWareHouseDoc(InWareHouseDocVO out) {
		// �����ݲ�������void updateInWareHouseDoc(InWareHouseDocPO out)

	}

	public String getAddressDatail(String ItemID) {
		// ���������
		return null;
	}

}
