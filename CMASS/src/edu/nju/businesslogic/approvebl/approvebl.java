package edu.nju.businesslogic.approvebl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.businesslogic.collectionbl.Collectionbl;
import edu.nju.businesslogic.financebl.financebl;
import edu.nju.businesslogic.storagebl.StorageTools;
import edu.nju.businesslogic.transferbl.OverDoc;
import edu.nju.businesslogic.transferbl.TransferDoc;
import edu.nju.businesslogic.transferbl.YArrivalDoc;
import edu.nju.businesslogic.transferbl.YDeliverDoc;
import edu.nju.businesslogic.transferbl.YLoadDoc;
import edu.nju.businesslogic.transferbl.ZArrivalDoc;
import edu.nju.businesslogic.transferbl.ZLoadDoc;
import edu.nju.businesslogicservice.approvelogicservice.ApproveLogicService;
import edu.nju.po.GatheringDocPO;
import edu.nju.po.InWareHouseDocPO;
import edu.nju.po.OutWareHouseDocPO;
import edu.nju.po.OverDocPO;
import edu.nju.po.PayDocPO;
import edu.nju.po.SendDocPO;
import edu.nju.po.TransferDocPO;
import edu.nju.po.YArrivalDocPO;
import edu.nju.po.YDeliverDocPO;
import edu.nju.po.YLoadDocPO;
import edu.nju.po.ZArrivalDocPO;
import edu.nju.po.ZLoadDocPO;

public class approvebl implements ApproveLogicService{
	/*
	 所有负责有单据的类的逻辑层都要帮我实现下面格式的方法
	 ...代表单据的名称
	 ArrayList<...PO> getunchecked...List();显示所有未审批的...类型单据PO对象的列表，
	 需要PO对象的原因是我需要修改单据是否被审批的状态
	 
	 public void save...PO(... PO);//提供保存所有单据的功能，我要修改单据的审批状态需要用到该方法
	 public void saveOverDocPO(OverDocPO po);//保存收件单持久化对象
	 collectionbl：
	 financebl
	 infobl
	 logispicsquerybl
	 storagebl
	 systembl
	 transformbl
	 utilitybl
	 */
	

	Collectionbl collectionbl;
	financebl fnc;
	StorageTools storageTools=new StorageTools();
	TransferDoc transfer;
	ZLoadDoc ZLoad;
	OverDoc over=new OverDoc();
	YArrivalDoc YArrival=new YArrivalDoc();
	YDeliverDoc YDeliver=new YDeliverDoc();
	YLoadDoc YLoad;
	ZArrivalDoc ZArrival;
	
	public approvebl() throws RemoteException{
		collectionbl=new Collectionbl();
		fnc=new financebl();
		ZLoad=new ZLoadDoc();
		YLoad=new YLoadDoc();
		transfer=new TransferDoc();
		ZArrival=new ZArrivalDoc();
	}
	@Override
	public ArrayList<SendDocPO> getuncheckedSendDocList() throws RemoteException {
		return collectionbl.getAllSendDoc();
	}

	@Override
	public ArrayList<GatheringDocPO> getunchekedGatheringDocList() {
		return fnc.getunchekedGatheringDocList();
	}

