package edu.nju.businesslogicservice.infologicservice;

import java.util.ArrayList;

import edu.nju.po.InstitutionPO;
import edu.nju.po.Post;
import edu.nju.po.StaffPO;
import edu.nju.vo.InstitutionVO;
import edu.nju.vo.StaffVO;

public interface InstitutionLogicService {
	
	public int getSalary(int id);//�����Ա�Ĺ���
	public ArrayList<StaffVO> getStaffVO();//���staff���б�
	public ArrayList<InstitutionVO> getInstitutionVOList();//��û����б�

	
	
	public void saveSalary (StaffPO po);//����н��PO
	public void saveStaff(StaffPO po);//����Ա����Ϣ
	public void saveInstitution (InstitutionPO po);//���������Ϣ
	//collection������
	
	public String[][] getCouriers();//���ص�½������������Ա��������һ����ID �ڶ���������
	public String[][] getBusinessHalls(String id);//������ת����ID�г���������
	public String[][] getDrivers(String id);     //���ݻ���id�г�����˾������
	public String[][] getTransfers(String id);//����Ӫҵ��ID�г���������
	public String getCityAndName(String id);//���ݻ���id����city+name  
	public String getStaffName(String id);//������ԱID������Ա����
	public String getInstitutionName(String id);//������ԱID���ػ�������
	public String getInstitutionID(String id);//������ԱID���ػ���ID
	
	
	//financedata������

	public ArrayList<InstitutionPO> getUnpaidInstitutionList();
	public ArrayList<StaffPO> getUnpaidStaffList();
	
	
	public void resetSalary();

	public void resetRent();
	
	Post getPosition(String staffID);//����ID���ҵ�����˵�ְλ
	double getBase(String staffID);//����ID���ҵ�����˵Ļ�������
	double getBonus(String staffID);//����ID���ҵ�����˵Ľ���
	double getPercentage(String staffID);//����ID����������Ա����ɱ���
	double getDriverCommision(String driverID);//����ID�������˾��ÿ�ε�Ǯ��



}
