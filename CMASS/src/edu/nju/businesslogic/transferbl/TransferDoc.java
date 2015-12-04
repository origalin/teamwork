package edu.nju.businesslogic.transferbl;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.TooManyListenersException;

import javax.tools.Tool;

import edu.nju.businesslogic.infobl.Distance;
import edu.nju.businesslogic.infobl.Institution;
import edu.nju.businesslogic.logispicsquerybl.Logisticsquerybl;
import edu.nju.businesslogic.systembl.SystemBl;
import edu.nju.businesslogicservice.transformlogicservice.*;
import edu.nju.data.transferDataServiceImpl.TransferDataServiceImpl;
import edu.nju.dataFactory.DataFactory;
import edu.nju.dataservice.transferdataservice.TransferDataService;
import edu.nju.po.OperationPO;
import edu.nju.po.TransferDocPO;
import edu.nju.po.TransferDoc_CarPO;
import edu.nju.po.TransferDoc_PlanePO;
import edu.nju.po.TransferDoc_TrainPO;
import edu.nju.tools.SequenceCalc;
import edu.nju.tools.Time;
import edu.nju.vo.TransferDocVO;
import edu.nju.vo.TransferDoc_CarVO;
import edu.nju.vo.TransferDoc_PlaneVO;
import edu.nju.vo.TransferDoc_TrainVO;

public class TransferDoc implements TransferDocService{
	String institutionID,staffID;
	TransferDocPO po;
	Institution institution;
	Distance distance;
	TransferDataService transferDataService ;
	Logisticsquerybl logisticsquerybl;
	SystemBl systemBl;
	public TransferDoc () throws RemoteException{
		this( null);
	}

	public TransferDoc(String staffID) throws RemoteException {
		super();
		this.staffID = staffID;
		institution = new Institution();
		distance = new Distance();
		this.institutionID = institution.getInstitutionID(staffID);
		transferDataService = DataFactory.getTransferDataService();
		transferDataService.setInstitutionID(institutionID);
		logisticsquerybl = new Logisticsquerybl();
		systemBl = new SystemBl();
	}
	
	public void  confirmSave() throws RemoteException {
		saveTransferDocPO(po);
		changeTransferSequence();
		changeTransferID();
		String[] itemIDs = po.getItemIDs();
		for(String itemID : itemIDs) {
			logisticsquerybl.changePosition(itemID, "快件已由"+institution.getCity(institutionID)+institution.getInstitutionName(institutionID)+"送出，目的地"+po.getTargetCity());
		}
		systemBl.saveOperation(new OperationPO(new Date(), staffID, institution.getStaffName(staffID), "生成中转单"));

	}
	public void  confirmsave_Train() throws RemoteException {
		saveTransferDocPO(po);
		changeTransferSequence();
		changeTransferID_Train();
		String[] itemIDs = po.getItemIDs();
		for(String itemID : itemIDs) {
			logisticsquerybl.changePosition(itemID, "快件已由"+institution.getCity(institutionID)+institution.getInstitutionName(institutionID)+"送出，目的地"+po.getTargetCity());
		}
		systemBl.saveOperation(new OperationPO(new Date(), staffID, institution.getStaffName(staffID), "生成中转单"));
	}
	public void  confirmsave_Plane() throws RemoteException {
		saveTransferDocPO(po);
		changeTransferSequence();
		changeTransferID_Plain();
		String[] itemIDs = po.getItemIDs();
		for(String itemID : itemIDs) {
			logisticsquerybl.changePosition(itemID, "快件已由"+institution.getCity(institutionID)+institution.getInstitutionName(institutionID)+"送出，目的地"+po.getTargetCity());
		}
		systemBl.saveOperation(new OperationPO(new Date(), staffID, institution.getStaffName(staffID), "生成中转单"));
	}
	@Override
	public void saveTransferDocPO(TransferDocPO po) throws RemoteException {
		// TODO 自动生成的方法存根
		transferDataService.saveTransferDocPO(po);
	
		
	}

