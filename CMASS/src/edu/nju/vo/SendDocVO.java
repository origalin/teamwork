package edu.nju.vo;

import edu.nju.vo.Doc;

import java.util.Date;

import edu.nju.po.SendDocPO;
import edu.nju.tools.Time;

public class SendDocVO extends Doc {
	String sName, sCity, sAddress, sUnit, sTelePhone, sMobilePhone;
	String rName, rCity, rAddress, rUnit, rTelePhone, rMobilePhone;
	String itemNum;
	String weight;
	String[] volume;// 体积
	String item_type;
	String packageType;
	String sumPrice;
	// int itemID;
	String courier_Type;
	String time;
	String date;

	public SendDocVO(SendDocPO po) {
		this.ID = po.getID();
		this.date = Time.toDaysTime(po.getDate());
		this.sName = po.getsName();
		this.sCity = po.getsCity();
		this.sAddress = po.getaAddress();
		this.sUnit = po.getsUnit();
		this.sTelePhone = po.getsTelePhone();
		this.sMobilePhone = po.getsMobilePhone();
		this.rName = po.getrName();
		this.rCity = po.getrCity();
		this.rAddress = po.getrAddress();
		this.rUnit = po.getrUnit();
		this.rTelePhone = po.getrTelePhone();
		this.rMobilePhone = po.getrMobilePhone();
		this.itemNum = String.valueOf(po.getItemNum());
		this.weight = String.valueOf(po.getWeight());
		this.volume = new String[] { String.valueOf(po.getVolume()[0]), String.valueOf(po.getVolume()[1]),
				String.valueOf(po.getVolume()[2]) };
		this.item_type = po.getItem_type();
		switch (po.getPackageType()) {
		case 1:
			this.packageType = "木箱";
			break;
		case 2:
			this.packageType = "纸箱";
			break;
		case 3:
			this.packageType = "快递袋";
			break;
		case 4:
			this.packageType = "其他";
			break;

		default:
			break;
		}
		this.sumPrice = String.valueOf(po.getSumPrice());
		switch (po.getCourier_Type()) {
		case 0:
			this.courier_Type = "特快专递";
			break;
		case 1:
			this.courier_Type = "普通快递";
			break;
		case 2:
			this.courier_Type = "经济快递";
			break;
		default:
			break;
		}
		this.time = String.valueOf(po.getTime());
	}

	public String getsCity() {
		return sCity;
	}

	public void setsCity(String sCity) {
		this.sCity = sCity;
	}

	public String getrCity() {
		return rCity;
	}

	public void setrCity(String rCity) {
		this.rCity = rCity;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDate() {
		return date;
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

}
