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
	public int[] getSendDocIDList(int id);
	public void changeTransferSequence(int TransferSequence);//�ı��׼���к�
	public TransferDoc_CarVO createTransferDocVO_Car(String city,String carNum/*���˱��*/,String tranceID/*���κ�*/, String watcher ,String[] itemIDs);//����������ת��VO
	public TransferDoc_PlaneVO createTransferDocVO_Plane(String city,String carNum/*���˱��*/,String tranceID/*�����*/, String watcher,int container,String[] itemIDs);//����������ת��VO
	public TransferDoc_TrainVO createTransferDocVO_Train(String city,String carNum/*���˱��*/,String tranceID/*���κ�*/, String watcher,int carriage,String[] itemIDs);//����½����ת��VO
	public TransferDocVO findTransferDocVO (int ID);//��ȡ��ת��VO
	public ArrayList<TransferDocPO> getUncheckedTransferDocPOs();
	public double[] getPriceToday();
}