	@Override
	public String getTransferSequence() throws RemoteException {
		// TODO 自动生成的方法存根
		return transferDataService.getTransferSequence();
	}
	public String getTransferID() throws RemoteException {
		return transferDataService.getTransferID();
		
	}
	public String getTransferID_Plain() throws RemoteException {
		return transferDataService.getTransferID_Plain();
		
	}
	public String getTransferID_Train() throws RemoteException {
		return transferDataService.getTransferID_Train();
		
	}
	public void changeTransferID() throws RemoteException {
		String next = SequenceCalc.calcNextSequence6(getTransferID());
		transferDataService.changeTransferID(next);
	}
	public void changeTransferID_Plain() throws RemoteException {
		String next = SequenceCalc.calcNextSequence6(getTransferID_Plain());
		transferDataService.changeTransferID_Plain(next);
	}
	public void changeTransferID_Train() throws RemoteException {
		String next = SequenceCalc.calcNextSequence6(getTransferID_Train());
		transferDataService.changeTransferID_Train(next);
	}


	@Override
	public void changeTransferSequence() throws RemoteException {
		// TODO 自动生成的方法存根
		String next = SequenceCalc.calcNextSequence7(getTransferSequence());
		transferDataService.changeTransferSequence(next);
	}

	@Override
	public TransferDoc_CarVO createTransferDocVO_Car(String city,
			String carNum, String watcher,String[] itemIDs) throws RemoteException {
		// TODO 自动生成的方法存根
		po = new TransferDoc_CarPO(institutionID+Time.toDocTime(new Date())+getTransferSequence(), new Date(), carNum, getTransferID(), institution.getCity(institutionID), city, calcPrice_car(city), itemIDs);
		return new TransferDoc_CarVO((TransferDoc_CarPO) po);
	}

	@Override
	public TransferDoc_PlaneVO createTransferDocVO_Plane(String city,
			String carNum, String watcher, String container,String[] itemIDs) throws RemoteException {
		// TODO 自动生成的方法存根
		po = new TransferDoc_PlanePO(institutionID+Time.toDocTime(new Date())+getTransferSequence(), new Date(), carNum, getTransferID(),institution.getCity(institutionID), city, container, calcPrice_plain(city), itemIDs);
		return new TransferDoc_PlaneVO((TransferDoc_PlanePO) po);
	}

	@Override
	public TransferDoc_TrainVO createTransferDocVO_Train(String city,
			String carNum, String watcher, String carriage,String[] itemIDs) throws RemoteException {
		// TODO 自动生成的方法存根
		po = new TransferDoc_TrainPO(institutionID+Time.toDocTime(new Date())+getTransferSequence(), new Date(), carNum, getTransferID(), institution.getCity(institutionID), city, carriage, calcPrice_train(city), itemIDs);
		return new TransferDoc_TrainVO((TransferDoc_TrainPO) po);
	}

	@Override
	public TransferDocVO findTransferDocVO(String ID) throws RemoteException {
		// TODO 自动生成的方法存根
		return new TransferDocVO(transferDataService.getTransferDocPO(ID, false));
	}

	@Override
	public ArrayList<TransferDocPO> getUncheckedTransferDocPOs() throws RemoteException {
		// TODO 自动生成的方法存根
		return transferDataService.getAllTransferDoc();
	}

	@Override
	public double[] getPriceToday() {
		// TODO 自动生成的方法存根
		return null;
	}
	private double calcPrice_car(String targetCity) {
		double distance = this.distance.getDistance(institution.getCity(institutionID),targetCity);
		return distance*20;
		
	}
	private double calcPrice_plain(String targetCity) {
		double distance = this.distance.getDistance(institution.getCity(institutionID),targetCity);
		return distance*1000;
	}
	private double calcPrice_train(String targetCity) {
		double distance = this.distance.getDistance(institution.getCity(institutionID),targetCity);
		return distance*400;
	}

	@Override
	public TransferDocPO geTransferDocPOByID(String ID) throws RemoteException {
		// TODO Auto-generated method stub
		return transferDataService.getTransferDocPO(ID,true);
	}

	public ArrayList<TransferDocPO> getUnPaidTransferDocPOs() throws RemoteException {
		// TODO Auto-generated method stub
		return transferDataService.getunPaidTransferDocPO();
	}
}
