package edu.nju.businesslogicservice.transformlogicservice;

import java.util.ArrayList;

import edu.nju.po.DeliverDocPO;
import edu.nju.po.TransferDocPO;
import edu.nju.vo.TransferDocVO;

public interface TransferDocService {
	public void saveTransferDocPO(TransferDocPO po);//保存中转单持久化对象
	public int getTransferSequence();//获取中转单基准序列号
	public int[] getSendDocIDList(int id);
	public void changeTransferSequence(int TransferSequence);//改变基准序列号
	public TransferDocVO createTransferDoc_CarVO(int transferCenterID,int carNum/*汽运编号*/,int tranceID/*车次号*/);//创建汽运中转单VO
	public TransferDocVO createTransferDocVO_Plane(int transferCenterID,int carNum/*航运编号*/,int tranceID/*航班号*/,int container);//创建航运中转单VO
	public TransferDocVO createTransferDocVO_Train(int transferCenterID,int carNum/*货运编号*/,int tranceID/*车次号*/,int carriage);//创建陆运中转单VO
	public TransferDocVO findTransferDocVO (int ID);//获取中转单VO
	public ArrayList<TransferDocPO> getUncheckedTransferDocPOs();
	public double[] getPriceToday();
}
