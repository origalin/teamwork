package edu.nju.po;

import java.util.ArrayList;

public class CourierMoneyPO {
	ArrayList<String> courierIDs;
	ArrayList<Double> currentMoney;
	public double getMoneyOfCourier(String courierID){
		for(int i = 0;i<courierIDs.size();i++){
			if(courierIDs.get(i).equals(courierID)){
				return currentMoney.get(i);
			}
		}else {
			return -1;
		}
	}
	public void cleanMoneyOfCourier(String courierID){
		for(int i = 0;i<courierIDs.size();i++){
			if(courierIDs.get(i).equals(courierID)){
				currentMoney.get(i) = 0;
			}
		}else {
			return -1;
		}
	}
}
