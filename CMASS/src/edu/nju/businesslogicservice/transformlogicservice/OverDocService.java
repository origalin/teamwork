package edu.nju.businesslogicservice.transformlogicservice;

import java.util.ArrayList;

import edu.nju.po.OverDocPO;
import edu.nju.vo.OverDocVO;

public interface OverDocService {
	public void saveOverDocPO(OverDocPO po);//�����ռ����־û�����
	public String getOverDocSequence();//��ȡ�ռ�����׼���к�
	public void changeOverDocSequence(int sequence);//�ı��׼���к�
	public OverDocVO findOverDocVO(int ID);//��ȡ�ռ���VO
	public ArrayList<OverDocPO> getUncheckedOverDocPOs();
	public OverDocVO createOverDocVO(String[] itemIDs ,String[] receivers);
}
