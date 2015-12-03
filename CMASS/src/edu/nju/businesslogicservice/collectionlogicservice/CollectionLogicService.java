package edu.nju.businesslogicservice.collectionlogicservice;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import edu.nju.po.*;
import edu.nju.vo.SendDocVO;

public interface CollectionLogicService {
	public void saveSendDocPO(SendDocPO po) throws RemoteException;//保存寄件单持久化对象
	public double getDistance(String city);//获取城市间距离
	public String getSequence() throws RemoteException;//获取寄件单序列基准号
	public void changeSequence() throws RemoteException;//改变寄件单序列基准号
	public List<SendDocPO> getAllSendDoc() throws RemoteException;//获取所有未审批单据
	public double getCourierMoney(String courierID) throws RemoteException;//获取快递员收取运费
	public SendDocVO createSendDocVO(String sName,String sCity,String sAddress, String sUnit,String sTelePhone,String sMobilePhone,
			String rName,String rCity,String rAddress,String rUnit,String rTelePhone
			,String rMobilePhone,int itemNum,double weight,double[] volume
			,String itemKind,int packageType,int sendType) throws RemoteException;//创建寄件单VO
	public int timeEstimate(String sCity,String rCity) throws RemoteException;//时间预估
	public double priceCalc(String sCity,String rCity,int packing,double[] volume,double weight,int sendType);//运费计算
	public SendDocVO getSendDocVOByID(String itemID) throws RemoteException;
	public SendDocPO getSendDocPOByID(String itemID) throws RemoteException;
	public ArrayList<String> getSendDocsByID(String courier_ID) throws RemoteException;
	public void saveSendDocCreateGatheringDoc(String courierID) throws RemoteException;
	ArrayList<HistoryTimePO> getHistoryPO(String sCity, String rCity) throws RemoteException;
	public void  confirmSave() throws RemoteException;
}
