package edu.nju.dataservice.financedataservice;
import edu.nju.po.*;
import edu.nju.tools.*;
import edu.nju.vo.GatheringDocVO;
import edu.nju.vo.PayDocVO;

import java.util.ArrayList;
public interface FinanceDataService{
	public ArrayList<AccountPO> getAccountPO();//�õ�PO��ԭ����Ϊ�˿��Զ��˻���ɾ�Ĳ�
	public ArrayList<PayDocVO> getPayDoc(String startTime, String endTime);
	public ArrayList<GatheringDocVO> getGatheringDoc(String startTime,String endTime); 
	public ArrayList<PayDocVO> getPayDoc();//�޲ε���Ϊ��������֧������Ҫ������ǰ�����и��������
	public ArrayList<GatheringDocVO> getGatheringDoc();//�޲ε���Ϊ������������
}
