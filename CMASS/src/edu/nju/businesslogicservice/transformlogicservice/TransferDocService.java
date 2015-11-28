package edu.nju.businesslogicservice.transformlogicservice;

import java.util.ArrayList;

import edu.nju.po.TransferDocPO;
import edu.nju.presentation.transformui.TransferDocPanel_Car;
import edu.nju.vo.TransferDocVO;
import edu.nju.vo.TransferDoc_CarVO;
import edu.nju.vo.TransferDoc_PlaneVO;
import edu.nju.vo.TransferDoc_TrainVO;

public interface TransferDocService {
	public void saveTransferDocPO(TransferDocPO po);//保存中转单持久化对象
	public String getTransferSequence();//获取中转单基准序列号
	public void changeTransferSequence();//改变基准序列号
	public TransferDoc_CarVO createTransferDocVO_Car(String city,String carNum/*汽运编号*/, String watcher ,String[] itemIDs);//创建汽运中转单VO
	public TransferDoc_PlaneVO createTransferDocVO_Plane(String city,String carNum/*航运编号*/, String watcher,String container,String[] itemIDs);//创建航运中转单VO
	public TransferDoc_TrainVO createTransferDocVO_Train(String city,String carNum/*货运编号*/, String watcher,String carriage,String[] itemIDs);//创建陆运中转单VO
	public TransferDocVO findTransferDocVO (String ID);//获取中转单VO
	public ArrayList<TransferDocPO> getUncheckedTransferDocPOs();
	public double[] getPriceToday();
	public TransferDocPO geTransferDocPOByID(String ID);
}
