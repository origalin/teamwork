package edu.nju.businesslogicservice.collectionlogicservice;

import java.util.ArrayList;
import java.util.List;

import edu.nju.po.*;
import edu.nju.vo.SendDocVO;

public interface CollectionLogicService {
	public void saveSendDocPO(SendDocPO po);//����ļ����־û�����
	public double getDistance(String city);//��ȡ���м����
	public String getSequence();//��ȡ�ļ������л�׼��
	public void changeSequence();//�ı�ļ������л�׼��
	public List<SendDocPO> getAllSendDoc();//��ȡ����δ��������
	public double getCourierMoney(String courierID);//��ȡ���Ա��ȡ�˷�
	public SendDocVO createSendDocVO(String sName,String sCity,String sAddress, String sUnit,String sTelePhone,String sMobilePhone,
			String rName,String rCity,String rAddress,String rUnit,String rTelePhone
			,String rMobilePhone,int itemNum,double weight,double[] volume
			,String itemKind,int packageType,int sendType);//�����ļ���VO
	public int timeEstimate(String sCity,String rCity);//ʱ��Ԥ��
	public double priceCalc(String sCity,String rCity,int packing,double[] volume,double weight,int sendType);//�˷Ѽ���
	public SendDocVO getSendDocVOByID(String itemID);
	public SendDocPO getSendDocPOByID(String itemID);
	public ArrayList<String> getSendDocsByID(String courier_ID);
	public void saveSendDocCreateGatheringDoc(String courierID);
	ArrayList<HistoryTimePO> getHistoryPO(String sCity, String rCity);
}
