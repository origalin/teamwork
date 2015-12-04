package edu.nju.data.StorageDataServiceImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import com.mysql.fabric.xmlrpc.base.Array;
import com.sun.crypto.provider.RSACipher;
import com.sun.org.apache.xalan.internal.xsltc.compiler.Template;

import edu.nju.data.database.SQL;
import edu.nju.dataservice.storagedataservice.StorageDataService;
import edu.nju.po.InWareHouseDocLineItem;
import edu.nju.po.InWareHouseDocPO;
import edu.nju.po.OutWareHouseDocPO;
import edu.nju.po.RecordPO;
import edu.nju.po.TransferDocPO;
import edu.nju.po.WareHousePO;
import edu.nju.tools.Time;

public class StorageDataServiceImpl extends UnicastRemoteObject implements StorageDataService {

	public StorageDataServiceImpl() throws RemoteException {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update(ArrayList<RecordPO> recordPO) throws RemoteException {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(RecordPO recordPO) throws RemoteException {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<RecordPO> getInWareHouseDocPO_Fly(String storageID) throws RemoteException {
		String sql = "SELECT * FROM �ֿ�洢���� WHERE ��='������'&&�ֿ�ID='" + storageID + "';";
		ArrayList<RecordPO> list = new ArrayList<RecordPO>();
		SQL.databaseQuery(sql);
		try {
			while (SQL.rs.next()) {
				String storageItem_ID = SQL.rs.getString("StorageItem_ID");
				Date date = SQL.rs.getDate("�������");
				String destination = SQL.rs.getString("Ŀ�ĵ�");
				String location = SQL.rs.getString("λ��");
				RecordPO recordPO = new RecordPO(storageItem_ID, date, destination, "������", location);
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
		String sql = "SELECT * FROM �ֿ�洢���� WHERE ��='������'&&�ֿ�ID='" + storageID + "';";
		ArrayList<RecordPO> list = new ArrayList<RecordPO>();
		SQL.databaseQuery(sql);
		try {
			while (SQL.rs.next()) {
				String storageItem_ID = SQL.rs.getString("StorageItem_ID");
				Date date = SQL.rs.getDate("�������");
				String destination = SQL.rs.getString("Ŀ�ĵ�");
				String location = SQL.rs.getString("λ��");
				RecordPO recordPO = new RecordPO(storageItem_ID, date, destination, "������", location);
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
	public ArrayList<RecordPO> getInWareHouseDocPO_Car(String storageID) throws RemoteException {
		String sql = "SELECT * FROM �ֿ�洢���� WHERE ��='������'&&�ֿ�ID='" + storageID + "';";
		ArrayList<RecordPO> list = new ArrayList<RecordPO>();
		SQL.databaseQuery(sql);
		try {
			while (SQL.rs.next()) {
				String storageItem_ID = SQL.rs.getString("StorageItem_ID");
				Date date = SQL.rs.getDate("�������");
				String destination = SQL.rs.getString("Ŀ�ĵ�");
				String location = SQL.rs.getString("λ��");
				RecordPO recordPO = new RecordPO(storageItem_ID, date, destination, "������", location);
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
	public long getOutWareHouseDocID() throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updateOutWareHouseDoc(OutWareHouseDocPO out) throws RemoteException {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) throws RemoteException {
		StorageDataServiceImpl serviceImpl = new StorageDataServiceImpl();
		// for (int i = 0; i < 5; ++i)
		// System.out.println(serviceImpl.getValidLocation("001000", "������"));
		ArrayList<InWareHouseDocLineItem> list = new ArrayList<InWareHouseDocLineItem>();
		list.add(new InWareHouseDocLineItem("0025010010", new Date(), "efjekjfewf", "������", "000000"));
		InWareHouseDocPO po = new InWareHouseDocPO("08000002", "001000", list);

		serviceImpl.updateInWareHouseDoc(po);
		return;

	}

	/**
	 * �����������������ⵥ�ļ�������ʱ��δ�Բֿ������ʵ�ϵı䶯
	 * 
	 * @param in
	 * @throws RemoteException
	 */
	@Override

	public void updateInWareHouseDoc(InWareHouseDocPO in) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("zjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj");
		String sql = "";
		String iD = in.getID();
		String storageID = in.getStorageID();
		ArrayList<InWareHouseDocLineItem> list = in.getList();
		InWareHouseDocLineItem lineItem = list.get(0);
		Date inDate = lineItem.getDate();
		sql = "INSERT INTO ��ⵥ(ID,�������,�ֿ�ID) VALUES('" + iD + "','" + Time.toDaysTime(inDate) + "','" + storageID
				+ "');";
		SQL.databaseUpdate(sql);
		for (InWareHouseDocLineItem temp : list) {
			sql = "INSERT INTO ���items VALUES('" + temp.getSendDocID() + "','" + temp.getDestination() + "','"
					+ temp.getLocation() + "','" + iD + "','" + storageID + "','" + temp.getDistrict() + "');";

			SQL.databaseUpdate(sql);
		}

		SQL.closeDatabase();
	}

	@Override
	public WareHousePO getWareHouse() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void clear() throws RemoteException {
		String sql = "truncate table �ֿ�洢����;";
		SQL.databaseUpdate(sql);
		SQL.closeDatabase();
		System.out.println("�ֿ������");

	}

	/**
	 * ���ֿ���Ӷ��������޸Ĳֿ�
	 * 
	 * @param recordPO
	 * @throws RemoteException
	 */
	@Override
	public void addNewStorageItem(RecordPO recordPO) throws RemoteException {
		String date = Time.toDaysTime(recordPO.getDate());
		String distriction = recordPO.getDistrict();
		String storageID = recordPO.getStorageID();
		String sql = "UPDATE �ֿ�洢���� SET StorageItem_ID='" + recordPO.getItemID() + "',�������='" + date + "',Ŀ�ĵ�='"
				+ recordPO.getDestination() + "' WHERE StorageItem_ID IS NULL && ��='" + distriction + "'&&�ֿ�ID='"
				+ storageID + "' LIMIT 1;";
		SQL.databaseUpdate(sql);
		SQL.closeDatabase();

	}

	@Override
	public void setPercent(double p) throws RemoteException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setAlarm(double p) throws RemoteException {
		// TODO Auto-generated method stub

	}

	@Override
	public void modify(double t) throws RemoteException {
		// TODO Auto-generated method stub

	}

	/**
	 * ����һ����ⵥ
	 * 
	 * @param t
	 * @throws RemoteException
	 */
	// @Override
	// public void updateInWarehouseDoc(InWareHouseDocPO t) throws
	// RemoteException {
	// String iD = t.getInWareHouseDocID();
	// ArrayList<RecordPO> list = t.getRecordPOs();
	// for (RecordPO temp : list) {
	// String itemID = temp.getItemID();
	// Date date = temp.getDate();
	// String destination = temp.getDestination();
	// String location = temp.getLocation();
	// String sql = "INSERT INTO ��ⵥ VALUES(" + iD + "," + Time.toDaysTime(date)
	// + "," + destination + ","
	// + location + "," + itemID + ");";
	// SQL.databaseUpdate(sql);
	//
	// }
	// SQL.closeDatabase();
	//
	// }

	@Override
	public RecordPO find(int StorageItemID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getPercent(String district) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<RecordPO> getOutWarehouseDoc() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc) Ϊ�ܾ�����δ��������ⵥ�б�
	 * δ������
	 * @see edu.nju.dataservice.storagedataservice.StorageDataService#
	 * getInWarehouseDoc()
	 */
	@Override
	public ArrayList<InWareHouseDocPO> getInWarehouseDoc() throws RemoteException {
		ArrayList<InWareHouseDocPO> list = new ArrayList<InWareHouseDocPO>();
		String sql = "SELECT ID,�������,�ֿ�ID,��ݱ��,Ŀ�ĵ�,λ��,�� FROM ��ⵥ,���items WHERE ������='0'&&��ⵥ.ID=���items.��ⵥ��� ORDER BY ID;";
		SQL.databaseQuery(sql);
		InWareHouseDocPO element = null;
		String currinWareHouseDoc_ID = "";
		String inWareHouseDoc_ID = "";

		ArrayList<String> iDs = new ArrayList<String>();
		ArrayList<Date> dates = new ArrayList<Date>();
		ArrayList<String> storageIDs = new ArrayList<String>();
		ArrayList<String> SendDocID = new ArrayList<String>();
		ArrayList<String> destination = new ArrayList<String>();
		ArrayList<String> location = new ArrayList<String>();
		ArrayList<String> district=new ArrayList<String>();
		try {
			while (SQL.rs.next()) {
				iDs.add(SQL.rs.getString(0));
				dates.add(SQL.rs.getDate(1));
				storageIDs.add(SQL.rs.getString(2));
				SendDocID.add(SQL.rs.getString(3));
				destination.add(SQL.rs.getString(4));
				location.add(SQL.rs.getString(5));
				district.add(SQL.rs.getString(6));
			}
		} catch (SQLException e) {
			System.out.println("δ������ⵥ��ȡ����");
			e.printStackTrace();
		}
		int j=0;
		currinWareHouseDoc_ID="";
		String currStorage_ID="";
		for(int i=0;i<storageIDs.size();++i,++j){
			if(!iDs.get(i).equals(currinWareHouseDoc_ID))
			{
				if(j!=0)
					list.add(element);
				element=new InWareHouseDocPO(iDs.get(i),storageIDs.get(i),new ArrayList<InWareHouseDocLineItem>());
				currinWareHouseDoc_ID=iDs.get(i);
				
			}
			InWareHouseDocLineItem lineItem=new InWareHouseDocLineItem(SendDocID.get(i), dates.get(i), destination.get(i),district.get(i),location.get(i));
			element.listAppend(lineItem);
			
			
		}
		return list;
	}

	/**
	 * ��õ�ǰ��ⵥ���
	 * 
	 * @return
	 * @throws RemoteException
	 */
	@Override
	public String getCurrInWare_ID() throws RemoteException {
		String sql = "SELECT currID from currid where Name='��ⵥ';";
		SQL.databaseQuery(sql);
		String currID = "";
		try {
			if (SQL.rs.next())
				currID = SQL.rs.getString("currID");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String newCurrID = String.format("%08d", Integer.parseUnsignedInt(currID) + 1);
		sql = "UPDATE currid SET currID='" + newCurrID + "' WHERE Name='��ⵥ';";
		SQL.databaseUpdate(sql);
		SQL.closeDatabase();
		return currID;
	}

	/**
	 * �Ա���ⵥռ�õĲֿ�λ�ý��б�ǣ��Ѿ����Գɹ�
	 * 
	 * @param list
	 * @throws RemoteException
	 */
	@Override
	public void markPositionOccupied(ArrayList<StorageLocation> list) throws RemoteException {
		String sql = "";
		for (StorageLocation temp : list) {
			String storageId = temp.getStorageID();
			String location = temp.getLocation();
			sql = "UPDATE �ֿ�洢���� SET ����ⵥռ��=" + 1 + " WHERE �ֿ�ID='" + storageId + "'&&λ��='" + location + "';";
			SQL.databaseUpdate(sql);
		}
		SQL.closeDatabase();

	}

	@Override
	public StorageLocation getValidLocation(String sID, String distriction) throws RemoteException {
		System.out.println("sID:" + sID + ";distriction:" + distriction);
		StorageLocation storageLocation = null;
		String location = null;
		String sql = "SELECT λ�� FROM �ֿ�洢���� WHERE StorageItem_ID IS NULL &&�ֿ�ID='" + sID + "'&&����ⵥռ��!=1&&��='"
				+ distriction + "'LIMIT 1;";
		SQL.databaseQuery(sql);
		try {
			if (SQL.rs.next()) {
				location = SQL.rs.getString("λ��");

				storageLocation = new StorageLocation(sID, location);

			}

			else {
				System.out.println("û��λ��");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sql = "UPDATE �ֿ�洢���� SET ����ⵥռ��=1 WHERE �ֿ�ID='" + sID + "' && λ��='" + location + "';";
		SQL.databaseUpdate(sql);
		SQL.closeDatabase();

		return storageLocation;
	}

	/**
	 * δ������
	 * 
	 * @param in
	 * @throws RemoteException
	 */
	@Override
	public void saveInWareHouseDoc(InWareHouseDocPO in) throws RemoteException {
		ArrayList<InWareHouseDocLineItem> list = in.getList();
		String sql = "";
		sql = "UPDATE ��ⵥ SET ������='1' WHERE ID= '" + in.getID() + "';";
		SQL.databaseUpdate(sql);
		for (InWareHouseDocLineItem temp : list) {
			sql = "UPDATE �ֿ�洢���� SET StorageItem_ID='" + temp.getSendDocID() + "',�������='"
					+ Time.toDaysTime(temp.getDate()) + "',Ŀ�ĵ�='" + temp.getDestination() + "' WHERE �ֿ�ID='"
					+ in.getStorageID() + "'&&λ��='" + temp.getLocation() + "';";
			SQL.databaseUpdate(sql);
		}

		SQL.closeDatabase();

	}

}
