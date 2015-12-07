package edu.nju.businesslogicservice.infologicservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.po.InstitutionPO;
import edu.nju.po.Post;
import edu.nju.po.StaffPO;
import edu.nju.vo.InstitutionVO;
import edu.nju.vo.StaffVO;

public interface InstitutionLogicService {
	
	
	
	
//	public int getSalary(int id);//�����Ա�Ĺ���
//	public ArrayList<StaffVO> getStaffVO();//���staff���б�
//	public ArrayList<InstitutionVO> getInstitutionVOList();//��û����б�
//
//	
//	
//	public void saveSalary (StaffPO po);//����н��PO
//	public void saveStaff(StaffPO po);//����Ա����Ϣ
//	public void saveInstitution (InstitutionPO po);//���������Ϣ
	//collection������
	
	
	public ArrayList<String> getCourierID(String institutionID)throws RemoteException;//
	public String getTransferCenterID(String institutionID)throws RemoteException;//
	public ArrayList<String> getSubInstitutionID(String institutionID)throws RemoteException;//
	
	public String getName(String id)throws RemoteException;//���ݻ���id����name  
	public String getStaffName(String id)throws RemoteException;//������ԱID������Ա����
	public String getInstitutionName(String id)throws RemoteException;//������ԱID���ػ�������
	public String getInstitutionID(String id)throws RemoteException;//������ԱID���ػ���ID
	public String getCity(String institutionid)throws RemoteException;//���ݻ���id���ػ�������
	
	
	//financedata������

	public ArrayList<InstitutionPO> getUnpaidInstitutionList()throws RemoteException;
	public ArrayList<StaffPO> getUnpaidStaffList()throws RemoteException;
	public void resetSalary()throws RemoteException; //�������˵����Ը�Ϊδ����
	public void saveSalary(String id)throws RemoteException;//����Ա��id ��Ϊ�Ѹ���
	public void saveRent(String id)throws RemoteException;//���ݻ���id ��Ϊ�Ѹ���	
	public void resetRent()throws RemoteException;   //�����л�����Ϊδ�����
	Post getPosition(String staffID)throws RemoteException;//����ID���ҵ�����˵�ְλ
	double getBase(String staffID)throws RemoteException;//����ID���ҵ�����˵Ļ�������
	double getBonus(String staffID)throws RemoteException;//����ID���ҵ�����˵Ľ���
	double getPercentage(String staffID)throws RemoteException;//����ID����������Ա����ɱ���
	
}
