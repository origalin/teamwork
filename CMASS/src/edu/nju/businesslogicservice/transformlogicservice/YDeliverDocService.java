package edu.nju.businesslogicservice.transformlogicservice;

import java.util.ArrayList;

import edu.nju.po.SendDocPO;
import edu.nju.po.YDeliverDocPO;
import edu.nju.vo.YDeliverDocVO;

public interface YDeliverDocService {
	public void saveYDeliverDocPO(YDeliverDocPO po);//�����ɼ����־û�����
	public String getYDeliverSequence();//��ȡ�ɼ������л�׼��
	public void createYDeliverDoc(String[][] courierAndID);//�����ɼ���VO
	public YDeliverDocVO findYDeliverDocVO(int courierID);//��ȡ�ɼ���VO
	public ArrayList<YDeliverDocPO> getUncheckedDeliverDocPOs();
	public ArrayList<YDeliverDocPO> getDeliverDocPOsByID(String staffID);
	public ArrayList<YDeliverDocVO> getDeliverDocVOsByID(String staffID);
	public void changeYDeliverDocSequence(String sequence);
}
