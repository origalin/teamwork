package edu.nju.businesslogicservice.transformlogicservice;

import edu.nju.po.YArrivalDocPO;
import edu.nju.vo.YArrivalDocVO;

public interface YArrivalDocService {
	public void saveYArrivalDocPO(YArrivalDocPO po);
	public int getYArrivalSequence();
	public void changeYArrivalSequence(int YArrivalSequence);
	public YArrivalDocVO createYArrivalDocVO();
	public YArrivalDocPO findYArrivalDocPO(int ID);
}
