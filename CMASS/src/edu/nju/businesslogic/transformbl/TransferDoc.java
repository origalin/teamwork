package edu.nju.businesslogic.transformbl;
import java.util.ArrayList;

import edu.nju.businesslogicservice.transformlogicservice.*;
import edu.nju.po.TransferDocPO;
import edu.nju.vo.TransferDocVO;

public class TransferDoc implements TransferDocService{

	@Override
	public void saveTransferDocPO(TransferDocPO po) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public int getTransferSequence() {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public int[] getSendDocIDList(int id) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public void changeTransferSequence(int TransferSequence) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public TransferDocVO createTransferDoc_CarVO(int transferCenterID,
			int carNum, int tranceID) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public TransferDocVO createTransferDocVO_Plane(int transferCenterID,
			int carNum, int tranceID, int container) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public TransferDocVO createTransferDocVO_Train(int transferCenterID,
			int carNum, int tranceID, int carriage) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public TransferDocVO findTransferDocVO(int ID) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ArrayList<TransferDocPO> getUncheckedTransferDocPOs() {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public double[] getPriceToday() {
		// TODO 自动生成的方法存根
		return null;
	}

}
