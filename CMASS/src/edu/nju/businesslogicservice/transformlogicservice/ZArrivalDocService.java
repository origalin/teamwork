package edu.nju.businesslogicservice.transformlogicservice;

import edu.nju.po.ZArrivalDocPO;
import edu.nju.vo.ZArrivalDocVO;

public interface ZArrivalDocService {
	public void saveZArrivalDocPO(ZArrivalDocPO po);
	public int getZArrivalSequence();
	public void changeZArrivalSequence(int ZArrivalSequence);
	public ZArrivalDocVO createZArrivalDocVO();
	public ZArrivalDocPO findZArrivalDocPO(int ID);
}
