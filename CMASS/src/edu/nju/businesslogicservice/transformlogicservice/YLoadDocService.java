package edu.nju.businesslogicservice.transformlogicservice;

import edu.nju.po.YLoadDocPO;
import edu.nju.vo.YLoadDocVO;

public interface YLoadDocService {
	public void saveYloadDocPO(YLoadDocPO po);//����Ӫҵ��װ�����־û�����
	public int getYloadSequence();//��ȡװ������׼���к�
	public void changeYloadSequence(int YloadSequence);//�ı��׼���к�
	public YLoadDocVO createYLoadDocVO(int carID,String target,String watcher,String deliver);//����װ����VO
	public YLoadDocVO findYLoadDocVO(int ID);//��ȡװ����VO
}