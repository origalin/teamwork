package edu.nju.businesslogicservice.collectionlogicservice;

import java.util.List;

import edu.nju.po.*;
import edu.nju.vo.SendDocVO;

public interface CollectionLogicService {
	public void saveSendDocPO(SendDocPO po);//����ļ����־û�����
	public int getDistance(String city);//��ȡ���м����
	public int getSequence();//��ȡ�ļ������л�׼��
	public void changeSequence(int sequence);//�ı�ļ������л�׼��
	public void saveHistory(HistoryPO po);//����ļ�ʱ����ʷ��¼
	public List<PositionPO> QueryGoodsInfo(int SendDocID);//��ȡ�����ʷ�켣
	public List<SendDocPO> getAllSendDoc();//��ȡ����δ��������
	public int getCourierMoney(String courier);//��ȡ���Ա��ȡ�˷�
	public int[] getSendDocIDList(String courier);//��ȡ���Ա�����ļļ������
	public SendDocVO createSendDocVO(String sName,String sAddress,String sUnit,String sPhone,
			String rName,String rAddress,String rUnit,String rPhone
			,int number,double weight,double[] volume
			,String kind,int packing,int type);//�����ļ���VO
	public int timeEstimate(String sCity,String rCity);//ʱ��Ԥ��
	public double priceCalc(String sCity,String rCity,int packing,double[] volume,double weight);//�˷Ѽ���
	public SendDocVO findSendDocVO(int ID);//��ȡ�ļ���VO
	public HistoryPO getHistoryPO(int ID);
}
