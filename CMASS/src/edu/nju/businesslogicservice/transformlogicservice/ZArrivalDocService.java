package edu.nju.businesslogicservice.transformlogicservice;

import java.util.ArrayList;

import edu.nju.po.DeliverDocPO;
import edu.nju.po.ZArrivalDocPO;
import edu.nju.vo.ZArrivalDocVO;

public interface ZArrivalDocService {
	public void saveZArrivalDocPO(ZArrivalDocPO po);//保存中转中心到达单持久化对象
	public int getZArrivalSequence();//获取到达单基准序列号
	public void changeZArrivalSequence(int ZArrivalSequence);//改变基准序列号
	public ZArrivalDocVO createZArrivalDocVO(int TransferDocID);//创建到达单VO
	public ZArrivalDocVO findZArrivalDocVO(int ID);//获取到达单VO
	public ArrayList<ZArrivalDocPO> getUncheckedZArrivalDocPOs();

}
