package edu.nju.businesslogicservice.transformlogicservice;

import edu.nju.po.YArrivalDocPO;
import edu.nju.po.YLoadDocPO;
import edu.nju.po.ZLoadDocPO;
import edu.nju.vo.YArrivalDocVO;
import edu.nju.vo.YLoadDocVO;

public interface YLoadDocService {
	public void saveYloadDocPO(YLoadDocPO po);
	public int getYloadSequence();
	public void changeYloadSequence(int YloadSequence);
	public YLoadDocVO createYLoadDocVO();
	public YLoadDocPO findYLoadDocPO(int ID);
}
