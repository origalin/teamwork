package edu.nju.businesslogic.approvebl;

import java.util.ArrayList;

import edu.nju.businesslogic.financebl.financebl;
import edu.nju.businesslogic.transformbl.ZLoadDoc;
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
	financebl fnc;
	
	ArrayList<SendDocPO> uncheckedSendDocList;
	ArrayList<GatheringDocPO> unchekedGatheringDocList;
	ArrayList<InWareHouseDocPO> unchekedInWareHouseDocList;
	ArrayList<OutWareHouseDocPO> unchekedOutWareHouseDocList;
	ArrayList<TransferDocPO> unchekedTransferDocList;
	ArrayList<ZLoadDocPO> unchekedZLoadDocList;
	ArrayList<OverDocPO> unchekedOverDocList;
	ArrayList<PayDocPO> unchekedPayDocList;
	ArrayList<YArrivalDocPO> unchekedYArrivalDocList;
	ArrayList<YDeliverDocPO> unchekedYDeliverDocList;
	ArrayList<YLoadDocPO> unchekedYLoadDocList;
	ArrayList<ZArrivalDocPO> unchekedZArrivalDocList;
	@Override
	public ArrayList<SendDocPO> getuncheckedSendDocList() {
		
		return null;
	}

	@Override
	public ArrayList<GatheringDocPO> getunchekedGatheringDocList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<InWareHouseDocPO> getunchekedInWareHouseDocList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<OutWareHouseDocPO> getunchekedOutWareHouseDocList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<TransferDocPO> getunchekedTransferDocList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ZLoadDocPO> getunchekedZLoadDocList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<OverDocPO> getunchekedOverDocList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<PayDocPO> getunchekedPayDocList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<YArrivalDocPO> getunchekedYArrivalDocList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<YDeliverDocPO> getunchekedYDeliverDocList() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public ArrayList<YLoadDocPO> getunchekedYLoadDocList() {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public ArrayList<ZArrivalDocPO> getunchekedZArrivalDocList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setSendDocList(ArrayList<SendDocPO> sendDocList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setGatheringDocList(ArrayList<GatheringDocPO> GatheringDocList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setInWareHouseDocList(
			ArrayList<InWareHouseDocPO> InWareHouseDocList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setOutWareHouseDocList(
			ArrayList<OutWareHouseDocPO> OutWareHouseDocList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setTransferDocList(ArrayList<TransferDocPO> TransferDocList) {
		// TODO Auto-generated method stub
		
	}

	
	@Override
	public void setOverDocList(ArrayList<OverDocPO> OverDocList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPayDocList(ArrayList<PayDocPO> PayDocList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setYArrivalDocList(ArrayList<YArrivalDocPO> YArrivalDocList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setYDeliverDocList(ArrayList<YDeliverDocPO> YDeliverDocList) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void setZArrivalDocList(ArrayList<ZArrivalDocPO> ZArrivalDocList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setYLoadDocList(ArrayList<YLoadDocPO> YLoadDocList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setZLoadDocList(ArrayList<ZLoadDocPO> ZLoadDocList) {
		// TODO Auto-generated method stub
		
	}

/*
	@Override
	public SendDocVO getSendDoc(Integer SendDocNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GatheringDocVO getGatheringDoc(Integer GatheringDocNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InWareHouseDocVO getInWareHouseDoc(Integer InWareHouseDocNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OutWareHouseDocVO getOutWareHouseDoc(Integer OutWareHouseDocNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TransferDocVO getTransferDoc(Integer TransferDocNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ZLoadDocVO getZLoadDoc(Integer ZLoadDocNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OverDocVO getOverDoc(Integer OverDocNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PayDocVO getPayDoc(Integer PayDocNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public YArrivalDocVO getYArrival(Integer YArrivalDocNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public YDeliverDocVO geYDeliverDoc(Integer YDeliverDocNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public YLoadDocVO getYLoadDoc(Integer YLoadDocNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ZArrivalDocVO getZArrivalDoc(Integer ZArrivalDoc) {
		// TODO Auto-generated method stub
		return null;
	}
*/
}
