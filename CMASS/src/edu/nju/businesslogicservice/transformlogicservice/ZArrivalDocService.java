package edu.nju.businesslogicservice.transformlogicservice;

import java.util.ArrayList;

import edu.nju.po.ZArrivalDocPO;
import edu.nju.vo.ZArrivalDocVO;

public interface ZArrivalDocService {
	public void saveZArrivalDocPO(ZArrivalDocPO po);//������ת���ĵ��ﵥ�־û�����
	public String getZArrivalSequence();//��ȡ���ﵥ��׼���к�
	public void changeZArrivalSequence();//�ı��׼���к�
	public ZArrivalDocVO findZArrivalDocVO(String ID);//��ȡ���ﵥVO
	public ArrayList<ZArrivalDocPO> getUncheckedZArrivalDocPOs();
	public ZArrivalDocVO createZArrivalDocVO_TransferDoc(String fromDocID, String[][] changeStates);
	public ZArrivalDocVO createZArrivalDocVO_YLoadDoc(String fromDocID, String[][] changeStates);

}
