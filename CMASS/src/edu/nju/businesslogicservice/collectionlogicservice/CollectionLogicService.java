package edu.nju.businesslogicservice.collectionlogicservice;

import java.util.ArrayList;
import java.util.List;

import edu.nju.po.*;
import edu.nju.vo.SendDocVO;

public interface CollectionLogicService {
	public void saveSendDocPO(SendDocPO po);//保存寄件单持久化对象
	public int getDistance(String city);//获取城市间距离
	public int getSequence();//获取寄件单序列基准号
	public void changeSequence(int sequence);//改变寄件单序列基准号
	public void saveHistory(HistoryTimePO po);//保存寄件时间历史记录
	public PositionPO QueryGoodsInfo(int SendDocID);//获取快件历史轨迹
	public List<SendDocPO> getAllSendDoc();//获取所有未审批单据
	public int getCourierMoney(String courier);//获取快递员收取运费
	public int[] getSendDocIDList(String courier);//获取快递员创建的寄件单编号
	public SendDocVO createSendDocVO(String sName,String sAddress,String sUnit,String sPhone,
			String rName,String rAddress,String rUnit,String rPhone
			,int number,double weight,double[] volume
			,String kind,int packing,int type);//创建寄件单VO
	public int timeEstimate(String sCity,String rCity);//时间预估
	public double priceCalc(String sCity,String rCity,int packing,double[] volume,double weight);//运费计算
	public SendDocVO findSendDocVO(int ID);//获取寄件单VO
	public HistoryTimePO getHistoryPO(int ID);
	public ArrayList<SendDocPO> getUncheckedSendDocPOs();
}
