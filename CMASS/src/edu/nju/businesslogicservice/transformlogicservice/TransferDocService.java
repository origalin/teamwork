package edu.nju.businesslogicservice.transformlogicservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.exception.DatabaseNULLException;
import edu.nju.po.TransferDocPO;

import edu.nju.vo.TransferDocVO;
import edu.nju.vo.TransferDoc_CarVO;
import edu.nju.vo.TransferDoc_PlaneVO;
import edu.nju.vo.TransferDoc_TrainVO;

public interface TransferDocService {
	public void saveTransferDocPO(TransferDocPO po) throws RemoteException;//������ת���־û�����
	public String getTransferSequence() throws RemoteException;//��ȡ��ת����׼���к�
	public void changeTransferSequence() throws RemoteException;//�ı��׼���к�
	public TransferDoc_CarVO createTransferDocVO_Car(String city,String carNum/*���˱��*/, String watcher ,String[] itemIDs) throws RemoteException;//����������ת��VO
	public TransferDoc_PlaneVO createTransferDocVO_Plane(String city,String carNum/*���˱��*/, String watcher,String container,String[] itemIDs) throws RemoteException;//����������ת��VO
	public TransferDoc_TrainVO createTransferDocVO_Train(String city,String carNum/*���˱��*/, String watcher,String carriage,String[] itemIDs) throws RemoteException;//����½����ת��VO
	public TransferDocVO findTransferDocVO (String ID) throws RemoteException, DatabaseNULLException;//��ȡ��ת��VO
	public ArrayList<TransferDocPO> getUncheckedTransferDocPOs() throws RemoteException;
	public double[] getPriceToday();
	public TransferDocPO geTransferDocPOByID(String ID) throws RemoteException, DatabaseNULLException;
	public void  confirmSave() throws RemoteException;
	public void checkHas(String id)throws RemoteException,DatabaseNULLException;
}
