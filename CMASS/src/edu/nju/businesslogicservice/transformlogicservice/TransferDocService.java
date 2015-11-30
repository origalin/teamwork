package edu.nju.businesslogicservice.transformlogicservice;

import java.util.ArrayList;

import edu.nju.po.TransferDocPO;
import edu.nju.presentation.transformui.TransferDocPanel_Car;
import edu.nju.vo.TransferDocVO;
import edu.nju.vo.TransferDoc_CarVO;
import edu.nju.vo.TransferDoc_PlaneVO;
import edu.nju.vo.TransferDoc_TrainVO;

public interface TransferDocService {
	public void saveTransferDocPO(TransferDocPO po);//������ת���־û�����
	public String getTransferSequence();//��ȡ��ת����׼���к�
	public void changeTransferSequence();//�ı��׼���к�
	public TransferDoc_CarVO createTransferDocVO_Car(String city,String carNum/*���˱��*/, String watcher ,String[] itemIDs);//����������ת��VO
	public TransferDoc_PlaneVO createTransferDocVO_Plane(String city,String carNum/*���˱��*/, String watcher,String container,String[] itemIDs);//����������ת��VO
	public TransferDoc_TrainVO createTransferDocVO_Train(String city,String carNum/*���˱��*/, String watcher,String carriage,String[] itemIDs);//����½����ת��VO
	public TransferDocVO findTransferDocVO (String ID);//��ȡ��ת��VO
	public ArrayList<TransferDocPO> getUncheckedTransferDocPOs();
	public double[] getPriceToday();
	public TransferDocPO geTransferDocPOByID(String ID);
	public void  confirmSave();
}
