package edu.nju.po;
//司机信息（司机编号（城市编号（电话号码区号南京025）
//+营业厅编号（000三位数字）+000三位数字、姓名、出生日期、
//身份证号、手机 、性别、行驶证期限）
public class DriverPO {
	int driverID;
	String name;
	String birthday;
	String identity;
	String phone_numer;
	String sex;
	int limit;
	public DriverPO(int driverID, String name, String birthday,
			String identity, String phone_numer, String sex, int limit) {
		super();
		this.driverID = driverID;
		this.name = name;
		this.birthday = birthday;
		this.identity = identity;
		this.phone_numer = phone_numer;
		this.sex = sex;
		this.limit = limit;
	}
	public int getDriverID() {
		return driverID;
	}
	public void setDriverID(int driverID) {
		this.driverID = driverID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
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
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	
}
