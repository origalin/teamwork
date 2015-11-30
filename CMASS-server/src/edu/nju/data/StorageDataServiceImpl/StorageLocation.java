package edu.nju.data.StorageDataServiceImpl;

import java.io.Serializable;

public class StorageLocation  implements Serializable{

	String storageID;
	String location;
	public StorageLocation() {
		// TODO Auto-generated constructor stub
	}
	public StorageLocation(String storageID, String location) {
		super();
		this.storageID = storageID;
		this.location = location;
	}
	public String getStorageID() {
		return storageID;
	}
	public void setStorageID(String storageID) {
		this.storageID = storageID;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "StorageLocation [storageID=" + storageID + ", location=" + location + "]";
	}
	
	
	
	
	

}
