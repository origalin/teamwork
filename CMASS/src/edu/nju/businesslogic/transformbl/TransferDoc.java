package edu.nju.businesslogic.transformbl;
import java.util.ArrayList;

import edu.nju.businesslogicservice.transformlogicservice.*;
import edu.nju.po.TransferDocPO;
import edu.nju.vo.TransferDocVO;

public class TransferDoc implements TransferDocService{

	@Override
	public void saveTransferDocPO(TransferDocPO po) {
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public int getTransferSequence() {
		// TODO �Զ����ɵķ������
		return 0;
	}

	@Override
	public int[] getSendDocIDList(int id) {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public void changeTransferSequence(int TransferSequence) {
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public TransferDocVO createTransferDoc_CarVO(int transferCenterID,
			int carNum, int tranceID) {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public TransferDocVO createTransferDocVO_Plane(int transferCenterID,
			int carNum, int tranceID, int container) {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public TransferDocVO createTransferDocVO_Train(int transferCenterID,
			int carNum, int tranceID, int carriage) {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public TransferDocVO findTransferDocVO(int ID) {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public ArrayList<TransferDocPO> getUncheckedTransferDocPOs() {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public double[] getPriceToday() {
		// TODO �Զ����ɵķ������
		return null;
	}

}
