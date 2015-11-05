package edu.nju.businesslogicservice.transformlogicservice;

import edu.nju.po.TransferDocPO;
import edu.nju.vo.TransferDocVO;

public interface TransferDocService {
	public void saveTransferDocPO(TransferDocPO po);//������ת���־û�����
	public int getTransferSequence();//��ȡ��ת����׼���к�
	public void changeTransferSequence(int TransferSequence);//�ı��׼���к�
	public TransferDocVO createTransferDoc_CarVO(int transferCenterID,int carNum/*���˱��*/,int tranceID/*���κ�*/);//����������ת��VO
	public TransferDocVO createTransferDocVO_Plane(int transferCenterID,int carNum/*���˱��*/,int tranceID/*�����*/,int container);//����������ת��VO
	public TransferDocVO createTransferDocVO_Train(int transferCenterID,int carNum/*���˱��*/,int tranceID/*���κ�*/,int carriage);//����½����ת��VO
	public TransferDocVO findTransferDocVO (int ID);//��ȡ��ת��VO
	
}