package edu.nju.po;

public class SendDocPO {
	String sName,aAddress,sTelePhone,sMobilePhone;
	String rName,rAddress,rTelePhone,rMobilePhone;
	int itemName;
	Double weight;
	Double[] volume;//Με»ύ
	String item_type;
	String cpackage;
	Double sumPrice;
	int itemID;
	String courier_Type;
	long date;
	public SendDocPO(String sName, String aAddress, String sTelePhone,
			String sMobilePhone, String rName, String rAddress,
			String rTelePhone, String rMobilePhone, int itemName,
			Double weight, Double[] volume, String item_type, String cpackage,
			Double sumPrice, int itemID, String courier_Type, long date) {
		super();
		this.sName = sName;
		this.aAddress = aAddress;
		this.sTelePhone = sTelePhone;
		this.sMobilePhone = sMobilePhone;
		this.rName = rName;
		this.rAddress = rAddress;
		this.rTelePhone = rTelePhone;
		this.rMobilePhone = rMobilePhone;
		this.itemName = itemName;
		this.weight = weight;
		this.volume = volume;
		this.item_type = item_type;
		this.cpackage = cpackage;
		this.sumPrice = sumPrice;
		this.itemID = itemID;
		this.courier_Type = courier_Type;
		this.date = date;
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
	public int getItemName() {
		return itemName;
	}
	public void setItemName(int itemName) {
		this.itemName = itemName;
	}
	public Double getWeight() {
		return weight;
	}
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	public Double[] getVolume() {
		return volume;
	}
	public void setVolume(Double[] volume) {
		this.volume = volume;
	}
	public String getItem_type() {
		return item_type;
	}
	public void setItem_type(String item_type) {
		this.item_type = item_type;
	}
	public String getCpackage() {
		return cpackage;
	}
	public void setCpackage(String cpackage) {
		this.cpackage = cpackage;
	}
	public Double getSumPrice() {
		return sumPrice;
	}
	public void setSumPrice(Double sumPrice) {
		this.sumPrice = sumPrice;
	}
	public int getItemID() {
		return itemID;
	}
	public void setItemID(int itemID) {
		this.itemID = itemID;
	}
	public String getCourier_Type() {
		return courier_Type;
	}
	public void setCourier_Type(String courier_Type) {
		this.courier_Type = courier_Type;
	}
	public long getDate() {
		return date;
	}
	public void setDate(long date) {
		this.date = date;
	}
	
}
