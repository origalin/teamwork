package edu.nju.businesslogicservice.transformlogicservice;

import edu.nju.po.ZLoadDocPO;
import edu.nju.vo.ZLoadDocVO;

public interface ZLoadDocService {
	public void saveZloadDocPO(ZLoadDocPO po);//保存中转中心装车单持久化对象
	public int getZloadSequence();//获取装车单基准序列号
	public void changeZloadSequence(int ZloadSequence);//改变基准序列号
	public ZLoadDocVO createZLoadDocVO(int carID,String target,String watcher,String deliver);//创建装车单VO
	public ZLoadDocVO findZLoadDocVO(int ID);//获取装车单VO/
}
