package edu.nju.businesslogic.approvebl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.businesslogic.collectionbl.Collectionbl;
import edu.nju.businesslogic.financebl.financebl;
import edu.nju.businesslogic.storagebl.InWareHouseManagementbl;
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
import edu.nju.vo.GatheringDocVO;
import edu.nju.vo.InWareHouseDocVO;
import edu.nju.vo.OutWareHouseDocVO;
import edu.nju.vo.OverDocVO;
import edu.nju.vo.PayDocVO;
import edu.nju.vo.SendDocVO;
import edu.nju.vo.TransferDocVO;
import edu.nju.vo.YArrivalDocVO;
import edu.nju.vo.YDeliverDocVO;
import edu.nju.vo.YLoadDocVO;
import edu.nju.vo.ZArrivalDocVO;
import edu.nju.vo.ZLoadDocVO;

public class approvebl implements ApproveLogicService{
	/*
	 ���и����е��ݵ�����߼��㶼Ҫ����ʵ�������ʽ�ķ���
	 ...�����ݵ�����
	 ArrayList<...PO> getunchecked...List();��ʾ����δ������...���͵���PO������б�
	 ��ҪPO�����ԭ��������Ҫ�޸ĵ����Ƿ�������״̬
	 
	 public void save...PO(... PO);//�ṩ�������е��ݵĹ��ܣ���Ҫ�޸ĵ��ݵ�����״̬��Ҫ�õ��÷���
	 public void saveOverDocPO(OverDocPO po);//�����ռ����־û�����
	 collectionbl��
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
	StorageTools storageTools;
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
		return storageTools.getInWareHouseDocList();
	}

	@Override
	public ArrayList<OutWareHouseDocPO> getunchekedOutWareHouseDocList() {
		// TODO Auto-generated method stub
		return storageTools.getOutWareHouseDocList();
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
			storageTools.saveInWareHouseDocPO(po);
		}
	}

	@Override
	public void setOutWareHouseDocList(
			ArrayList<OutWareHouseDocPO> OutWareHouseDocList) {
		for(OutWareHouseDocPO po:OutWareHouseDocList){
			storageTools.saveOutWareHouseDocPO(po);
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
