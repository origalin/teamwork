package edu.nju.po;

import java.util.ArrayList;

public class CourierMoneyPO {
	ArrayList<CourierMessage> courierList;
	class CourierMessage{
		public CourierMessage(String courierID,String itemID,double money) {
			// TODO Auto-generated constructor stub
			this.courierID = courierID;
			this.money = money;
			this.itemIDs = new ArrayList<String>();
			this.itemIDs.add(itemID);
		}
		String courierID;
		Double money = 0.0;
		ArrayList<String> itemIDs;
	}
	public void appendMoney(String courierID,String itemID,double money) {
		for(int i = 0;i<courierList.size();i++) {
			if(courierList.get(i).courierID.equals(courierID)) {
				courierList.get(i).itemIDs.add(itemID);
				courierList.get(i).money+=money;
				return;
			}
		}
		courierList.add(new CourierMessage(courierID, itemID, money));
	}
	public ArrayList<String> getCourierSendDoc(String courierID) {
		for(int i = 0;i<courierList.size();i++) {
			if(courierList.get(i).courierID.equals(courierID)) {
				return courierList.get(i).itemIDs;				
			}
			
		}return null;
	}
	public double getCourierMoney(String courierID) {
		for(int i = 0;i<courierList.size();i++) {
			if(courierList.get(i).courierID.equals(courierID)) {
				return courierList.get(i).money;				
			}
			
		}return 0;
	}
	public void cleanCourierMessage(String courierID) {
		for(int i = 0;i<courierList.size();i++) {
			if(courierList.get(i).courierID.equals(courierID)) {
				courierList.get(i).money = 0.0;
				courierList.get(i).itemIDs = new ArrayList<String>();
			}
			
		}
	}
}
