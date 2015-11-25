package edu.nju.businesslogicservice.transformlogicservice;

import java.util.ArrayList;

import edu.nju.po.ZArrivalDocPO;
import edu.nju.vo.ZArrivalDocVO;

public interface ZArrivalDocService {
	public void saveZArrivalDocPO(ZArrivalDocPO po);//保存中转中心到达单持久化对象
	public String getZArrivalSequence();//获取到达单基准序列号
	public void changeZArrivalSequence();//改变基准序列号
	public ZArrivalDocVO findZArrivalDocVO(String ID);//获取到达单VO
	public ArrayList<ZArrivalDocPO> getUncheckedZArrivalDocPOs();
	public ZArrivalDocVO createZArrivalDocVO_TransferDoc(String fromDocID, String[][] changeStates);
	public ZArrivalDocVO createZArrivalDocVO_YLoadDoc(String fromDocID, String[][] changeStates);

}
