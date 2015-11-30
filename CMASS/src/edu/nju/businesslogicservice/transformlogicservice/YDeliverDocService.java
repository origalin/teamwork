package edu.nju.businesslogicservice.transformlogicservice;

import java.util.ArrayList;

import edu.nju.po.SendDocPO;
import edu.nju.po.YDeliverDocPO;
import edu.nju.vo.YDeliverDocVO;

public interface YDeliverDocService {
	public void saveYDeliverDocPO(YDeliverDocPO po);//�����ɼ����־û�����
	public String getYDeliverSequence();//��ȡ�ɼ������л�׼��
	public YDeliverDocVO createYDeliverDoc(String[][] courierAndID);//�����ɼ���VO
	public ArrayList<YDeliverDocVO> findYDeliverDocVOs(String courierID);//��ȡ�ɼ���VO
	public ArrayList<YDeliverDocPO> getUncheckedDeliverDocPOs();
	public YDeliverDocPO getDeliverDocPOsByID(String staffID);
	public YDeliverDocVO getDeliverDocVOsByID(String YDeliverDocID);
	public void changeYDeliverDocSequence();
	public void  confirmSave();
}