	@Override
	public ArrayList<InWareHouseDocPO> getunchekedInWareHouseDocList() {
		// TODO Auto-generated method stub
		try {
			return storageTools.getInWareHouseDocList();
		} catch (RemoteException e) {
			System.out.println("与张健协作出错");
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ArrayList<OutWareHouseDocPO> getunchekedOutWareHouseDocList() {
		// TODO Auto-generated method stub
		try {
			return storageTools.getOutWareHouseDocList();
		} catch (RemoteException e) {
			System.out.println("与张健协作出错");
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ArrayList<TransferDocPO> getunchekedTransferDocList() throws RemoteException {
		// TODO Auto-generated method stub
		return transfer.getUncheckedTransferDocPOs();
	}

	@Override
	public ArrayList<ZLoadDocPO> getunchekedZLoadDocList() throws RemoteException {
		// TODO Auto-generated method stub
		return ZLoad.getUncheckedZLoadDocPOs();
	}

	@Override
	public ArrayList<OverDocPO> getunchekedOverDocList() throws RemoteException {
		// TODO Auto-generated method stub
		return over.getUncheckedOverDocPOs();
	}

	@Override
	public ArrayList<PayDocPO> getunchekedPayDocList() {
		// TODO Auto-generated method stub
		return fnc.getunchekedPayDocList();
	}

	@Override
	public ArrayList<YArrivalDocPO> getunchekedYArrivalDocList() throws RemoteException {
		// TODO Auto-generated method stub
		return YArrival.getUncheckedYaArrivalDocPOs();
	}

	@Override
	public ArrayList<YDeliverDocPO> getunchekedYDeliverDocList() throws RemoteException {
		// TODO Auto-generated method stub
		return YDeliver.getUncheckedDeliverDocPOs();
	}
	
	@Override
	public ArrayList<YLoadDocPO> getunchekedYLoadDocList() throws RemoteException {
		// TODO Auto-generated method stub
		return YLoad.getUncheckedyLoadDocPOs();
	}

	
	@Override
	public ArrayList<ZArrivalDocPO> getunchekedZArrivalDocList() throws RemoteException {
		// TODO Auto-generated method stub
		return ZArrival.getUncheckedZArrivalDocPOs();
	}

	@Override
	public void setSendDocList(ArrayList<SendDocPO> sendDocList) throws RemoteException {
		// TODO Auto-generated method stub
		for(SendDocPO po:sendDocList){
		collectionbl.saveSendDocPO(po);
		}
	}

	@Override
	public void setGatheringDocList(ArrayList<GatheringDocPO> GatheringDocList) {
		// TODO Auto-generated method stub
		for(GatheringDocPO po:GatheringDocList){
			fnc.saveGatheringDocPO(po);
		}
	}

	@Override
	public void setInWareHouseDocList(
			ArrayList<InWareHouseDocPO> InWareHouseDocList) {
		// TODO Auto-generated method stub
		for(InWareHouseDocPO po:InWareHouseDocList){
			try {
				storageTools.saveInWareHouseDocPO(po);
			} catch (RemoteException e) {
				System.out.println("与张健协作出错");
				e.printStackTrace();
			}
		}
	}

	@Override
	public void setOutWareHouseDocList(
			ArrayList<OutWareHouseDocPO> OutWareHouseDocList) {
		for(OutWareHouseDocPO po:OutWareHouseDocList){
			try {
				storageTools.saveOutWareHouseDocPO(po);
			} catch (RemoteException e) {
				System.out.println("与张健协作出错");
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void setTransferDocList(ArrayList<TransferDocPO> TransferDocList) throws RemoteException {
		// TODO Auto-generated method stub
		for(TransferDocPO po:TransferDocList){
			transfer.saveTransferDocPO(po);
		}
	}

	
	@Override
	public void setOverDocList(ArrayList<OverDocPO> OverDocList) {
		// TODO Auto-generated method stub
		for(OverDocPO po:OverDocList){
			over.saveOverDocPO(po);
		}
	}

	@Override
	public void setPayDocList(ArrayList<PayDocPO> PayDocList) {
		// TODO Auto-generated method stub
		for(PayDocPO po:PayDocList){
			fnc.savePayDocPO(po);
		}
	}

	@Override
	public void setYArrivalDocList(ArrayList<YArrivalDocPO> YArrivalDocList) throws RemoteException {
		// TODO Auto-generated method stub
		for(YArrivalDocPO po:YArrivalDocList){
			YArrival.saveYArrivalDocPO(po);
		}
	}

	@Override
	public void setYDeliverDocList(ArrayList<YDeliverDocPO> YDeliverDocList) throws RemoteException {
		// TODO Auto-generated method stub
		for(YDeliverDocPO po:YDeliverDocList){
			YDeliver.saveYDeliverDocPO(po);
		}
	}


	@Override
	public void setZArrivalDocList(ArrayList<ZArrivalDocPO> ZArrivalDocList) throws RemoteException {
		// TODO Auto-generated method stub
		for(ZArrivalDocPO po:ZArrivalDocList){
			ZArrival.saveZArrivalDocPO(po);
		}
	}

	@Override
	public void setYLoadDocList(ArrayList<YLoadDocPO> YLoadDocList) throws RemoteException {
		// TODO Auto-generated method stub
		for(YLoadDocPO po:YLoadDocList){
			YLoad.saveYloadDocPO(po);
		}
	}

	@Override
	public void setZLoadDocList(ArrayList<ZLoadDocPO> ZLoadDocList) throws RemoteException {
		// TODO Auto-generated method stub
		for(ZLoadDocPO po:ZLoadDocList){
			ZLoad.saveZloadDocPO(po);
		}
	}


}
