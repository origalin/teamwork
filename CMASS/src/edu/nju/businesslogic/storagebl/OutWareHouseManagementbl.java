package edu.nju.businesslogic.storagebl;

import edu.nju.businesslogicservice.storagelogicservice.OutWareHouseManagementService;
import edu.nju.po.OutWareHouseDocPO;
import edu.nju.po.TransferDocPO;
import edu.nju.vo.OutWareHouseDocVO;

public class OutWareHouseManagementbl implements OutWareHouseManagementService{

	OutWareHouseDocPO outWareHousePO;
	TransferDocPO tran;
	@Override
	public OutWareHouseDocVO getOutWareHouseDocVO_ZloadDoc(String ZloadDocID,String currInstitution) {
		// ������ģ����������ZloadDoc getZloadDocPO(int ZloadDocID)
		////���Լ����ݲ��������ArrayList<RecordPO> getStorageItemList(int[] SendDocIDList)
		//�����ݲ���������ȡ�ôγ��ⵥ�ı��
		return null;
	}

	@Override
	public OutWareHouseDocVO getOutWareHouseDocVO_Transfer(String TransferDocID,String currInstitution) {
		
		// ������ģ����������TransferPO getTransferPO(int TransferID)
		//���Լ����ݲ��������ArrayList<RecordPO> getStorageItemList(int[] SendDocIDList)
		//�����ݲ���������ȡ�ôγ��ⵥ�ı��
		return null;
	}

	@Override
	public void updateOutWareHouseDoc(OutWareHouseDocVO out) {
		// �����ݲ�������void updateOutWareHouseDoc(OutWareHouseDocPO out)
		
	}

}
