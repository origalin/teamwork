package edu.nju.businesslogic.transformbl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import edu.nju.businesslogic.infobl.Institution;
import edu.nju.businesslogic.logispicsquerybl.Logisticsquerybl;
import edu.nju.businesslogic.systembl.SystemBl;
import edu.nju.businesslogicservice.transformlogicservice.YDeliverDocService;
import edu.nju.data.transferDataServiceImpl.TransferDataServiceImpl;
import edu.nju.dataFactory.DataFactory;
import edu.nju.dataservice.transformdataservice.TransferDataService;
import edu.nju.po.OperationPO;
import edu.nju.po.YDeliverDocPO;
import edu.nju.tools.SequenceCalc;
import edu.nju.vo.YDeliverDocVO;

public class YDeliverDoc implements YDeliverDocService{
	String institutionID,  staffID;
	private ArrayList<YDeliverDocPO> pos;
	private Institution institution;
	private TransferDataService transferDataService;
	Logisticsquerybl logisticsquerybl;
	SystemBl systemBl ;

	public YDeliverDoc(String staffID) throws RemoteException {
		// TODO 自动生成的构造函数存根
		this.staffID = staffID;
		institution = new Institution();
		this.institutionID = institution.getInstitutionID(staffID);
		transferDataService = DataFactory.getTransferDataService();
		transferDataService.setInstitutionID(institutionID);
		logisticsquerybl = new Logisticsquerybl();
		systemBl = new SystemBl();
	}

	public YDeliverDoc() {
		// TODO Auto-generated constructor stub
	}
	public void confirmSave() throws RemoteException {
		for(YDeliverDocPO po : pos) {
			saveYDeliverDocPO(po);
			changeYDeliverDocSequence();
			for(int i = 0;i< po.getItemIDs().length;i++) {
				logisticsquerybl.changePosition(po.getItemIDs()[i], "派件中，快递员为"+institution.getStaffName(po.getCourier()));
			}
		}
		systemBl.saveOperation(new OperationPO(new Date(), staffID, institution.getStaffName(staffID), "生成派件单"));
		
	}
	@Override
	public void saveYDeliverDocPO(YDeliverDocPO po) throws RemoteException {
		// TODO 自动生成的方法存根
		transferDataService.saveYDeliverDocPO(po);
	}

	@Override
	public String getYDeliverSequence() throws RemoteException {
		// TODO 自动生成的方法存根
		return transferDataService.getYDeliverSequence();
	}

	@Override
	public void changeYDeliverDocSequence() throws RemoteException {
		// TODO 自动生成的方法存根
		String next = SequenceCalc.calcNextSequence6(getYDeliverSequence());
		transferDataService.changeYDeliverSequence(next);
	}

	@Override
	public YDeliverDocVO createYDeliverDoc(String[][] IDAndCourier) throws RemoteException {
		// TODO 自动生成的方法存根
		ArrayList<String> couriers = new ArrayList<String>();
		for(int i = 0;i<IDAndCourier.length;i++) {
			if(!couriers.contains(IDAndCourier[i][1])) {
				couriers.add(IDAndCourier[i][1]);
			}
		}
		for(int i = 0;i<couriers.size();i++) {
			ArrayList<String> item = new ArrayList<String>();
			for(int j = 0;j<IDAndCourier.length;j++) {
				if(IDAndCourier[i][1].equals(couriers.get(i))) {
					item.add(IDAndCourier[i][0]);
				}
			}
			String[] itemIDs = (String[]) item.toArray();
			pos.add(new YDeliverDocPO("10"+getYDeliverSequence(), new Date(), staffID, itemIDs));
			return null;
		}
		return null;
	}

	@Override
	public ArrayList<YDeliverDocVO> findYDeliverDocVOs(String courierID) throws RemoteException {
		// TODO 自动生成的方法存根
		ArrayList<YDeliverDocPO> yDeliverDocPOs = transferDataService.getYDeliverDocPOByCourier(courierID);
		ArrayList<YDeliverDocVO> yDeliverDocVOs = new ArrayList<>();
		for(YDeliverDocPO po:yDeliverDocPOs) {
			yDeliverDocVOs.add(new YDeliverDocVO(po));
		}
		return yDeliverDocVOs;
	}

	@Override
	public ArrayList<YDeliverDocPO> getUncheckedDeliverDocPOs() throws RemoteException {
		// TODO 自动生成的方法存根
		return transferDataService.getAllYDeliverDoc();
	}

	@Override
	public YDeliverDocPO getDeliverDocPOsByID(String YDeliverID) throws RemoteException {
		// TODO 自动生成的方法存根
		return transferDataService.getYDeliverDocPO(YDeliverID, true);
	}

	public YDeliverDocVO getDeliverDocVOsByID(String YDeliverDocID) throws RemoteException {
		// TODO Auto-generated method stub
		return new YDeliverDocVO(transferDataService.getYDeliverDocPO(YDeliverDocID, false));
	}	

	

}
