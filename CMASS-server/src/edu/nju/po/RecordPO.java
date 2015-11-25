package edu.nju.po;

import java.util.Date;

//��ⵥ����ݱ�š�������ڡ�Ŀ�ĵء����š��źš�
//�ܺš�λ�ţ�
//�൱��storageitempo
public class RecordPO {
	String itemID;
	Date date;
	String destination;
	String district;
	int location;//����ԭ�����ż�λ��6λ�����֣�2λ�źţ�2λ�ܺţ�2λλ��
	String storageID;//�ֿ�ID
	boolean isCoordinate=false;
	
	public RecordPO(String itemID, Date date, String destination, String district, int location, String storageID,
			boolean isCoordinate) {
		super();
		this.itemID = itemID;
		this.date = date;
		this.destination = destination;
		this.district = district;
		this.location = location;
		this.storageID = storageID;
		this.isCoordinate = isCoordinate;
	}
	
	

	public RecordPO(String itemID, Date date, String destination, String district, int location, String storageID) {
		super();
		this.itemID = itemID;
		this.date = date;
		this.destination = destination;
		this.district = district;
		this.location = location;
		this.storageID = storageID;
	}
	
	



	public RecordPO(String itemID, Date date, String destination, String storageID) {
		super();
		this.itemID = itemID;
		this.date = date;
		this.destination = destination;
		this.storageID = storageID;
	}



	public String getItemID() {
		return itemID;
	}

	public void setItemID(String itemID) {
		this.itemID = itemID;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public int getLocation() {
		return location;
	}

	public void setLocation(int location) {
		this.location = location;
	}

	public String getStorageID() {
		return storageID;
	}

	public void setStorageID(String storageID) {
		this.storageID = storageID;
	}

	public boolean isCoordinate() {
		return isCoordinate;
	}

	public void setCoordinate(boolean isCoordinate) {
		this.isCoordinate = isCoordinate;
	}
	
}
