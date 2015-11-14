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
	
	//��ȡ���൥��
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
	ArrayList<YLoadDocVO> getunchekedYLoadDocList();
	ArrayList<ZArrivalDocVO> getunchekedZArrivalDocList();
	
	
}
