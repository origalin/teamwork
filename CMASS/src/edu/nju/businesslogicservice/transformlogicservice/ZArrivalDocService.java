package edu.nju.businesslogicservice.transformlogicservice;

import edu.nju.po.ZArrivalDocPO;
import edu.nju.vo.ZArrivalDocVO;

public interface ZArrivalDocService {
	public void saveZArrivalDocPO(ZArrivalDocPO po);//������ת���ĵ��ﵥ�־û�����
	public int getZArrivalSequence();//��ȡ���ﵥ��׼���к�
	public void changeZArrivalSequence(int ZArrivalSequence);//�ı��׼���к�
	public ZArrivalDocVO createZArrivalDocVO(int TransferDocID);//�������ﵥVO
	public ZArrivalDocVO findZArrivalDocVO(int ID);//��ȡ���ﵥVO
}
