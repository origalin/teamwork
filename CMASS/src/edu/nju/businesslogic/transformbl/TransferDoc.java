package edu.nju.businesslogic.transformbl;
import java.util.ArrayList;
import java.util.Date;

import edu.nju.businesslogic.infobl.Institution;
import edu.nju.businesslogicservice.transformlogicservice.*;
import edu.nju.po.TransferDocPO;
import edu.nju.po.TransferDoc_CarPO;
import edu.nju.po.TransferDoc_PlanePO;
import edu.nju.po.TransferDoc_TrainPO;
import edu.nju.tools.Time;
import edu.nju.vo.TransferDocVO;
import edu.nju.vo.TransferDoc_CarVO;
import edu.nju.vo.TransferDoc_PlaneVO;
import edu.nju.vo.TransferDoc_TrainVO;

public class TransferDoc implements TransferDocService{
	String institutionID,staffID;
	TransferDocPO po;
	Institution institution;
	public TransferDoc (){
		this( null);
	}

	public TransferDoc(String staffID) {
		super();
		this.staffID = staffID;
		institution = new Institution();
	}
	

	@Override
	public void saveTransferDocPO(TransferDocPO po) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public String getTransferSequence() {
		// TODO 自动生成的方法存根
		return null;
	}
	public String getTransferID() {
		return null;
		
	}
	public void changeTransferID() {
		
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
	public TransferDoc_CarVO createTransferDocVO_Car(String city,
			String carNum, String watcher,String[] itemIDs) {
		// TODO 自动生成的方法存根
		po = new TransferDoc_CarPO(institutionID+Time.toDocTime(new Date())+getTransferSequence(), new Date(), carNum, getTransferID(), institution.getCityAndName(institution.getInstitutionID(staffID)), city, calcPrice(city), itemIDs);
		return new TransferDoc_CarVO((TransferDoc_CarPO) po);
	}

	@Override
	public TransferDoc_PlaneVO createTransferDocVO_Plane(String city,
			String carNum, String watcher, String container,String[] itemIDs) {
		// TODO 自动生成的方法存根
		po = new TransferDoc_PlanePO(institutionID+Time.toDocTime(new Date())+getTransferSequence(), new Date(), carNum, getTransferID(), institution.getCityAndName(institution.getInstitutionID(staffID)), city, container, calcPrice(city), itemIDs);
		return new TransferDoc_PlaneVO((TransferDoc_PlanePO) po);
	}

	@Override
	public TransferDoc_TrainVO createTransferDocVO_Train(String city,
			String carNum, String watcher, String carriage,String[] itemIDs) {
		// TODO 自动生成的方法存根
		po = new TransferDoc_TrainPO(institutionID+Time.toDocTime(new Date())+getTransferSequence(), new Date(), carNum, getTransferID(), institution.getCityAndName(institution.getInstitutionID(staffID)), city, carriage, calcPrice(city), itemIDs);
		return new TransferDoc_TrainVO((TransferDoc_TrainPO) po);
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
	private double calcPrice(String targetCity) {
		return 0;
	}

	@Override
	public TransferDocPO geTransferDocPOByID(String ID) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<TransferDocPO> getUnPaidTransferDocPOs() {
		// TODO Auto-generated method stub
		return null;
	}
}
