package edu.nju.dataservice.logisticsqueryDataService;

import edu.nju.po.PositionPO;

public interface LogisticsDataService {
	
	public void changePosition(long ItemID,String pos);
	public void createPosition(long Item,String pos);
	PositionPO positionQuery(String ItemID);

}
