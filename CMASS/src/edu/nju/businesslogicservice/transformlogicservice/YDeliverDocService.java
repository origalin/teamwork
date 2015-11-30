package edu.nju.businesslogicservice.transformlogicservice;

import java.util.ArrayList;

import edu.nju.po.SendDocPO;
import edu.nju.po.YDeliverDocPO;
import edu.nju.vo.YDeliverDocVO;

public interface YDeliverDocService {
	public void saveYDeliverDocPO(YDeliverDocPO po);//保存派件单持久化对象
	public String getYDeliverSequence();//获取派件单序列基准号
	public YDeliverDocVO createYDeliverDoc(String[][] courierAndID);//创建派件单VO
	public ArrayList<YDeliverDocVO> findYDeliverDocVOs(String courierID);//获取派件单VO
	public ArrayList<YDeliverDocPO> getUncheckedDeliverDocPOs();
	public YDeliverDocPO getDeliverDocPOsByID(String staffID);
	public YDeliverDocVO getDeliverDocVOsByID(String YDeliverDocID);
	public void changeYDeliverDocSequence();
	public void  confirmSave();
}
