package edu.nju.businesslogicservice.transformlogicservice;

import edu.nju.po.ZLoadDocPO;
import edu.nju.vo.ZLoadDocVO;

public interface ZLoadDocService {
	public void saveZloadDocPO(ZLoadDocPO po);
	public int getZloadSequence();
	public void changeZloadSequence(int ZloadSequence);
	public ZLoadDocVO createZLoadDocVO();
	public ZLoadDocPO findZLoadDocPO(int ID);
}
