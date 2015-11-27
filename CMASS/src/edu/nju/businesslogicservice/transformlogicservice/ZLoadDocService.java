package edu.nju.businesslogicservice.transformlogicservice;

import java.util.ArrayList;

import edu.nju.po.ZLoadDocPO;
import edu.nju.vo.ZLoadDocVO;

public interface ZLoadDocService {
	public void saveZloadDocPO(ZLoadDocPO po);//������ת����װ�����־û�����
	public String getZloadSequence();//��ȡװ������׼���к�
	public String[] getSendDocIDList(String id);
	public void changeZloadSequence();//�ı��׼���к�
	public ZLoadDocVO createZLoadDocVO(String carID,String target,String watcher,String driver,String[] itemIDs);//����װ����VO
	public ZLoadDocVO findZLoadDocVO(int ID);//��ȡװ����VO/
	public ArrayList<ZLoadDocPO> getUncheckedZLoadDocPOs();
	public double[] getPriceToday();
	public String[] getSubBusinessHall();
	public String[] getDrivers();
	public int getDriverTime(String drrverID);
}
