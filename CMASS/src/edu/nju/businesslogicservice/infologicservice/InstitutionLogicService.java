package edu.nju.businesslogicservice.infologicservice;

import java.util.ArrayList;

import edu.nju.po.InstitutionPO;
import edu.nju.po.StaffPO;
import edu.nju.vo.InstitutionVO;
import edu.nju.vo.StaffVO;

public interface InstitutionLogicService {
	
	public int getSalary(int id);//�����Ա�Ĺ���
	public ArrayList<StaffVO> getStaffVO();//���staff���б�
	public ArrayList<InstitutionVO> getInstitutionVOList();//��û����б�
	public double  getDistance(String city1,String city2);//��ó��м�ľ���
	
	
	public void saveSalary (StaffPO po);//����н��PO
	public void saveStaff(StaffPO po);//����Ա����Ϣ
	public void saveInstitution (InstitutionPO po);//���������Ϣ
	public void saveDistance(String city,String city2,double distance);//���������Ϣ
	//collection������
	public double getDistance(String city);//����ʱ�������������ķ���
	public String[][] getCouriers();//���ص�½������������Ա��������һ����ID �ڶ���������
	public String[][] getBusinessHalls(String id);//������ת����ID�г���������
	public String[][] getDrivers();
	public String[][] getTransfers(String id);//����Ӫҵ��ID�г���������

	//financedata������

	public ArrayList<InstitutionPO> getUnpaidInstitutionList();
	public ArrayList<StaffPO> getUnpaidStaffList();
}
