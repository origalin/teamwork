package edu.nju.businesslogic.storagebl;

import java.util.ArrayList;

import edu.nju.businesslogicservice.storagelogicservice.StorageLogicService;
import edu.nju.po.RecordPO;
import edu.nju.vo.InWareHouseDocVO;
import edu.nju.vo.OutWareHouseDocVO;

public class Storagebl implements StorageLogicService{

	@Override
	public InWareHouseDocVO getInWareHouseDocVO_Transfer(int TransferDocID) {
		// ������ģ����������TransferDocPO  getTransferPO(int TransferID)
//���ݵ���ȷ���ؿ컹�Ǿ���		
		//�����ݲ���������ȡ�ô���ⵥ�ı��
		
		return null;  
	}
	

	@Override
	public InWareHouseDocVO getInWareHouseDocVO_YloadDoc(int YloadDocID) {
		// ������ģ����������YloadDocPO  getYloadDocPO(int YloadDocID)

		//�����ݲ���������ȡ�ô���ⵥ�ı��
		return null;
	}

	@Override
	public OutWareHouseDocVO getOutWareHouseDocVO_Transfer(int TransferDocID) {
		// ������ģ����������TransferPO getTransferPO(int TransferID)
		//���Լ����ݲ��������ArrayList<RecordPO> getStorageItemList(int[] SendDocIDList)
		//�����ݲ���������ȡ�ôγ��ⵥ�ı��
		return null;
	}

	@Override
	public OutWareHouseDocVO getOutWareHouseDocVO_ZloadDoc(int ZloadDocID) {
		// ������ģ����������ZloadDoc getZloadDocPO(int ZloadDocID)
		////���Լ����ݲ��������ArrayList<RecordPO> getStorageItemList(int[] SendDocIDList)
		//�����ݲ���������ȡ�ôγ��ⵥ�ı��
		return null;
	}

	@Override
	public void updateOutWareHouseDoc(OutWareHouseDocVO out) {
		// �����ݲ�������void updateOutWareHouseDoc(OutWareHouseDocPO out)
		
	}
	
	public void updateInWareHouseDoc(InWareHouseDocVO out) {
		// �����ݲ�������void updateInWareHouseDoc(InWareHouseDocPO out)
		
	}

	@Override
	public void clear() {
		// ���Լ����ݲ���������տ����Ϣ
		
	}

	@Override
	public void addNewStorageItem(RecordPO recordPO) {
		// 
		
	}

	@Override
	public void setAlarm(double p) {
		// ���Լ����ݲ�����������µĿ�����
		
	}

	@Override
	public void setPercent(double p) {
		// ���Լ����ݲ����������õ����������İٷֱ�
		
	}
	@Override
	public void updateStorage(ArrayList<RecordPO> aList){}


	
	

}
