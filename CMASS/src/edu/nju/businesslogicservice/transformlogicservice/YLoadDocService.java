package edu.nju.businesslogicservice.transformlogicservice;

import java.util.ArrayList;

import edu.nju.po.YLoadDocPO;
import edu.nju.vo.YLoadDocVO;

public interface YLoadDocService {
	public void saveYloadDocPO(YLoadDocPO po);//保存营业厅装车单持久化对象
	public String[] getSendDocIDList(String id);
	public String getYloadSequence();//获取装车单基准序列号
	public void changeYloadSequence();//改变基准序列号
	public YLoadDocVO createYLoadDocVO(String carID, String target,
			String watcher,String driver, String[] itemIDs);//创建装车单VO
	public YLoadDocVO getYLoadDocVO(String ID);//获取装车单VO
	public ArrayList<YLoadDocPO> getUncheckedyLoadDocPOs();
	public double[] getPriceToday();
	public YLoadDocPO getYloadDocPOByID(String ID);
	public String getTransferCenter();
	public String[][] getDrivers();
	public int getDriverTime(String drrverID);
}
