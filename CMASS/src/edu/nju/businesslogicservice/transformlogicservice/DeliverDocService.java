package edu.nju.businesslogicservice.transformlogicservice;

import edu.nju.po.YDeliverDocPO;
import edu.nju.vo.YDeliverDocVO;

public interface DeliverDocService {
	public void saveYDeliverDocPO(YDeliverDocPO po);//�����ɼ����־û�����
	public int getYDeliverSequence();//��ȡ�ɼ������л�׼��
	public void changeYDeliverDocSequence(int sequence);//�ı��ɼ�����׼���к�
	public YDeliverDocVO createYDeliverDocVO(String courier);//�����ɼ���VO
	public YDeliverDocVO findYDeliverDocVO(int courierID);//��ȡ�ɼ���VO
}