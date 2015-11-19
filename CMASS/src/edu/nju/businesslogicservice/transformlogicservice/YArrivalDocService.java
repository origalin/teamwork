package edu.nju.businesslogicservice.transformlogicservice;

import java.util.ArrayList;

import edu.nju.po.YArrivalDocPO;
import edu.nju.vo.YArrivalDocVO;
import edu.nju.vo.ZArrivalDocVO;

public interface YArrivalDocService {
	public void saveYArrivalDocPO(YArrivalDocPO po);//保存营业厅到达单持久化对象
	public int getYArrivalSequence();//获取到达单基准序列号
	public void changeYArrivalSequence(int YArrivalSequence);//改变基准序列号
	public YArrivalDocVO findYArrivalDocVO(int ID);//获取到达单VO
	public ArrayList<YArrivalDocPO> getUncheckedYaArrivalDocPOs();
	public YArrivalDocVO createYArrivalDocVO(String fromDocID, String[][] changeStates);

}
