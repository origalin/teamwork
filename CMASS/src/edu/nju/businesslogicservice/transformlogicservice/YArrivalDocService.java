package edu.nju.businesslogicservice.transformlogicservice;

import java.util.ArrayList;

import edu.nju.po.DeliverDocPO;
import edu.nju.po.YArrivalDocPO;
import edu.nju.vo.YArrivalDocVO;

public interface YArrivalDocService {
	public void saveYArrivalDocPO(YArrivalDocPO po);//����Ӫҵ�����ﵥ�־û�����
	public int getYArrivalSequence();//��ȡ���ﵥ��׼���к�
	public void changeYArrivalSequence(int YArrivalSequence);//�ı��׼���к�
	public YArrivalDocVO createYArrivalDocVO(int ZLoadDocID);//�������ﵥVO
	public YArrivalDocVO findYArrivalDocVO(int ID);//��ȡ���ﵥVO
	public ArrayList<YArrivalDocPO> getUncheckedYaArrivalDocPOs();

}
