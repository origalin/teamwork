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
import edu.nju.po.OutRecord;
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

	public ArrayList<RecordPO> getStorageItems(String storageID,int ctrl){
		
		//表驱动
		String[] sqls={"SELECT * FROM 仓库存储货物 WHERE 区='航运区'&&仓库ID='" + storageID + "';",
			"SELECT * FROM 仓库存储货物 WHERE 区='货运区'&&仓库ID='" + storageID + "';",
			"SELECT * FROM 仓库存储货物 WHERE 区='汽运区'&&仓库ID='" + storageID + "';"};
		String[] districts={"航运区","货运区","汽运区"};
		String sql=sqls[ctrl];
		String district=districts[ctrl];
			
		ArrayList<RecordPO> list = new ArrayList<RecordPO>();
		SQL.databaseQuery(sql);
		try {
			while (SQL.rs.next()) {
				String storageItem_ID = SQL.rs.getString("StorageItem_ID");
				Date date = SQL.rs.getDate("入库日期");
				String destination = SQL.rs.getString("目的地");
				String location = SQL.rs.getString("位置");
				RecordPO recordPO = new RecordPO(storageItem_ID, date, destination, district, location);
				list.add(recordPO);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
		
	}

	@Override
	public ArrayList<RecordPO> getInWareHouseDocPO_Fly(String storageID) throws RemoteException {
//		String sql = "SELECT * FROM 仓库存储货物 WHERE 区='航运区'&&仓库ID='" + storageID + "';";
//		ArrayList<RecordPO> list = new ArrayList<RecordPO>();
//		SQL.databaseQuery(sql);
//		try {
//			while (SQL.rs.next()) {
//				String storageItem_ID = SQL.rs.getString("StorageItem_ID");
//				Date date = SQL.rs.getDate("入库日期");
//				String destination = SQL.rs.getString("目的地");
//				String location = SQL.rs.getString("位置");
//				RecordPO recordPO = new RecordPO(storageItem_ID, date, destination, "航运区", location);
//				list.add(recordPO);
//			}
//			return list;
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return list;
		
		return getStorageItems(storageID, 0);
	}

	@Override
	public ArrayList<RecordPO> getInWareHouseDocPO_Train(String storageID) throws RemoteException {
		return getStorageItems(storageID, 1);
//		String sql = "SELECT * FROM 仓库存储货物 WHERE 区='货运区'&&仓库ID='" + storageID + "';";
//		ArrayList<RecordPO> list = new ArrayList<RecordPO>();
//		SQL.databaseQuery(sql);
//		try {
//			while (SQL.rs.next()) {
//				String storageItem_ID = SQL.rs.getString("StorageItem_ID");
//				Date date = SQL.rs.getDate("入库日期");
//				String destination = SQL.rs.getString("目的地");
//				String location = SQL.rs.getString("位置");
//				RecordPO recordPO = new RecordPO(storageItem_ID, date, destination, "货运区", location);
//				list.add(recordPO);
//			}
//			return list;
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		return list;
	}

	@Override
	public ArrayList<RecordPO> getInWareHouseDocPO_Car(String storageID) throws RemoteException {
		return getStorageItems(storageID, 2);
//		String sql = "SELECT * FROM 仓库存储货物 WHERE 区='汽运区'&&仓库ID='" + storageID + "';";
//		ArrayList<RecordPO> list = new ArrayList<RecordPO>();
//		SQL.databaseQuery(sql);
//		try {
//			while (SQL.rs.next()) {
//				String storageItem_ID = SQL.rs.getString("StorageItem_ID");
//				Date date = SQL.rs.getDate("入库日期");
//				String destination = SQL.rs.getString("目的地");
//				String location = SQL.rs.getString("位置");
//				RecordPO recordPO = new RecordPO(storageItem_ID, date, destination, "汽运区", location);
//				list.add(recordPO);
//			}
//			return list;
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return list;
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

		String sql = "";
		String iD = out.getOutWareHouseDocID();
		String storageID = out.getStorageID();
		ArrayList<OutRecord> list = out.getOutRecords();
		OutRecord lineItem = list.get(0);
		Date outDate = out.getOutDate();
		String transferPattern = out.getTransferPattern();
		sql = "INSERT INTO 出库单(ID,出库日期,装运形式,仓库ID) VALUES('" + iD + "','" + Time.toDaysTime(outDate) + "','"
				+ transferPattern + "','" + storageID + "');";
		SQL.databaseUpdate(sql);
		for (OutRecord temp : list) {
			sql = "INSERT INTO 出库items VALUES('" + temp.getItemID() + "','" + temp.getDestination() + "','" + storageID
					+ "');";

			SQL.databaseUpdate(sql);
		}

		SQL.closeDatabase();

	}

	public static void main(String[] args) throws RemoteException {
		StorageDataServiceImpl serviceImpl = new StorageDataServiceImpl();
		// for (int i = 0; i < 5; ++i)
		// System.out.println(serviceImpl.getValidLocation("001000", "航运区"));
		ArrayList<InWareHouseDocLineItem> list = new ArrayList<InWareHouseDocLineItem>();
		list.add(new InWareHouseDocLineItem("0025010010", new Date(), "efjekjfewf", "航运区", "000000"));
		InWareHouseDocPO po = new InWareHouseDocPO("08000002", "001000", list);

		serviceImpl.updateInWareHouseDoc(po);
		return;

	}

	/**
	 * 这个方法用来保存入库单文件，但此时并未对仓库进行事实上的变动
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
		sql = "INSERT INTO 入库单(ID,入库日期,仓库ID) VALUES('" + iD + "','" + Time.toDaysTime(inDate) + "','" + storageID
				+ "');";
		SQL.databaseUpdate(sql);
		for (InWareHouseDocLineItem temp : list) {
			sql = "INSERT INTO 入库items VALUES('" + temp.getSendDocID() + "','" + temp.getDestination() + "','"
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
		String sql = "truncate table 仓库存储货物;";
		SQL.databaseUpdate(sql);
		SQL.closeDatabase();
		System.out.println("仓库已清空");

	}

	/**
	 * 往仓库里加东西，会修改仓库
	 * 
	 * @param recordPO
	 * @throws RemoteException
	 */
	@Override
	public void addNewStorageItem(RecordPO recordPO) throws RemoteException {
		String date = Time.toDaysTime(recordPO.getDate());
		String distriction = recordPO.getDistrict();
		String storageID = recordPO.getStorageID();
		String sql = "UPDATE 仓库存储货物 SET StorageItem_ID='" + recordPO.getItemID() + "',入库日期='" + date + "',目的地='"
				+ recordPO.getDestination() + "' WHERE StorageItem_ID IS NULL && 区='" + distriction + "'&&仓库ID='"
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
	 * 增加一张入库单
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
	// String sql = "INSERT INTO 入库单 VALUES(" + iD + "," + Time.toDaysTime(date)
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
	 * (non-Javadoc) 为总经理返回未审批的入库单列表 未经测试
	 * 
	 * @see edu.nju.dataservice.storagedataservice.StorageDataService#
	 * getInWarehouseDoc()
	 */
	@Override
	public ArrayList<InWareHouseDocPO> getInWarehouseDoc() throws RemoteException {
		ArrayList<InWareHouseDocPO> list = new ArrayList<InWareHouseDocPO>();
		String sql = "SELECT ID,入库日期,仓库ID,快递编号,目的地,位置,区 FROM 入库单,入库items WHERE 已审批='0'&&入库单.ID=入库items.入库单编号 ORDER BY ID;";
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
		ArrayList<String> district = new ArrayList<String>();
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
			System.out.println("未审批入库单读取错误");
			e.printStackTrace();
		}
		int j = 0;
		currinWareHouseDoc_ID = "";
		String currStorage_ID = "";
		for (int i = 0; i < storageIDs.size(); ++i, ++j) {
			if (!iDs.get(i).equals(currinWareHouseDoc_ID)) {
				if (j != 0)
					list.add(element);
				element = new InWareHouseDocPO(iDs.get(i), storageIDs.get(i), new ArrayList<InWareHouseDocLineItem>());
				currinWareHouseDoc_ID = iDs.get(i);

			}
			InWareHouseDocLineItem lineItem = new InWareHouseDocLineItem(SendDocID.get(i), dates.get(i),
					destination.get(i), district.get(i), location.get(i));
			element.listAppend(lineItem);

		}
		return list;
	}

	/**
	 * 获得当前入库单编号
	 * 
	 * @return
	 * @throws RemoteException
	 */
	@Override
	public String getCurrInWare_ID() throws RemoteException {
		String sql = "SELECT currID from currid where Name='入库单';";
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
		sql = "UPDATE currid SET currID='" + newCurrID + "' WHERE Name='入库单';";
		SQL.databaseUpdate(sql);
		SQL.closeDatabase();
		return currID;
	}

	/**
	 * 对被入库单占用的仓库位置进行标记，已经测试成功
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
			sql = "UPDATE 仓库存储货物 SET 被入库单占用=" + 1 + " WHERE 仓库ID='" + storageId + "'&&位置='" + location + "';";
			SQL.databaseUpdate(sql);
		}
		SQL.closeDatabase();

	}

	@Override
	public StorageLocation getValidLocation(String sID, String distriction) throws RemoteException {
		System.out.println("sID:" + sID + ";distriction:" + distriction);
		StorageLocation storageLocation = null;
		String location = null;
		String sql = "SELECT 位置 FROM 仓库存储货物 WHERE StorageItem_ID IS NULL &&仓库ID='" + sID + "'&&被入库单占用!=1&&区='"
				+ distriction + "'LIMIT 1;";
		SQL.databaseQuery(sql);
		try {
			if (SQL.rs.next()) {
				location = SQL.rs.getString("位置");

				storageLocation = new StorageLocation(sID, location);

			}

			else {
				System.out.println("没有位置");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sql = "UPDATE 仓库存储货物 SET 被入库单占用=1 WHERE 仓库ID='" + sID + "' && 位置='" + location + "';";
		SQL.databaseUpdate(sql);
		SQL.closeDatabase();

		return storageLocation;
	}

	/**
	 * 未经测试
	 * 
	 * @param in
	 * @throws RemoteException
	 */
	@Override
	public void saveInWareHouseDoc(InWareHouseDocPO in) throws RemoteException {
		ArrayList<InWareHouseDocLineItem> list = in.getList();
		String sql = "";
		sql = "UPDATE 入库单 SET 已审批='1' WHERE ID= '" + in.getID() + "';";
		SQL.databaseUpdate(sql);
		for (InWareHouseDocLineItem temp : list) {
			sql = "UPDATE 仓库存储货物 SET StorageItem_ID='" + temp.getSendDocID() + "',入库日期='"
					+ Time.toDaysTime(temp.getDate()) + "',目的地='" + temp.getDestination() + "' WHERE 仓库ID='"
					+ in.getStorageID() + "'&&位置='" + temp.getLocation() + "';";
			SQL.databaseUpdate(sql);
		}

		SQL.closeDatabase();

	}

	@Override
	public String getCurrOutWare_ID() throws RemoteException {
		String sql = "SELECT currID from currid where Name='出库单';";
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
		sql = "UPDATE currid SET currID='" + newCurrID + "' WHERE Name='出库单';";
		SQL.databaseUpdate(sql);
		SQL.closeDatabase();
		return currID;

	}

}
