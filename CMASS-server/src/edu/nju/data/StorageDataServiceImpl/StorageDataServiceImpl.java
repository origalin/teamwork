package edu.nju.data.StorageDataServiceImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import com.sun.crypto.provider.RSACipher;

import edu.nju.data.database.SQL;
import edu.nju.dataservice.storagedataservice.StorageDataService;
import edu.nju.po.InWareHouseDocPO;
import edu.nju.po.OutWareHouseDocPO;
import edu.nju.po.RecordPO;
import edu.nju.po.TransferDocPO;
import edu.nju.po.WareHousePO;
import edu.nju.tools.Time;

public class StorageDataServiceImpl extends UnicastRemoteObject implements StorageDataService  {

	public StorageDataServiceImpl() throws RemoteException{
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update(ArrayList<RecordPO> recordPO)  throws RemoteException{
		// TODO Auto-generated method stub

	}

	@Override
	public void update(RecordPO recordPO) throws RemoteException {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<RecordPO> getInWareHouseDocPO_Fly(String storageID)  throws RemoteException{
		String sql="SELECT * FROM 仓库存储货物 WHERE 区='航运区'&&仓库ID='"+storageID+"';";
		ArrayList<RecordPO> list=new ArrayList<RecordPO>();
		SQL.databaseQuery(sql);
		try {
			while(SQL.rs.next()){
				String storageItem_ID=SQL.rs.getString("StorageItem_ID");
				Date date=SQL.rs.getDate("入库日期");
				String destination=SQL.rs.getString("目的地");
				String location=SQL.rs.getString("位置");
				RecordPO recordPO=new RecordPO(storageItem_ID, date, destination, "航运区",location);
				list.add(recordPO);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<RecordPO> getInWareHouseDocPO_Train(String storageID) throws RemoteException {
		String sql="SELECT * FROM 仓库存储货物 WHERE 区='货运区'&&仓库ID='"+storageID+"';";
		ArrayList<RecordPO> list=new ArrayList<RecordPO>();
		SQL.databaseQuery(sql);
		try {
			while(SQL.rs.next()){
				String storageItem_ID=SQL.rs.getString("StorageItem_ID");
				Date date=SQL.rs.getDate("入库日期");
				String destination=SQL.rs.getString("目的地");
				String location=SQL.rs.getString("位置");
				RecordPO recordPO=new RecordPO(storageItem_ID, date, destination, "货运区",location);
				list.add(recordPO);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public ArrayList<RecordPO> getInWareHouseDocPO_Car(String storageID)throws RemoteException{
		String sql="SELECT * FROM 仓库存储货物 WHERE 区='汽运区'&&仓库ID='"+storageID+"';";
		ArrayList<RecordPO> list=new ArrayList<RecordPO>();
		SQL.databaseQuery(sql);
		try {
			while(SQL.rs.next()){
				String storageItem_ID=SQL.rs.getString("StorageItem_ID");
				Date date=SQL.rs.getDate("入库日期");
				String destination=SQL.rs.getString("目的地");
				String location=SQL.rs.getString("位置");
				RecordPO recordPO=new RecordPO(storageItem_ID, date, destination, "汽运区",location);
				list.add(recordPO);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public long getInWareHouseDocID() throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<RecordPO> getStorageItemList(int[] SendDocIDList) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getOutWareHouseDocID() throws RemoteException{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updateOutWareHouseDoc(OutWareHouseDocPO out)  throws RemoteException{
		// TODO Auto-generated method stub

	}

	@Override
	public void updateInWareHouseDoc(InWareHouseDocPO in)  throws RemoteException{
		// TODO Auto-generated method stub

	}

	@Override
	public WareHousePO getWareHouse() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void clear() throws RemoteException{
		String sql="truncate table 仓库存储货物;";
		SQL.databaseUpdate(sql);
		SQL.closeDatabase();
		System.out.println("仓库已清空");

	}
public static void main(String[] args)  throws RemoteException{
	StorageDataServiceImpl serviceImpl=new StorageDataServiceImpl();
System.out.println(serviceImpl.getCurrInWare_ID());
	
	
}
	@Override
	public void addNewStorageItem(RecordPO recordPO) throws RemoteException{
		String date=Time.toDaysTime(recordPO.getDate());
		String distriction=recordPO.getDistrict();
		String storageID=recordPO.getStorageID();
		String sql="UPDATE 仓库存储货物 SET StorageItem_ID='"+recordPO.getItemID()+"',入库日期='"+date+"',目的地='"+recordPO.getDestination()+
				"' WHERE StorageItem_ID IS NULL && 区='"+distriction+"'&&仓库ID='"+storageID+"' LIMIT 1;";
		SQL.databaseUpdate(sql);
		SQL.closeDatabase();

	}

	@Override
	public void setPercent(double p) throws RemoteException{
		// TODO Auto-generated method stub

	}

	@Override
	public void setAlarm(double p)throws RemoteException {
		// TODO Auto-generated method stub

	}

	@Override
	public void modify(double t)throws RemoteException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateInWarehouseDoc(InWareHouseDocPO t) throws RemoteException{
		// TODO Auto-generated method stub

	}

	@Override
	public RecordPO find(int StorageItemID)throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getPercent(String district) throws RemoteException{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<RecordPO> getOutWarehouseDoc() throws RemoteException{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<InWareHouseDocPO> getInWarehouseDoc() throws RemoteException{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCurrInWare_ID() throws RemoteException{
		String sql="SELECT currID from currid where Name='入库单';";
		SQL.databaseQuery(sql);
		String currID="";
		try {
			if(SQL.rs.next())
				currID=SQL.rs.getString("currID");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String newCurrID=String.format("%08d",Integer.parseUnsignedInt(currID)+1);
		sql="UPDATE currid SET currID='"+newCurrID+"' WHERE Name='入库单';";
		SQL.databaseUpdate(sql);
		SQL.closeDatabase();
		return currID;
	}

	@Override
	public TransferDocPO getTransferDocPO(String Transfer) {
		// TODO Auto-generated method stub
		return null;
	}

}
