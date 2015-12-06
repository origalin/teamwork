package edu.nju.businesslogicservice.transformlogicservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.exception.DatabaseNULLException;
import edu.nju.po.OverDocPO;
import edu.nju.vo.OverDocVO;

public interface OverDocService {
	public void saveOverDocPO(OverDocPO po);//保存收件单持久化对象
	public String getOverDocSequence() throws RemoteException;//获取收件单基准序列号
	public void changeOverDocSequence() throws RemoteException;//改变基准序列号
	public OverDocVO findOverDocVO(String ID);//获取收件单VO
	public ArrayList<OverDocPO> getUncheckedOverDocPOs() throws RemoteException;
	public void  confirmSave() throws RemoteException, DatabaseNULLException;
	public OverDocVO createOverDocVO(String[] itemIDs ,String[] receivers) throws RemoteException;
}
