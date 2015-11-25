package edu.nju.businesslogicservice.transformlogicservice;

import java.util.ArrayList;

import edu.nju.po.YLoadDocPO;
import edu.nju.vo.YLoadDocVO;

public interface YLoadDocService {
	public void saveYloadDocPO(YLoadDocPO po);//����Ӫҵ��װ�����־û�����
	public String[] getSendDocIDList(String id);
	public String getYloadSequence();//��ȡװ������׼���к�
	public void changeYloadSequence();//�ı��׼���к�
	public YLoadDocVO createYLoadDocVO(String carID, String target,
			String watcher,String driver, String[] itemIDs);//����װ����VO
	public YLoadDocVO findYLoadDocVO(int ID);//��ȡװ����VO
	public ArrayList<YLoadDocPO> getUncheckedyLoadDocPOs();
	public double[] getPriceToday();
	public YLoadDocPO getYloadPOByID(String ID);
	public String getTransferCenter();
	public String getDrivers();
}
