package edu.nju.businesslogicservice.infologicservice;

import java.util.ArrayList;

import edu.nju.po.DriverPO;
import edu.nju.vo.DriverVO;

public interface DriverLogicService {
	public ArrayList<DriverVO> getDriveVOList();//���˾����Ϣ�б�
	public void saveDriver(DriverPO po);//����˾��PO
}
