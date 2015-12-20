package edu.nju.data.StorageDataServiceImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

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

	}

	@Override
	public void update(ArrayList<RecordPO> recordPO) throws RemoteException {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(RecordPO recordPO) throws RemoteException {
		// TODO Auto-generated method stub

	}

	/**
	 * 经过测试
	 * 
	 * @param storageID
	 * @param ctrl
	 * @return
	 */
	public ArrayList<RecordPO> getStorageItems(String storageID, int ctrl) {

		// 表驱动
		String[] sqls = { "SELECT * FROM 仓库存储货物 WHERE 区='航运区'&&仓库ID='" + storageID + "'&&被快递占用='1';",
				"SELECT * FROM 仓库存储货物 WHERE 区='货运区'&&仓库ID='" + storageID + "'&&被快递占用='1';",
				"SELECT * FROM 仓库存储货物 WHERE 区='汽运区'&&仓库ID='" + storageID + "'&&被快递占用='1';" };
		String[] districts = { "航运区", "货运区", "汽运区" };
		String sql = sqls[ctrl];
		String district = districts[ctrl];

		ArrayList<RecordPO> list = new ArrayList<RecordPO>();
		SQL.databaseQuery(sql);
		try {
			while (SQL.rs.next()) {
				String storageItem_ID = SQL.rs.getString("StorageItem_ID");
				Date date = SQL.rs.getDate("入库日期");
				String destination = SQL.rs.getString("目的地");
				String location = SQL.rs.getString("位置");

				RecordPO recordPO = new RecordPO(storageItem_ID, date, destination, district, location, storageID);
				list.add(recordPO);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		SQL.closeDatabase();
		return list;

	}

	@Override
	public ArrayList<RecordPO> getInWareHouseDocPO_Fly(String storageID) throws RemoteException {
		// String sql = "SELECT * FROM 仓库存储货物 WHERE 区='航运区'&&仓库ID='" + storageID
		// + "';";
		// ArrayList<RecordPO> list = new ArrayList<RecordPO>();
		// SQL.databaseQuery(sql);
		// try {
		// while (SQL.rs.next()) {
		// String storageItem_ID = SQL.rs.getString("StorageItem_ID");
		// Date date = SQL.rs.getDate("入库日期");
		// String destination = SQL.rs.getString("目的地");
		// String location = SQL.rs.getString("位置");
		// RecordPO recordPO = new RecordPO(storageItem_ID, date, destination,
		// "航运区", location);
		// list.add(recordPO);
		// }
		// return list;
		// } catch (SQLException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// return list;

		return getStorageItems(storageID, 0);
	}

	@Override
	public ArrayList<RecordPO> getInWareHouseDocPO_Train(String storageID) throws RemoteException {
		return getStorageItems(storageID, 1);
		// String sql = "SELECT * FROM 仓库存储货物 WHERE 区='货运区'&&仓库ID='" + storageID
		// + "';";
		// ArrayList<RecordPO> list = new ArrayList<RecordPO>();
		// SQL.databaseQuery(sql);
		// try {
		// while (SQL.rs.next()) {
		// String storageItem_ID = SQL.rs.getString("StorageItem_ID");
		// Date date = SQL.rs.getDate("入库日期");
		// String destination = SQL.rs.getString("目的地");
		// String location = SQL.rs.getString("位置");
		// RecordPO recordPO = new RecordPO(storageItem_ID, date, destination,
		// "货运区", location);
		// list.add(recordPO);
		// }
		// return list;
		// } catch (SQLException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		//
		// return list;
	}

	@Override
	public ArrayList<RecordPO> getInWareHouseDocPO_Car(String storageID) throws RemoteException {
		return getStorageItems(storageID, 2);
		// String sql = "SELECT * FROM 仓库存储货物 WHERE 区='汽运区'&&仓库ID='" + storageID
		// + "';";
		// ArrayList<RecordPO> list = new ArrayList<RecordPO>();
		// SQL.databaseQuery(sql);
		// try {
		// while (SQL.rs.next()) {
		// String storageItem_ID = SQL.rs.getString("StorageItem_ID");
		// Date date = SQL.rs.getDate("入库日期");
		// String destination = SQL.rs.getString("目的地");
		// String location = SQL.rs.getString("位置");
		// RecordPO recordPO = new RecordPO(storageItem_ID, date, destination,
		// "汽运区", location);
		// list.add(recordPO);
		// }
		// return list;
		// } catch (SQLException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// return list;
	}

	@Override
	public ArrayList<RecordPO> getStorageItemList(int[] SendDocIDList) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 已测试
	 * 
	 * @param out
	 * @throws RemoteException
	 */
	@Override
	public void updateOutWareHouseDoc(OutWareHouseDocPO out) throws RemoteException {

		String sql = "";
		String iD = out.getOutWareHouseDocID();
		String storageID = out.getStorageID();
		ArrayList<OutRecord> list = out.getOutRecords();

		Date outDate = out.getOutDate();
		String transferPattern = out.getTransferPattern();
		sql = "INSERT INTO 出库单(ID,出库日期,装运形式,仓库ID) VALUES('" + iD + "','" + Time.toDaysTime(outDate) + "','"
				+ transferPattern + "','" + storageID + "');";
		SQL.databaseUpdate(sql);
		for (OutRecord temp : list) {
			sql = "INSERT INTO 出库单items VALUES('" + temp.getItemID() + "','" + temp.getDestination() + "','" + iD
					+ "');";

			SQL.databaseUpdate(sql);
		}

		SQL.closeDatabase();
		return;

	}

	public static void main(String[] args) throws RemoteException {
		StorageDataServiceImpl serviceImpl = new StorageDataServiceImpl();
		System.out.println(serviceImpl.getCurrInWare_ID());
		// serviceImpl.exportToExcel("001000");
		// RecordPO recordPO=new RecordPO("0025033965", new Date(), "南京市",
		// "航运区", "000005", "001000");
		// serviceImpl.addNewStorageItem(recordPO);

		// serviceImpl.getValidLocation( "001000","航运区");

		// ArrayList<OutRecord> list = new ArrayList<OutRecord>();//这是测试更新出库单
		// OutRecord outRecord=new OutRecord("0025010250", "北京", "09000001");
		// list.add(outRecord);
		// OutWareHouseDocPO outWareHouseDocPO=new OutWareHouseDocPO("09000001",
		// new Date(), "航运", "001000", list);
		// serviceImpl.updateOutWareHouseDoc(outWareHouseDocPO);
		//
		// ArrayList<InWareHouseDocLineItem> list=new
		// ArrayList<InWareHouseDocLineItem>();
		// InWareHouseDocLineItem in=new InWareHouseDocLineItem("08000010", new
		// Date(), "南京市栖霞区", "航运区","");

		// System.out.println(serviceImpl.getStorageItems("001000",2));

		// serviceImpl.clear();
		// ArrayList<OutRecord> outRecords=new ArrayList<OutRecord>();
		// outRecords.add(new OutRecord("0025010010", "", "09000010"));
		// outRecords.add(new OutRecord("0025010011", "", "09000010"));
		// OutWareHouseDocPO outWareHouseDocPO=new OutWareHouseDocPO("09000010",
		// new Date(), "航运", "001000", outRecords);
		// serviceImpl.saveOutWareHouseDoc(outWareHouseDocPO);
		//
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

	/*
	 * (non-Javadoc) 该方法待修改，清空仓库不应该直接清空表，应该标记该位置为空即可
	 * 
	 * @see edu.nju.dataservice.storagedataservice.StorageDataService#clear()
	 */
	@Override
	public void clear() throws RemoteException {
		String sql = "UPDATE 仓库存储货物 SET 被快递占用 ='0';";
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
		String sql = "UPDATE 仓库存储货物 SET 被快递占用='1',StorageItem_ID='" + recordPO.getItemID() + "',入库日期='" + date
				+ "',目的地='" + recordPO.getDestination() + "' WHERE 被快递占用='0'&&被入库单占用='0' && 区='" + distriction
				+ "'&&仓库ID='" + storageID + "' LIMIT 1;";
		SQL.databaseUpdate(sql);
		SQL.closeDatabase();

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
				iDs.add(SQL.rs.getString("ID"));
				dates.add(SQL.rs.getDate("入库日期"));
				storageIDs.add(SQL.rs.getString("仓库ID"));
				SendDocID.add(SQL.rs.getString("快递编号"));
				destination.add(SQL.rs.getString("目的地"));
				location.add(SQL.rs.getString("位置"));
				district.add(SQL.rs.getString("区"));
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
		if (element != null)
			list.add(element);
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

		return getCurrDoc_ID(0);
	}

	public String getCurrDoc_ID(int ctrl) throws RemoteException {
		String[] sqls1 = { "SELECT currID from currid where Name='入库单';",
				"SELECT currID from currid where Name='出库单';" };

		String sql = sqls1[ctrl];
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
		if (ctrl == 0)
			sql = "UPDATE currid SET currID='" + newCurrID + "' WHERE Name='入库单';";
		else
			sql = "UPDATE currid SET currID='" + newCurrID + "' WHERE Name='出库单';";
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
		int i = -1;
		String sql = "SELECT * FROM 仓库存储货物 WHERE 仓库ID='" + sID + "'&&区='" + distriction + "'&&(被快递占用='1'||被入库单占用='1');";
		SQL.databaseQuery(sql);
		try {
			SQL.rs.last();
			i = SQL.rs.getRow();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		if (i >= 200)
			JOptionPane.showMessageDialog(null, distriction + " 库存告警，请立即进行库区调整");

		System.out.println("sID:" + sID + ";distriction:" + distriction);
		StorageLocation storageLocation = null;
		String location = null;
		sql = "SELECT 位置 FROM 仓库存储货物 WHERE 被快递占用='" + '0' + "'&&仓库ID='" + sID + "'&&被入库单占用!=1&&区='" + distriction
				+ "'LIMIT 1;";
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
					+ Time.toDaysTime(temp.getDate()) + "',目的地='" + temp.getDestination()
					+ "',被快递占用='1',被入库单占用='0'  WHERE 仓库ID='" + in.getStorageID() + "'&&位置='" + temp.getLocation()
					+ "';";
			SQL.databaseUpdate(sql);
		}

		SQL.closeDatabase();

	}

	/*
	 * (non-Javadoc) 未经测试
	 * 
	 * @see edu.nju.dataservice.storagedataservice.StorageDataService#
	 * getCurrOutWare_ID()
	 */
	@Override
	public String getCurrOutWare_ID() throws RemoteException {
		return getCurrDoc_ID(1);

	}

	/**
	 * 已测试
	 * 
	 * @param out
	 * @throws RemoteException
	 */
	@Override
	public void saveOutWareHouseDoc(OutWareHouseDocPO out) throws RemoteException {
		ArrayList<OutRecord> list = out.getOutRecords();
		String outWareHouseDocID = out.getOutWareHouseDocID();
		String sql = "UPDATE 出库单 SET 已审批='1' WHERE ID= '" + outWareHouseDocID + "';";
		SQL.databaseUpdate(sql);

		for (OutRecord temp : list) {
			sql = "UPDATE 仓库存储货物 SET 被快递占用='" + 0 + "',被入库单占用='0' WHERE StorageItem_ID='" + temp.getItemID() + "';";
			SQL.databaseUpdate(sql);
		}
		return;
	}

	/**
	 * 等待李芷牧方可测试
	 * 
	 * @return
	 * @throws RemoteException
	 */
	@Override
	public ArrayList<OutWareHouseDocPO> getOutWareHouseDoc_unchecked() throws RemoteException {
		ArrayList<OutWareHouseDocPO> list = new ArrayList<OutWareHouseDocPO>();
		String sql = "SELECT ID,出库日期,装运形式,仓库ID,快递编号,目的地 FROM 出库单,出库单items WHERE 已审批='0'&&出库单.ID=出库单items.出库单ID ORDER BY 出库单.ID;";
		SQL.databaseQuery(sql);
		OutWareHouseDocPO element = null;
		String curroutWareHouseDoc_ID = "";
		String outWareHouseDoc_ID = "";

		ArrayList<String> iDs = new ArrayList<String>();
		ArrayList<Date> dates = new ArrayList<Date>();
		ArrayList<String> transferPattern = new ArrayList<String>();
		ArrayList<String> storageIDs = new ArrayList<String>();
		ArrayList<String> SendDocID = new ArrayList<String>();
		ArrayList<String> destination = new ArrayList<String>();

		try {
			while (SQL.rs.next()) {
				iDs.add(SQL.rs.getString("ID"));
				dates.add(SQL.rs.getDate("出库日期"));
				transferPattern.add(SQL.rs.getString("装运形式"));
				storageIDs.add(SQL.rs.getString("仓库ID"));
				SendDocID.add(SQL.rs.getString("快递编号"));
				destination.add(SQL.rs.getString("目的地"));

			}
		} catch (SQLException e) {
			System.out.println("未审批出库单读取错误");
			e.printStackTrace();
		}
		// 数据库读取完毕
		// 下面解析
		int j = 0;
		curroutWareHouseDoc_ID = "";
		String currStorage_ID = "";
		for (int i = 0; i < storageIDs.size(); ++i, ++j) {
			if (!iDs.get(i).equals(curroutWareHouseDoc_ID)) {
				if (j != 0)
					list.add(element);
				element = new OutWareHouseDocPO(iDs.get(i), dates.get(i), transferPattern.get(i), storageIDs.get(i));
				curroutWareHouseDoc_ID = iDs.get(i);

			}
			OutRecord lineItem = new OutRecord(SendDocID.get(i), destination.get(i), curroutWareHouseDoc_ID);
			element.listAppend(lineItem);

		}
		if (element != null)
			list.add(element);
		return list;
	}

	@Override
	public void storageModify(String to, String storageID) throws RemoteException {

		assert (to.equals("航运区") || to.equals("货运区") || to.equals("汽运区")) : "调整目标区域错误";
		int i1 = -1, i2 = -1;
		String sql = "SELECT * FROM 仓库存储货物 WHERE 仓库ID='" + storageID + "'&&区='" + to + "';";
		SQL.databaseQuery(sql);
		try {
			SQL.rs.last();
			i1 = SQL.rs.getRow();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		sql = "UPDATE 仓库存储货物 SET 区='" + to + "' WHERE 区='机动区'&&被入库单占用='0'&&被快递占用='0'&&仓库ID='" + storageID
				+ "' LIMIT 10;";// 以10为单位来将机动区暂时划分到其他区
		SQL.databaseUpdate(sql);

		sql = "SELECT * FROM 仓库存储货物 WHERE 仓库ID='" + storageID + "'&&区='" + to + "';";
		SQL.databaseQuery(sql);
		try {
			SQL.rs.last();
			i2 = SQL.rs.getRow();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		SQL.closeDatabase();
		assert (i2 == (i1 + 10)) : "库区调整失败";
		return;

	}

	@Override
	public void exportToExcel(String storageID) throws RemoteException {
		String sql = "grant file on *.* to root@114.212.42.72;";

		SQL.databaseQuery(sql);
		sql = "select * from 仓库存储货物  into outfile  'D:/1212.xls'";
		SQL.databaseQuery(sql);
		SQL.closeDatabase();

	}
}
