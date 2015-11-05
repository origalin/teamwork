package edu.nju.businesslogicservice.transformlogicservice;

import edu.nju.po.SendDocPO;
import edu.nju.po.TransferDocPO;
import edu.nju.po.YArrivalDocPO;
import edu.nju.po.YDeliverDocPO;
import edu.nju.po.ZArrivalDocPO;
import edu.nju.po.ZLoadDocPO;
import edu.nju.vo.SendDocVO;

public interface TransformLogicService {
	public void saveTransferDocPO(TransferDocPO po);
	public int getTransferSequence();
	public void changeTransferSequence(int TransferSequence);
	public void saveZloadDocPO(ZLoadDocPO po);
	public int getZloadSequence();
	public void changeZloadSequence(int ZloadSequence);
	public void saveZArrivalDocPO(ZArrivalDocPO po);
	public int getZArrivalSequence();
	public void changeZArrivalSequence(int ZArrivalSequence);
	public void saveYArrivalDocPO(YArrivalDocPO po);
	public int getYArrivalSequence();
	public void changeYArrivalSequence(int YArrivalSequence);
	public void saveYDeliverDocPO(YDeliverDocPO po);
	public int getYDeliverSequence();
}
