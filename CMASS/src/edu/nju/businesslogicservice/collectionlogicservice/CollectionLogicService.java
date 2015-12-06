package edu.nju.businesslogicservice.collectionlogicservice;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import edu.nju.exception.DatabaseNULLException;
import edu.nju.po.*;
import edu.nju.vo.SendDocVO;

public interface CollectionLogicService {
	public void saveSendDocPO(SendDocPO po) throws RemoteException;//����ļ����־û�����
	public double getDistance(String city);//��ȡ���м����
	public String getSequence() throws RemoteException;//��ȡ�ļ������л�׼��
	public void changeSequence() throws RemoteException;//�ı�ļ������л�׼��
	public List<SendDocPO> getAllSendDoc() throws RemoteException;//��ȡ����δ��������
	public double getCourierMoney(String courierID) throws RemoteException;//��ȡ���Ա��ȡ�˷�
	public SendDocVO createSendDocVO(String sName,String sCity,String sAddress, String sUnit,String sTelePhone,String sMobilePhone,
			String rName,String rCity,String rAddress,String rUnit,String rTelePhone
			,String rMobilePhone,int itemNum,double weight,double[] volume
			,String itemKind,int packageType,int sendType) throws RemoteException;//�����ļ���VO
	public int timeEstimate(String sCity,String rCity) throws RemoteException;//ʱ��Ԥ��
	public double priceCalc(String sCity,String rCity,int packing,double[] volume,double weight,int sendType);//�˷Ѽ���
	public SendDocVO getSendDocVOByID(String itemID) throws RemoteException, DatabaseNULLException;
	public SendDocPO getSendDocPOByID(String itemID) throws RemoteException, DatabaseNULLException;
	public ArrayList<String> getSendDocsByID(String courier_ID) throws RemoteException;
	public void saveSendDocCreateGatheringDoc(String courierID) throws RemoteException;
	ArrayList<HistoryTimePO> getHistoryPO(String sCity, String rCity) throws RemoteException;
	public void  confirmSave() throws RemoteException;
}
