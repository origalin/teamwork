package edu.nju.businesslogic.transformbl;

import java.util.ArrayList;

import edu.nju.businesslogicservice.transformlogicservice.ZLoadDocService;
import edu.nju.po.ZLoadDocPO;
import edu.nju.vo.ZLoadDocVO;

public class ZLoadDoc implements ZLoadDocService{

	@Override
	public void saveZloadDocPO(ZLoadDocPO po) {
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public int getZloadSequence() {
		// TODO �Զ����ɵķ������
		return 0;
	}

	@Override
	public int[] getSendDocIDList(int id) {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public void changeZloadSequence(int ZloadSequence) {
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public ZLoadDocVO createZLoadDocVO(int carID, String target,
			String watcher, String deliver) {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public ZLoadDocVO findZLoadDocVO(int ID) {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public ArrayList<ZLoadDocPO> getUncheckedZLoadDocPOs() {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public double[] getPriceToday() {
		// TODO �Զ����ɵķ������
		return null;
	}

}