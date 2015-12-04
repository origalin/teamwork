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
	
	public ArrayList<String> getDirverID(String institutionID);//
	public String getDirverName(String driverID);
	public ArrayList<String> getCourierID(String institutionID);//
	public String getTransferCenterID(String institutionID);//
	public ArrayList<String> getSubInstitutionID(String institutionID);
	
	public String getName(String id);//���ݻ���id����name  
	public String getStaffName(String id);//������ԱID������Ա����
	public String getInstitutionName(String id);//������ԱID���ػ�������
	public String getInstitutionID(String id);//������ԱID���ػ���ID
	public String getCity(String institutionid);//���ݻ���id���ػ�������
	
	
	//financedata������

	public ArrayList<InstitutionPO> getUnpaidInstitutionList();
	public ArrayList<StaffPO> getUnpaidStaffList();
	public void resetSalary(); //�������˵����Ը�Ϊδ����
	public void saveSalary(String id);//����Ա��id ��Ϊ�Ѹ���
	public void saveDriverSalary(String id);//����˾��id ��Ϊ�Ѹ���
	public void saveRent(String id);//���ݻ���id ��Ϊ�Ѹ���
	
	public void resetRent();   //�����л�����Ϊδ�����
	Post getPosition(String staffID);//����ID���ҵ�����˵�ְλ
	double getBase(String staffID);//����ID���ҵ�����˵Ļ�������
	double getBonus(String staffID);//����ID���ҵ�����˵Ľ���
	double getPercentage(String staffID);//����ID����������Ա����ɱ���
	double getDriverCommision(String driverID);//����ID�������˾��ÿ�ε�Ǯ��
}
