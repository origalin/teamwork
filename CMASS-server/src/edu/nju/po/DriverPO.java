package edu.nju.po;

import java.util.Date;

//˾����Ϣ��˾����ţ����б�ţ��绰���������Ͼ�025��
//+Ӫҵ����ţ�000��λ���֣�+000��λ���֡��������������ڡ�
//���֤�š��ֻ� ���Ա���ʻ֤���ޣ�
public class DriverPO {
	String driverID;
	String name;
	Date birthday;
	String identity;
	String phone_numer;
	String sex;
	String limit;
	public DriverPO(String driverID, String name, Date birthday,
			String identity, String phone_numer, String sex, String limit) {
		super();
		this.driverID = driverID;
		this.name = name;
		this.birthday = birthday;
		this.identity = identity;
		this.phone_numer = phone_numer;
		this.sex = sex;
		this.limit = limit;
	}
	public String getDriverID() {
		return driverID;
	}
	public void setDriverID(String driverID) {
		this.driverID = driverID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getIdentity() {
		return identity;
	}
	public void setIdentity(String identity) {
		this.identity = identity;
	}
	public String getPhone_numer() {
		return phone_numer;
	}
	public void setPhone_numer(String phone_numer) {
		this.phone_numer = phone_numer;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getLimit() {
		return limit;
	}
	public void setLimit(String limit) {
		this.limit = limit;
	}
	
}
