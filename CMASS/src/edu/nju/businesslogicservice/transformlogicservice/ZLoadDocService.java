package edu.nju.businesslogicservice.transformlogicservice;

import edu.nju.po.ZLoadDocPO;
import edu.nju.vo.ZLoadDocVO;

public interface ZLoadDocService {
	public void saveZloadDocPO(ZLoadDocPO po);//������ת����װ�����־û�����
	public int getZloadSequence();//��ȡװ������׼���к�
	public int[] getSendDocIDList(int id);
	public void changeZloadSequence(int ZloadSequence);//�ı��׼���к�
	public ZLoadDocVO createZLoadDocVO(int carID,String target,String watcher,String deliver);//����װ����VO
	public ZLoadDocVO findZLoadDocVO(int ID);//��ȡװ����VO/
}
