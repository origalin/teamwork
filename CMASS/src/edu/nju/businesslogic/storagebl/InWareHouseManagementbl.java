package edu.nju.businesslogic.storagebl;

import edu.nju.businesslogicservice.storagelogicservice.InWareHouseManagementService;
import edu.nju.po.InWareHouseDocPO;
import edu.nju.vo.InWareHouseDocVO;

public class InWareHouseManagementbl implements InWareHouseManagementService{

	InWareHouseDocPO inWareHouseDocPO;
	@Override
	public InWareHouseDocVO getInWareHouseDocVO_Transfer(int TransferDocID) {
		// ������ģ����������TransferDocPO  getTransferPO(int TransferID)
		//���ݵ���ȷ���ؿ컹�Ǿ���		
				//�����ݲ���������ȡ�ô���ⵥ�ı��       ��öԲֿ������
		return null;
	}

	@Override
	public InWareHouseDocVO getInWareHouseDocVO_YloadDoc(int YloadDocID) {
		// ������ģ����������YloadDocPO  getYloadDocPO(int YloadDocID)

				//�����ݲ���������ȡ�ô���ⵥ�ı��
		return null;
	}

	@Override
	public void updateInWareHouseDoc(InWareHouseDocVO out) {
		// �����ݲ�������void updateInWareHouseDoc(InWareHouseDocPO out)
		
	}

}
