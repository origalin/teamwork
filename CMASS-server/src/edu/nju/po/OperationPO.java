package edu.nju.po;

import java.text.DateFormat;
import java.util.Date;

public class OperationPO {
	Date date;
	String staffID;
	String staffName;
	String describration;
	public OperationPO(Date date,	String staffID,String staffName,	String describration){
		this.date=date;
		this.staffID=staffID;
		this.staffName=staffName;
		this.describration=describration;
	}
	public Date getDate() {
		return date;
	}
	@Override
	public String toString() {
	
		return "OperationPO [date=" + date + ", staffID=" + staffID
				+ ", staffName=" + staffName + ", describration="
				+ describration + "]";
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getStaffID() {
		return staffID;
	}
	public void setStaffID(String staffID) {
		this.staffID = staffID;
	}
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	public String getDescribration() {
		return describration;
	}
	public void setDescribration(String describration) {
		this.describration = describration;
	}
	
	
	
}
