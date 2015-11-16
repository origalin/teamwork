package edu.nju.businesslogicservice.infologicservice;

import java.util.ArrayList;

import edu.nju.po.DriverPO;
import edu.nju.vo.DriverVO;

public interface DriverLogicService {
	public ArrayList<DriverVO> getDriveVOList();//获得司机信息列表
	public void saveDriver(DriverPO po);//保存司机PO
}
