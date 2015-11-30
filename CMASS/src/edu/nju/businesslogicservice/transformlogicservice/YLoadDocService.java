package edu.nju.businesslogicservice.transformlogicservice;

import java.util.ArrayList;

import edu.nju.po.YLoadDocPO;
import edu.nju.vo.YLoadDocVO;

public interface YLoadDocService {
	public void saveYloadDocPO(YLoadDocPO po);//����Ӫҵ��װ�����־û�����
	public String getYloadSequence();//��ȡװ������׼���к�
	public void changeYloadSequence();//�ı��׼���к�
	public YLoadDocVO createYLoadDocVO(String carID, String target,
			String watcher,String driver, String[] itemIDs);//����װ����VO
	public YLoadDocVO getYLoadDocVO(String ID);//��ȡװ����VO
	public ArrayList<YLoadDocPO> getUncheckedyLoadDocPOs();
	public double[] getPriceToday();
	public YLoadDocPO getYloadDocPOByID(String ID);
	public String getTransferCenter();
	public String[][] getDrivers();
	public int getDriverTime(String drrverID);
	public void  confirmSave();
}
