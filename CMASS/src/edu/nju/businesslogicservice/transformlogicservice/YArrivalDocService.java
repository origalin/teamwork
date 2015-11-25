package edu.nju.businesslogicservice.transformlogicservice;

import java.util.ArrayList;

import edu.nju.po.YArrivalDocPO;
import edu.nju.vo.YArrivalDocVO;
import edu.nju.vo.ZArrivalDocVO;

public interface YArrivalDocService {
	public void saveYArrivalDocPO(YArrivalDocPO po);//����Ӫҵ�����ﵥ�־û�����
	public String getYArrivalSequence();//��ȡ���ﵥ��׼���к�
	public void changeYArrivalSequence();//�ı��׼���к�
	public YArrivalDocVO findYArrivalDocVO(int ID);//��ȡ���ﵥVO
	public ArrayList<YArrivalDocPO> getUncheckedYaArrivalDocPOs();
	public YArrivalDocVO createYArrivalDocVO(String fromDocID, String[][] changeStates);
	public String getAddressByID(String itemID);
	public String[] getCouriers();
}
