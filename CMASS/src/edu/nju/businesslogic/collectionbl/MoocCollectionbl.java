package edu.nju.businesslogic.collectionbl;

import java.util.ArrayList;

import edu.nju.po.SendDocPO;

public class MoocCollectionbl extends Collectionbl{
	String getTargetAddress(String itemID) {
		return "栖霞区仙林大道168号";
	}
	ArrayList<SendDocPO> getSendDocPOsPyID(String staffID){
		return null;
		
	}
}
