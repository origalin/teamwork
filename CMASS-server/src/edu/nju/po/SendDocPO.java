package edu.nju.po;

import edu.nju.vo.SendDocVO;

public class SendDocPO extends Doc{
	String sName,aAddress,sCity,sUnit,sTelePhone,sMobilePhone;
	String rName,rAddress,rCity,rUnit,rTelePhone,rMobilePhone;
	int itemNum;
	Double weight;
	double[] volume;//Με»ύ
	String item_type;
	int packageType;
	Double sumPrice;
//	int itemID;
	int courier_Type;
	long date;
	int time;
	
	public SendDocPO(String sName, String aAddress, String sCity, String sUnit,
			String sTelePhone, String sMobilePhone, String rName,
			String rAddress, String rCity, String rUnit, String rTelePhone,
			String rMobilePhone, int itemNum, Double weight, double[] volume2,
			String item_type, int packageType, Double sumPrice,
			int courier_Type, long date, int time) {
		super();
		this.sName = sName;
		this.aAddress = aAddress;
		this.sCity = sCity;
		this.sUnit = sUnit;
		this.sTelePhone = sTelePhone;
		this.sMobilePhone = sMobilePhone;
		this.rName = rName;
		this.rAddress = rAddress;
		this.rCity = rCity;
		this.rUnit = rUnit;
		this.rTelePhone = rTelePhone;
		this.rMobilePhone = rMobilePhone;
		this.itemNum = itemNum;
		this.weight = weight;
		this.volume = volume2;
		this.item_type = item_type;
		this.packageType = packageType;
		this.sumPrice = sumPrice;
		this.courier_Type = courier_Type;
		this.date = date;
		this.time = time;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public String getaAddress() {
		return aAddress;
	}
	public void setaAddress(String aAddress) {
		this.aAddress = aAddress;
	}
	public String getsCity() {
		return sCity;
	}
	public void setsCity(String sCity) {
		this.sCity = sCity;
	}
	public String getsUnit() {
		return sUnit;
	}
	public void setsUnit(String sUnit) {
		this.sUnit = sUnit;
	}
	public String getsTelePhone() {
		return sTelePhone;
	}
	public void setsTelePhone(String sTelePhone) {
		this.sTelePhone = sTelePhone;
	}
	public String getsMobilePhone() {
		return sMobilePhone;
	}
	public void setsMobilePhone(String sMobilePhone) {
		this.sMobilePhone = sMobilePhone;
	}
	public String getrName() {
		return rName;
	}
	public void setrName(String rName) {
		this.rName = rName;
	}
	public String getrAddress() {
		return rAddress;
	}
	public void setrAddress(String rAddress) {
		this.rAddress = rAddress;
	}
	public String getrCity() {
		return rCity;
	}
	public void setrCity(String rCity) {
		this.rCity = rCity;
	}
	public String getrUnit() {
		return rUnit;
	}
	public void setrUnit(String rUnit) {
		this.rUnit = rUnit;
	}
	public String getrTelePhone() {
		return rTelePhone;
	}
	public void setrTelePhone(String rTelePhone) {
		this.rTelePhone = rTelePhone;
	}
	public String getrMobilePhone() {
		return rMobilePhone;
	}
	public void setrMobilePhone(String rMobilePhone) {
		this.rMobilePhone = rMobilePhone;
	}
	public int getItemNum() {
		return itemNum;
	}
	public void setItemNum(int itemNum) {
		this.itemNum = itemNum;
	}
	public Double getWeight() {
		return weight;
	}
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	public double[] getVolume() {
		return volume;
	}
	public void setVolume(double[] volume) {
		this.volume = volume;
	}
	public String getItem_type() {
		return item_type;
	}
	public void setItem_type(String item_type) {
		this.item_type = item_type;
	}
	public int getPackageType() {
		return packageType;
	}
	public void setPackageType(int packageType) {
		this.packageType = packageType;
	}
	public Double getSumPrice() {
		return sumPrice;
	}
	public void setSumPrice(Double sumPrice) {
		this.sumPrice = sumPrice;
	}
	public int getCourier_Type() {
		return courier_Type;
	}
	public void setCourier_Type(int courier_Type) {
		this.courier_Type = courier_Type;
	}
	public long getDate() {
		return date;
	}
	public void setDate(long date) {
		this.date = date;
	}

	public SendDocVO toVo() {
		return null;
	}
	
}
