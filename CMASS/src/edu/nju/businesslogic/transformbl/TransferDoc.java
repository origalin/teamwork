package edu.nju.businesslogic.transformbl;
import java.util.ArrayList;

import edu.nju.businesslogic.infobl.Institution;
import edu.nju.businesslogicservice.transformlogicservice.*;
import edu.nju.po.TransferDocPO;
import edu.nju.po.TransferDoc_PlanePO;
import edu.nju.vo.TransferDocVO;
import edu.nju.vo.TransferDoc_CarVO;
import edu.nju.vo.TransferDoc_PlaneVO;
import edu.nju.vo.TransferDoc_TrainVO;

public class TransferDoc implements TransferDocService{
	String institutionID,staffID;

	public TransferDoc (){
		this(null, null);
	}

	public TransferDoc(String institutionID, String staffID) {
		super();
		this.institutionID = institutionID;
		this.staffID = staffID;
	}

	@Override
	public void saveTransferDocPO(TransferDocPO po) {
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public String getTransferSequence() {
		// TODO �Զ����ɵķ������
		return null;
	}
	public String getTransferID() {
		return null;
		
	}
	public void changeTransferID() {
		
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
	public TransferDoc_CarVO createTransferDocVO_Car(String city,
			String carNum, String tranceID, String watcher,String[] itemIDs) {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public TransferDoc_PlaneVO createTransferDocVO_Plane(String city,
			String carNum, String tranceID, String watcher, int container,String[] itemIDs) {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public TransferDoc_TrainVO createTransferDocVO_Train(String city,
			String carNum, String tranceID, String watcher, int carriage,String[] itemIDs) {
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
