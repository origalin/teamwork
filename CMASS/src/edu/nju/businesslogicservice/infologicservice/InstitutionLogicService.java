package edu.nju.businesslogicservice.infologicservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.po.InstitutionPO;
import edu.nju.po.Post;
import edu.nju.po.SalaryPO;
import edu.nju.po.StaffPO;
import edu.nju.vo.InstitutionVO;
import edu.nju.vo.StaffVO;

public interface InstitutionLogicService {
	
	
	public ArrayList<StaffVO> getStaffVOList(String institutionName)throws RemoteException;//���staff���б�
	public ArrayList<InstitutionVO> getInstitutionVOList()throws RemoteException;//��û����б�

	public void saveSalary (SalaryPO po)throws RemoteException;//����н��PO
	public SalaryPO getSalary(String staffID)throws RemoteException;
	
	public void saveStaff(StaffPO po)throws RemoteException;//����Ա����Ϣ
	public void saveInstitution (InstitutionPO po)throws RemoteException;//���������Ϣ
	
	public void deleteInstitution(InstitutionPO po)throws RemoteException;
	public void deleteStaff(StaffPO po)throws RemoteException;
	
	//collection������
	
	
	public ArrayList<String> getCourierID(String institutionID)throws RemoteException;//
	public String getTransferCenterID(String institutionID)throws RemoteException;//
	public ArrayList<String> getSubInstitutionID(String institutionID)throws RemoteException;//
	
	public String getID(String institutionName)throws RemoteException;//���ݻ������Ʒ���id
	public String getName(String institutionId)throws RemoteException;//���ݻ���id����name  
	public String getStaffName(String staffid)throws RemoteException;//������ԱID������Ա����
	public String getInstitutionName(String staffid)throws RemoteException;//������ԱID���ػ�������
	public String getInstitutionID(String Staffid)throws RemoteException;//������ԱID���ػ���ID
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
