package edu.nju.vo;

import java.util.Date;

public class CarVO {
	String carID;
	
	String engineID;
	String plateID;
	String underpanID;
	String institutionName;
	Date buyTime;
	int years;
	public CarVO(String carID,String engineID,String plateID,String underpanID,String institutionName,Date buyTime,int years) {
		super();
		this.carID=carID;
		this.engineID=engineID;
		this.plateID=plateID;
		this.underpanID=underpanID;
		this.institutionName=institutionName;
		this.buyTime=buyTime;
		this.years=years;
	}
	public String getCarID() {
		return carID;
	}
	public void setCarID(String carID) {
		this.carID = carID;
	}
	public String getEngineID() {
		return engineID;
	}
	public void setEngineID(String engineID) {
		this.engineID = engineID;
	}
	public String getInstitutionName() {
		return institutionName;
	}
	public void setInstitutionName(String institutionName) {
		this.institutionName = institutionName;
	}
	public String getPlateID() {
		return plateID;
	}
	public void setPlateID(String plateID) {
		this.plateID = plateID;
	}
	public String getUnderpanID() {
		return underpanID;
	}
	public void setUnderpanID(String underpanID) {
		this.underpanID = underpanID;
	}
	public Date getBuyTime() {
		return buyTime;
	}
	public void setBuyTime(Date buyTime) {
		this.buyTime = buyTime;
	}
	public int getYears() {
		return years;
	}
	public void setYears(int years) {
		this.years = years;
	}
	@Override
	public String toString() {
		return "CarPO [carID=" + carID + ", engineID=" + engineID
				+ ", plateID=" + plateID + ", underpanID=" + underpanID
				+ ", institutionName=" + institutionName + ", buyTime="
				+ buyTime + ", years=" + years + "]";
	}
}
