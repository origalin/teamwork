package edu.nju.businesslogic.systembl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;







import java.util.Date;

import edu.nju.businesslogicservice.systemlogicservice.SystemLogicService;
import edu.nju.dataFactory.DataFactory;
import edu.nju.dataservice.logisticsqueryDataService.LogisticsDataService;
import edu.nju.dataservice.systemdataservice.SystemDataService;
import edu.nju.po.AccountPO;
import edu.nju.po.CarPO;
import edu.nju.po.OperationPO;
import edu.nju.tools.Time;
import edu.nju.vo.AccountVO;
import edu.nju.vo.CarVO;
import edu.nju.vo.OperationVO;

public class SystemBl implements SystemLogicService{
	SystemDataService systemDataService;
	public SystemBl() {
		super();
		this.systemDataService=DataFactory.getSystemDataService();
	}
	@Override
	public void saveOperation(OperationPO po) throws RemoteException {
		// TODO Auto-generated method stub
		systemDataService.saveOperationLog(po);
		
	}
	@Override
	public ArrayList<OperationVO> getOperationVOList(Date beginTime,
			Date endTime) throws RemoteException {
		ArrayList<OperationVO> operationVOList=new ArrayList<OperationVO>();
		ArrayList<OperationPO> operationPOList=new ArrayList<OperationPO>();
	
			operationPOList=systemDataService.findOperationLog(beginTime, endTime);
	
		for(OperationPO po:operationPOList){
			operationVOList.add(new OperationVO(po.getDate(),po.getStaffID(),po.getStaffName(),po.getDescribration()));
		}
		
		return operationVOList;
		
	}
	@Override
	public String[] getPasswordAndPower(String id) throws RemoteException {
		// TODO Auto-generated method stub
		String[] str;
		str=systemDataService.getPasswordAndPower(id);
		return str;
	}
	@Override
	public void changePasswordAndPower(String[] str) throws RemoteException {
		// TODO Auto-generated method stub
		systemDataService.changePasswordAndPower(str);
	}

	

}
