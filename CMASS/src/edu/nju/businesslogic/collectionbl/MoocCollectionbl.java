package edu.nju.businesslogic.collectionbl;

import java.util.ArrayList;

import edu.nju.po.SendDocPO;

public class MoocCollectionbl extends Collectionbl{
	public MoocCollectionbl(String institutionID, String staffID) {
		super( staffID);
		// TODO 自动生成的构造函数存根
	}
	String getTargetAddress(String itemID) {
		return "栖霞区仙林大道168号";
	}
	ArrayList<SendDocPO> getSendDocPOsPyID(String staffID){
		double[] volume = {12.5,23.5,21.4};
		ArrayList<SendDocPO>  list= new ArrayList<SendDocPO>();
		for(int i = 0;i<10;i++) {
			//list.add(new SendDocPO("name"+i, "address"+i, "city"+i, "unit"+i, "123445432", "123445432", "name"+i, "address"+i, "city"+i, "unit"+i,	"123445432", "123445432", 1, 12.5, volume, "haha", 1, 12.5, 0, System.currentTimeMillis(), 3));
		}
		return list;
		
	}
}
