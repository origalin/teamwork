package edu.nju.businesslogicservice.approvelogicservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.businesslogic.transferbl.ZLoadDoc;
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

public interface ApproveLogicService {
	
	//��ȡ���൥��
	public ArrayList<SendDocPO> getuncheckedSendDocList() throws RemoteException;
	public ArrayList<GatheringDocPO> getunchekedGatheringDocList();
	public ArrayList<InWareHouseDocPO> getunchekedInWareHouseDocList();
	public ArrayList<OutWareHouseDocPO> getunchekedOutWareHouseDocList();
	public ArrayList<TransferDocPO> getunchekedTransferDocList() throws RemoteException;
	public ArrayList<ZLoadDocPO> getunchekedZLoadDocList() throws RemoteException;
	public ArrayList<OverDocPO> getunchekedOverDocList() throws RemoteException;
	public ArrayList<PayDocPO> getunchekedPayDocList();
	public ArrayList<YArrivalDocPO> getunchekedYArrivalDocList() throws RemoteException;
	public ArrayList<YDeliverDocPO> getunchekedYDeliverDocList() throws RemoteException;
	ArrayList<YLoadDocPO> getunchekedYLoadDocList() throws RemoteException;
	ArrayList<ZArrivalDocPO> getunchekedZArrivalDocList() throws RemoteException;
	//ÿ��������һ���ֺ�Ҫ�޸ĵ��ݵ��Ƿ�����������
	public void setSendDocList(ArrayList<SendDocPO> sendDocList) throws RemoteException;
	public void setGatheringDocList(ArrayList<GatheringDocPO> GatheringDocList);
	public void setInWareHouseDocList(ArrayList<InWareHouseDocPO> InWareHouseDocList);
	public void setOutWareHouseDocList(ArrayList<OutWareHouseDocPO> OutWareHouseDocList);
	public void setTransferDocList(ArrayList<TransferDocPO> TransferDocList) throws RemoteException;
	public void setZLoadDocList(ArrayList<ZLoadDocPO>ZLoadDocList) throws RemoteException;
	public void setOverDocList(ArrayList<OverDocPO> OverDocList);
	public void setPayDocList(ArrayList<PayDocPO> PayDocList);
	public void setYArrivalDocList(ArrayList<YArrivalDocPO> YArrivalDocList) throws RemoteException;
	public void setYDeliverDocList(ArrayList<YDeliverDocPO> YDeliverDocList) throws RemoteException;
	public void setZArrivalDocList(ArrayList<ZArrivalDocPO> ZArrivalDocList) throws RemoteException;
	public void setYLoadDocList(ArrayList<YLoadDocPO>YLoadDocList) throws RemoteException;
	/*
	//�ļ�������
	public SendDocVO getSendDoc(Integer SendDocNumber);
	//�տ����
	public GatheringDocVO getGatheringDoc(Integer GatheringDocNumber);
	//��ⵥ����
	public InWareHouseDocVO getInWareHouseDoc(Integer InWareHouseDocNumber);
	//���ⵥ����
	public OutWareHouseDocVO getOutWareHouseDoc(Integer OutWareHouseDocNumber);
	//��ת������
	public TransferDocVO getTransferDoc(Integer TransferDocNumber);
	//��ת����װ��������
	public ZLoadDocVO getZLoadDoc(Integer ZLoadDocNumber);
	//�ռ�������
	public OverDocVO getOverDoc(Integer OverDocNumber);
	//�������
	public PayDocVO getPayDoc(Integer PayDocNumber);
	//Ӫҵ�����յ�����
	public YArrivalDocVO getYArrival(Integer YArrivalDocNumber);
	//Ӫҵ���ɼ�������
	public YDeliverDocVO geYDeliverDoc(Integer YDeliverDocNumber);
	//Ӫҵ��װ��������
	public YLoadDocVO getYLoadDoc(Integer YLoadDocNumber);
	//��ת���Ľ��յ�����
	public ZArrivalDocVO getZArrivalDoc(Integer ZArrivalDoc);
	*/
	
	
	
}
