package edu.nju.data.transferDataServiceImpl;

import java.util.ArrayList;

import edu.nju.dataservice.transformdataservice.TransferDataService;
import edu.nju.po.OverDocPO;
import edu.nju.po.TransferDocPO;
import edu.nju.po.YArrivalDocPO;
import edu.nju.po.YDeliverDocPO;
import edu.nju.po.YLoadDocPO;
import edu.nju.po.ZArrivalDocPO;
import edu.nju.po.ZLoadDocPO;

public class TransferDataServiceImpl implements TransferDataService{
	String institutionID;
	public TransferDataServiceImpl(String institutionID) {
		// TODO Auto-generated constructor stub
		this.institutionID = institutionID;
	}
	@Override
	public void saveTransferDocPO(TransferDocPO po) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getTransferSequence() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void changeTransferSequence(String TransferSequence) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveZLoadDocPO(ZLoadDocPO po) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getZLoadSequence() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void changeZLoadSequence(String ZLoadSequence) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveZArrivalDocPO(ZArrivalDocPO po) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getZArrivalSequence() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void changeZArrivalSequence(String ZArrivalSequence) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveYArrivalDocPO(YArrivalDocPO po) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getYArrivalSequence() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void changeYArrivalSequence(String YArrivalSequence) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveYDeliverDocPO(YDeliverDocPO po) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getYDeliverSequence() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void changeYDeliverSequence(String YDeliverSequence) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveOverDocPO(OverDocPO po) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getOverSequence() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void changeOverSequence(String OverSequence) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TransferDocPO getTransferDocPO(String TransferDocID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ZLoadDocPO getZLoadDocPO(String ZLoadDocID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ZArrivalDocPO getZArrivalDocPO(String ZArrivalDocID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public YArrivalDocPO getYArrivalDocPO(String YArrivalDocID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public YDeliverDocPO getYDeliverDocPO(String YDeliverDocID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OverDocPO getOverDocPO(String OverDocID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<YDeliverDocPO> getAllYDeliverDoc() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<YArrivalDocPO> getAllYArrivalDoc() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ZArrivalDocPO> getAllZArrivalDoc() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<TransferDocPO> getAllTransferDoc() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<YLoadDocPO> getAllYLoadDoc() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ZLoadDocPO> getAllZloadDoc() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<OverDocPO> getAllOverDoc() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTransferID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTransferID_Plain() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTransferID_Train() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void changeTransferID(String transferDocID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changeTransferID_Plain(String transferDocID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changeTransferID_Train(String transferDocID) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public ArrayList<TransferDocPO> getunPaidTransferDocPO() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<YLoadDocPO> getunPaidYLoadDocPO() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<ZLoadDocPO> getunPaidZLoadDocPO() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void saveYLoadDocPO(YLoadDocPO po) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String getYLoadSequence() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void changeYLoadSequence(String ZLoadSequence) {
		// TODO Auto-generated method stub
		
	}

	
}
