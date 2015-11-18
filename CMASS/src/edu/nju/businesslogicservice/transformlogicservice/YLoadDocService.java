package edu.nju.businesslogicservice.transformlogicservice;

import java.util.ArrayList;

import edu.nju.po.YLoadDocPO;
import edu.nju.vo.YLoadDocVO;

public interface YLoadDocService {
	public void saveYloadDocPO(YLoadDocPO po);//保存营业厅装车单持久化对象
	public int[] getSendDocIDList(int id);
	public int getYloadSequence();//获取装车单基准序列号
	public void changeYloadSequence(int YloadSequence);//改变基准序列号
	public YLoadDocVO createYLoadDocVO(int carID,String target,String watcher,String deliver);//创建装车单VO
	public YLoadDocVO findYLoadDocVO(int ID);//获取装车单VO
	public ArrayList<YLoadDocPO> getUncheckedyLoadDocPOs();
	public double[] getPriceToday();
}
