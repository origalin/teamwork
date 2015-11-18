package edu.nju.businesslogicservice.transformlogicservice;

import java.util.ArrayList;

import edu.nju.po.SendDocPO;
import edu.nju.po.YDeliverDocPO;
import edu.nju.vo.YDeliverDocVO;

public interface YDeliverDocService {
	public void saveYDeliverDocPO(YDeliverDocPO po);//保存派件单持久化对象
	public int getYDeliverSequence();//获取派件单序列基准号
	public void changeYDeliverDocSequence(int sequence);//改变派件单基准序列号
	public YDeliverDocVO createYDeliverDocVO(String courier);//创建派件单VO
	public YDeliverDocVO findYDeliverDocVO(int courierID);//获取派件单VO
	public ArrayList<YDeliverDocPO> getUncheckedDeliverDocPOs();
	public ArrayList<YDeliverDocPO> getDeliverDocPOsByID(String staffID);
	public ArrayList<YDeliverDocVO> getDeliverDocVOsByID(String staffID);
}
