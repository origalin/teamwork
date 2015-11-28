package edu.nju.businesslogic.transformbl;

import java.util.ArrayList;
import java.util.Date;

import edu.nju.businesslogic.infobl.Institution;
import edu.nju.businesslogicservice.transformlogicservice.YDeliverDocService;
import edu.nju.data.transferDataServiceImpl.TransferDataServiceImpl;
import edu.nju.dataservice.transformdataservice.TransferDataService;
import edu.nju.po.YDeliverDocPO;
import edu.nju.tools.SequenceCalc;
import edu.nju.vo.YDeliverDocVO;

public class YDeliverDoc implements YDeliverDocService{
	String institutionID,  staffID;
	private YDeliverDocPO po;
	private Institution institution;
	private TransferDataService transferDataService;

	public YDeliverDoc(String staffID) {
		// TODO �Զ����ɵĹ��캯�����
		this.staffID = staffID;
		institution = new Institution();
		this.institutionID = institution.getInstitutionID(staffID);
		transferDataService = new TransferDataServiceImpl(institutionID);
	}

	public YDeliverDoc() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void saveYDeliverDocPO(YDeliverDocPO po) {
		// TODO �Զ����ɵķ������
		transferDataService.saveYDeliverDocPO(po);
		changeYDeliverDocSequence();
	}

	@Override
	public String getYDeliverSequence() {
		// TODO �Զ����ɵķ������
		return transferDataService.getYDeliverSequence();
	}

	@Override
	public void changeYDeliverDocSequence() {
		// TODO �Զ����ɵķ������
		String next = SequenceCalc.calcNextSequence6(getYDeliverSequence());
		transferDataService.changeYDeliverSequence(next);
	}

	@Override
	public void createYDeliverDoc(String[][] IDAndCourier) {
		// TODO �Զ����ɵķ������
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
			po = new YDeliverDocPO("10"+getYDeliverSequence(), new Date(), staffID, itemIDs);
			saveYDeliverDocPO(po);
			changeYDeliverDocSequence();
		}
	}

	@Override
	public ArrayList<YDeliverDocVO> findYDeliverDocVOs(String courierID) {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public ArrayList<YDeliverDocPO> getUncheckedDeliverDocPOs() {
		// TODO �Զ����ɵķ������
		return transferDataService.getAllYDeliverDoc();
	}

	@Override
	public YDeliverDocPO getDeliverDocPOsByID(String YDeliverID) {
		// TODO �Զ����ɵķ������
		return transferDataService.getYDeliverDocPO(YDeliverID, true);
	}

	public YDeliverDocVO getDeliverDocVOsByID(String YDeliverDocID) {
		// TODO Auto-generated method stub
		return new YDeliverDocVO(transferDataService.getYDeliverDocPO(YDeliverDocID, false));
	}	

	

}
