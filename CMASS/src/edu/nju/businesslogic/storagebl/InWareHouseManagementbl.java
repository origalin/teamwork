package edu.nju.businesslogic.storagebl;

import edu.nju.businesslogic.transformbl.TransferDoc;
import edu.nju.businesslogicservice.storagelogicservice.InWareHouseManagementService;
import edu.nju.po.InWareHouseDocPO;
import edu.nju.po.TransferDocPO;
import edu.nju.vo.InWareHouseDocVO;

public class InWareHouseManagementbl implements InWareHouseManagementService{

	InWareHouseDocPO inWareHouseDocPO;
	@Override
	public InWareHouseDocVO getInWareHouseDocVO_Transfer(String TransferDocID) {
		// ������ģ����������TransferDocPO  getTransferPO(int TransferID)
		//���ݵ���ȷ���ؿ컹�Ǿ���		
				//�����ݲ���������ȡ�ô���ⵥ�ı��       ��öԲֿ������
		TransferDoc transferDoc=new TransferDoc();
		TransferDocPO transferDocPO=transferDoc.geTransferDocPOByID(TransferDocID);
		
		return null;
	}

	@Override
	public InWareHouseDocVO getInWareHouseDocVO_YloadDoc(String YloadDocID) {
		// ������ģ����������YloadDocPO  getYloadDocPO(int YloadDocID)

				//�����ݲ���������ȡ�ô���ⵥ�ı��
		return null;
	}

	@Override
	public void updateInWareHouseDoc(InWareHouseDocVO out) {
		// �����ݲ�������void updateInWareHouseDoc(InWareHouseDocPO out)
		
	}
	
	public String getAddressDatail(String ItemID){
		//���������
		return null;
	}

}
