package edu.nju.vo;

import edu.nju.po.Doc;

public class SendDocVO extends Doc{
	String sName,sAddress,sUnit,sTelePhone,sMobilePhone;
	String rName,rAddress,rUnit,rTelePhone,rMobilePhone;
	String itemNum;
	String weight;
	String[] volume;//Με»ύ
	String item_type;
	String packageType;
	String sumPrice;
//	int itemID;
	String courier_Type;
	String time;
	String date;
	
	public SendDocVO(String sName, String sAddress, String sUnit,
			String sTelePhone, String sMobilePhone, String rName,
			String rAddress, String rUnit, String rTelePhone,
			String rMobilePhone, String itemNum, String weight,
			String[] volume, String item_type, String packageType,
			String sumPrice, String courier_Type, String time, String date) {
		super();
		this.sName = sName;
		this.sAddress = sAddress;
		this.sUnit = sUnit;
		this.sTelePhone = sTelePhone;
		this.sMobilePhone = sMobilePhone;
		this.rName = rName;
		this.rAddress = rAddress;
		this.rUnit = rUnit;
		this.rTelePhone = rTelePhone;
		this.rMobilePhone = rMobilePhone;
		this.itemNum = itemNum;
		this.weight = weight;
		this.volume = volume;
		this.item_type = item_type;
		this.packageType = packageType;
		this.sumPrice = sumPrice;
		this.courier_Type = courier_Type;
		this.time = time;
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public String getsAddress() {
		return sAddress;
	}
	public void setsAddress(String sAddress) {
		this.sAddress = sAddress;
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
	public String getItemNum() {
		return itemNum;
	}
	public void setItemNum(String itemNum) {
		this.itemNum = itemNum;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String[] getVolume() {
		return volume;
	}
	public void setVolume(String[] volume) {
		this.volume = volume;
	}
	public String getItem_type() {
		return item_type;
	}
	public void setItem_type(String item_type) {
		this.item_type = item_type;
	}
	public String getPackageType() {
		return packageType;
	}
	public void setPackageType(String packageType) {
		this.packageType = packageType;
	}
	public String getSumPrice() {
		return sumPrice;
	}
	public void setSumPrice(String sumPrice) {
		this.sumPrice = sumPrice;
	}
	public String getCourier_Type() {
		return courier_Type;
	}
	public void setCourier_Type(String courier_Type) {
		this.courier_Type = courier_Type;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
}
