package edu.nju.businesslogic.transformbl;

import java.util.ArrayList;

import edu.nju.businesslogicservice.transformlogicservice.YLoadDocService;
import edu.nju.po.YLoadDocPO;
import edu.nju.vo.YLoadDocVO;

public class YLoadDoc implements YLoadDocService{

	@Override
	public void saveYloadDocPO(YLoadDocPO po) {
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public int[] getSendDocIDList(int id) {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public int getYloadSequence() {
		// TODO �Զ����ɵķ������
		return 0;
	}

	@Override
	public void changeYloadSequence(int YloadSequence) {
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public YLoadDocVO createYLoadDocVO(int carID, String target,
			String watcher, String deliver) {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public YLoadDocVO findYLoadDocVO(int ID) {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public ArrayList<YLoadDocPO> getUncheckedyLoadDocPOs() {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public double[] getPriceToday() {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public YLoadDocPO getYloadPOByID(String ID) {
		// TODO Auto-generated method stub
		return null;
	}

}
