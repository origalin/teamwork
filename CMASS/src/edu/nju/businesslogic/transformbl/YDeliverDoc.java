package edu.nju.businesslogic.transformbl;

import java.util.ArrayList;

import edu.nju.businesslogicservice.transformlogicservice.YDeliverDocService;
import edu.nju.po.DeliverDocPO;
import edu.nju.po.YDeliverDocPO;
import edu.nju.vo.YDeliverDocVO;

public class YDeliverDoc implements YDeliverDocService{

	@Override
	public void saveYDeliverDocPO(YDeliverDocPO po) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public int getYDeliverSequence() {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public void changeYDeliverDocSequence(int sequence) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public YDeliverDocVO createYDeliverDocVO(String courier) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public YDeliverDocVO findYDeliverDocVO(int courierID) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ArrayList<DeliverDocPO> getUncheckedDeliverDocPOs() {
		// TODO 自动生成的方法存根
		return null;
	}

}
