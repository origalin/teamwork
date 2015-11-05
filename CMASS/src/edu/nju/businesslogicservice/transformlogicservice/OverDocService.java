package edu.nju.businesslogicservice.transformlogicservice;

import edu.nju.po.OverDocPO;
import edu.nju.vo.OverDocVO;

public interface OverDocService {
	public void saveOverDocPO(OverDocPO po);//�����ռ����־û�����
	public int getOverDocSequence();//��ȡ�ռ�����׼���к�
	public void changeOverDocSequence(int sequence);//�ı��׼���к�
	public OverDocVO createOverDocDocVO();//�����ռ���VO
	public OverDocVO findOverDocVO(int ID);//��ȡ�ռ���VO
}
