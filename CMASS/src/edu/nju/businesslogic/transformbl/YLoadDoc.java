package edu.nju.businesslogic.transformbl;

import java.util.ArrayList;

import edu.nju.businesslogicservice.transformlogicservice.YLoadDocService;
import edu.nju.po.YLoadDocPO;
import edu.nju.vo.YLoadDocVO;

public class YLoadDoc implements YLoadDocService{

	@Override
	public void saveYloadDocPO(YLoadDocPO po) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public int[] getSendDocIDList(int id) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public int getYloadSequence() {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public void changeYloadSequence(int YloadSequence) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public YLoadDocVO createYLoadDocVO(int carID, String target,
			String watcher, String deliver) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public YLoadDocVO findYLoadDocVO(int ID) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ArrayList<YLoadDocPO> getUncheckedyLoadDocPOs() {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public double[] getPriceToday() {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public YLoadDocPO getYloadPOByID(String ID) {
		// TODO Auto-generated method stub
		return null;
	}

}
