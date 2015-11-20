package edu.nju.businesslogic.transformbl;

import java.util.ArrayList;

import edu.nju.businesslogicservice.transformlogicservice.ZLoadDocService;
import edu.nju.po.ZLoadDocPO;
import edu.nju.vo.ZLoadDocVO;

public class ZLoadDoc implements ZLoadDocService{
	String institutionID;
	String staffID;

	public ZLoadDoc(String institutionID, String staffID) {
		super();
		this.institutionID = institutionID;
		this.staffID = staffID;
	}

	@Override
	public void saveZloadDocPO(ZLoadDocPO po) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public int getZloadSequence() {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public int[] getSendDocIDList(int id) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public void changeZloadSequence(int ZloadSequence) {
		// TODO 自动生成的方法存根
		
	}



	@Override
	public ZLoadDocVO findZLoadDocVO(int ID) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ArrayList<ZLoadDocPO> getUncheckedZLoadDocPOs() {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public double[] getPriceToday() {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public String[] getSubBusinessHall() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] getDrivers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ZLoadDocVO createZLoadDocVO(String carID, String target, String watcher, String driver, String[] itemIDs) {
		// TODO Auto-generated method stub
		return null;
	}

}
