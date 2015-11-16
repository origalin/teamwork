package edu.nju.vo;

import java.util.ArrayList;

public class OutWareHouseDocVO {
	
	public OutWareHouseDocVO(ArrayList<OutWareHouseDocLineItem> outWareHouseDocVO, String outWareHouseDocID) {
		super();
		this.outWareHouseDocVO = outWareHouseDocVO;
		this.outWareHouseDocID = outWareHouseDocID;
	}
	ArrayList<OutWareHouseDocLineItem> outWareHouseDocVO=new ArrayList<OutWareHouseDocLineItem>();
	String outWareHouseDocID; 
	
	public String toString(){
		String result="";
			for(OutWareHouseDocLineItem temp:outWareHouseDocVO)
				result+=temp.toString2();
			
			return result;
		
	}

}
