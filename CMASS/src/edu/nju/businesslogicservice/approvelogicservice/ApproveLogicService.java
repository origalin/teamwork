package edu.nju.businesslogicservice.approvelogicservice;

import java.util.ArrayList;

import edu.nju.po.GatheringDocPO;
import edu.nju.po.InWareHouseDocPO;
import edu.nju.po.OutWareHouseDocPO;
import edu.nju.po.OverDocPO;
import edu.nju.po.PayDocPO;
import edu.nju.po.SendDocPO;
import edu.nju.po.TransferDocPO;
import edu.nju.po.YArrivalDocPO;
import edu.nju.po.YDeliverDocPO;
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
	public ArrayList<SendDocVO> getuncheckedSendDocList();
	public ArrayList<GatheringDocVO> getunchekedGatheringDocList();
	public ArrayList<InWareHouseDocVO> getunchekedInWareHouseDocList();
	public ArrayList<OutWareHouseDocVO> getunchekedOutWareHouseDocList();
	public ArrayList<TransferDocVO> getunchekedTransferDocList();
	public ArrayList<ZLoadDocVO> getunchekedZLoadDocList();
	public ArrayList<OverDocVO> getunchekedOverDocList();
	public ArrayList<PayDocVO> getunchekedPayDocList();
	public ArrayList<YArrivalDocVO> getunchekedYArrivalDocList();
	public ArrayList<YDeliverDocVO> getunchekedYDeliverDocList();
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
	ArrayList<YLoadDocVO> getunchekedYLoadDocList();
	ArrayList<ZArrivalDocVO> getunchekedZArrivalDocList();
	
	
}
