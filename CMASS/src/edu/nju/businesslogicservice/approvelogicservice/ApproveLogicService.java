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
	
	//获取各类单据
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
	//每次审批完一部分后要修改单据的是否被审批的属性
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
	//寄件单部分
	public SendDocVO getSendDoc(Integer SendDocNumber);
	//收款单部分
	public GatheringDocVO getGatheringDoc(Integer GatheringDocNumber);
	//入库单部分
	public InWareHouseDocVO getInWareHouseDoc(Integer InWareHouseDocNumber);
	//出库单部分
	public OutWareHouseDocVO getOutWareHouseDoc(Integer OutWareHouseDocNumber);
	//中转单部分
	public TransferDocVO getTransferDoc(Integer TransferDocNumber);
	//中转中心装车单部分
	public ZLoadDocVO getZLoadDoc(Integer ZLoadDocNumber);
	//收件单部分
	public OverDocVO getOverDoc(Integer OverDocNumber);
	//付款单部分
	public PayDocVO getPayDoc(Integer PayDocNumber);
	//营业厅接收单部分
	public YArrivalDocVO getYArrival(Integer YArrivalDocNumber);
	//营业厅派件单部分
	public YDeliverDocVO geYDeliverDoc(Integer YDeliverDocNumber);
	//营业厅装车单部分
	public YLoadDocVO getYLoadDoc(Integer YLoadDocNumber);
	//中转中心接收单部分
	public ZArrivalDocVO getZArrivalDoc(Integer ZArrivalDoc);
	*/
	
	
	
}
