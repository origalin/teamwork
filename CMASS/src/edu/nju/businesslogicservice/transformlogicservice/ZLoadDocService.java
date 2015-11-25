package edu.nju.businesslogicservice.transformlogicservice;

import java.util.ArrayList;

import edu.nju.po.ZLoadDocPO;
import edu.nju.vo.ZLoadDocVO;

public interface ZLoadDocService {
	public void saveZloadDocPO(ZLoadDocPO po);//保存中转中心装车单持久化对象
	public String getZloadSequence();//获取装车单基准序列号
	public String[] getSendDocIDList(String id);
	public void changeZloadSequence();//改变基准序列号
	public ZLoadDocVO createZLoadDocVO(String carID,String target,String watcher,String driver,String[] itemIDs);//创建装车单VO
	public ZLoadDocVO findZLoadDocVO(int ID);//获取装车单VO/
	public ArrayList<ZLoadDocPO> getUncheckedZLoadDocPOs();
	public double[] getPriceToday();
	public String[] getSubBusinessHall();
	public String[] getDrivers();
}
