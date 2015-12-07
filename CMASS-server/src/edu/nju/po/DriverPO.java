package edu.nju.po;

import java.io.Serializable;
import java.util.Date;

//˾����Ϣ��˾����ţ����б�ţ��绰���������Ͼ�0025��
//+Ӫҵ����ţ�000��λ���֣�+000��λ���֡��������Ա𡢳������ڡ�
//���֤�š��ֻ� ����ʻ֤��ʼ���ڡ���ʻ֤ʧЧ���ڣ�
public class DriverPO implements Serializable{
	String driverID;
	String name;	
	String sex;
	Date birthday;
	String identity;
	String tel;
	String institution;
	Date beginLimit;
	Date endLimit;
	Double money;
	boolean isPaid;
	public DriverPO(String driverID, String name, String sex, Date birthday,
			String identity, String tel, String institution, Date beginLimit,
			Date endLimit, Double money, boolean isPaid) {
		super();
		this.driverID = driverID;
		this.name = name;
		this.sex = sex;
		this.birthday = birthday;
		this.identity = identity;
		this.tel = tel;
		this.institution = institution;
		this.beginLimit = beginLimit;
		this.endLimit = endLimit;
		this.money =money;
		this.isPaid = isPaid;
	}
	
	public DriverPO(String driverID, String name, String sex, Date birthday,
			String identity, String tel, String institution, Date beginLimit,
			Date endLimit) {
		super();
		this.driverID = driverID;
		this.name = name;
		this.sex = sex;
		this.birthday = birthday;
		this.identity = identity;
		this.tel = tel;
		this.institution = institution;
		this.beginLimit = beginLimit;
		this.endLimit = endLimit;
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
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
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
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getInstitution() {
		return institution;
	}
	public void setInstitution(String institution) {
		this.institution = institution;
	}
	public Date getBeginLimit() {
		return beginLimit;
	}
	public void setBeginLimit(Date beginLimit) {
		this.beginLimit = beginLimit;
	}
	public Date getEndLimit() {
		return endLimit;
	}
	public void setEndLimit(Date endLimit) {
		this.endLimit = endLimit;
	}
	public Double getMoney() {
		return money;
	}
	public void setMoney(Double money) {
		this.money = money;
	}
	public boolean isPaid() {
		return isPaid;
	}
	public void setPaid(boolean isPaid) {
		this.isPaid = isPaid;
	}
	@Override
	public String toString() {
		return "DriverPO [driverID=" + driverID + ", name=" + name + ", sex="
				+ sex + ", birthday=" + birthday + ", identity=" + identity
				+ ", tel=" + tel + ", institution=" + institution
				+ ", beginLimit=" + beginLimit + ", endLimit=" + endLimit
				+ ", money=" + money + ", isPaid=" + isPaid + "]";
	}
	
	
}
