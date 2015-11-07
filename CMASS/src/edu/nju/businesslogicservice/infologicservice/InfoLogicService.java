package edu.nju.businesslogicservice.infologicservice;

import java.util.ArrayList;

import edu.nju.po.CarPO;
import edu.nju.po.DriverPO;
import edu.nju.po.InstitutionPO;
import edu.nju.po.StaffPO;
import edu.nju.vo.CarVO;
import edu.nju.vo.DriverVO;
import edu.nju.vo.InstitutionVO;
import edu.nju.vo.StaffVO;

public interface InfoLogicService {

	public ArrayList<DriverVO> getDriveVOList();//���˾����Ϣ�б�
	public ArrayList<CarVO> getCarList();//��ó�����Ϣ
	public int getSalary(int id);//�����Ա�Ĺ���
	public ArrayList<StaffVO> getStaffVO();//���staff���б�
	public ArrayList<InstitutionVO> getInstitutionVOList();//��û����б�
	public double  getDistance(String city1,String city2);//��ó��м�ľ���
	public void saveDriver(DriverPO po);//����˾��PO
	public void saveCar(CarPO po);//���泵��PO
	public void saveSalary (StaffPO po);//����н��PO
	public void saveStaff(StaffPO po);//����Ա����Ϣ
	public void saveInstitution (InstitutionPO po);//���������Ϣ
	public void saveDistance(String city,String city2,double distance);//���������Ϣ
	//collection������
	public double getDistance(String city);//����ʱ�������������ķ���
	//financedata������
	public ArrayList<String> getInstitutionList();//�������л���������
	public ArrayList<StaffVO> getStaffList();//��������Ա�����������ڽ��й��ʵļ���
}
