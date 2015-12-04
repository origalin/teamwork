package edu.nju.data.transferDataServiceImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import edu.nju.data.database.SQL;
import edu.nju.dataservice.transformdataservice.TransferDataService;
import edu.nju.po.HistoryTimePO;
import edu.nju.po.OverDocPO;
import edu.nju.po.TransferDocPO;
import edu.nju.po.YArrivalDocPO;
import edu.nju.po.YDeliverDocPO;
import edu.nju.po.YLoadDocPO;
import edu.nju.po.ZArrivalDocPO;
import edu.nju.po.ZLoadDocPO;
import edu.nju.tools.StringTools;
import edu.nju.tools.Time;

public class TransferDataServiceImpl extends UnicastRemoteObject  implements TransferDataService{
	String institutionID;
	public TransferDataServiceImpl()throws RemoteException {
		// TODO Auto-generated constructor stub
		
	}
	public void setInstitutionID(String institutionID) {
		this.institutionID = institutionID;
	}
	@Override
	public void saveTransferDocPO(TransferDocPO po) {
		// TODO Auto-generated method stub
		String ID;
		Date date;
		String planeNum;
		String TrainNum;
		String CarNum;
		String tranceID;
		String corriage;
		String container;
		String from;
		String targetCity;
		String itemIDs;
		double price;
		int checked;
		int paid;
		ID = po.getID();
		date = po.getDate();
		planeNum = po.getPlaneNum();
		TrainNum = po.getTrainNum();
		CarNum = po.getCarNum();
		tranceID = po.getTranceID();
		corriage = po.getCorriage();
		container = po.getContainer();
		from = po.getFrom();
		targetCity = po.getTargetCity();
		itemIDs = StringTools.toAString(po.getItemIDs());
		price = po.getPrice();
		if (po.isPaid()) {
			paid = 1;
		} else {
			paid = 0;
		}
		if (po.isChecked()) {
			checked = 1;
		} else {
			checked = 0;
		}

		String str = "replace into TransferID(ID,Date,PlaneNum,TrainNum,CarNum,tranceID,corriage,container,from,targetCity,itemIDs,price,checked,paid) "
		+ "values('"+ID+"','"+date+"','"+planeNum+"','"+TrainNum+"','"+CarNum+"',"
		+ "'"+tranceID+"','"+corriage+"','"+container+"','"+from+"','"+targetCity+"',"
		+ "'"+itemIDs+"','"+price+"','"+checked+"','"+paid+"');";
		SQL.databaseUpdate(str);
		SQL.closeDatabase();
	}

	@Override
	public String getTransferSequence() {
		// TODO Auto-generated method stub
		String str = "get Sequence from SequenceTable where Kind = 'TransferDoc';";
		String ret = "";
		SQL.databaseQuery(str);
		try {
			ret =  SQL.rs.getString("Sequence");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SQL.closeDatabase();
		return ret;
	}

	@Override
	public void changeTransferSequence(String TransferSequence) {
		// TODO Auto-generated method stub
		String str = "update SequenceTable set Sequence = '"+TransferSequence+"' where Kind = 'TransferDoc'";
		SQL.databaseUpdate(str);
		SQL.closeDatabase();
	}

	@Override
	public void saveZLoadDocPO(ZLoadDocPO po) {
		// TODO Auto-generated method stub
		String ID;
		Date date;
		String tranceID;
		String targetBusinessHall;
		String CarID;
		String watcher;
		String driver;
		String itemIDs;
		double price;
		int checked;
		int paid;
		ID = po.getID();
		date = po.getDate();
		tranceID = po.getTranceID();
		targetBusinessHall = po.getTargetBusinessHall();
		CarID = po.getCarID();
		watcher = po.getWatcher();
		driver = po.getDriver();
		itemIDs = StringTools.toAString(po.getItemIDs());
		price = po.getPrice();
		if(po.isChecked()) {
			checked = 1;
		}else {
			checked = 0;
		}
		if (po.isPaid()) {
			paid = 1;
		} else {
			paid = 0;
		}
		String str = "replace into ZLoadDoc (ID,date,tranceid,targetbusinesshall,"
		+ "carid,watcher,driver,itemids,price,checked,paid) values("
		+ "'"+ID+"','"+date+"','"+tranceID+"','"+targetBusinessHall+"','"+CarID+"',"
		+ "'"+watcher+"','"+driver+"','"+itemIDs+"','"+price+"','"+checked+"',"
		+"'"+paid+"');";
		SQL.databaseUpdate(str);
		SQL.closeDatabase();
	}

	@Override
	public String getZLoadSequence() {
		// TODO Auto-generated method stub
		String str = "get Sequence from SequenceTable where Kind = 'ZLoadDoc';";
		String ret = "";
		SQL.databaseQuery(str);
		try {
			ret =  SQL.rs.getString("Sequence");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SQL.closeDatabase();
		return ret;
	}

	@Override
	public void changeZLoadSequence(String ZLoadSequence) {
		// TODO Auto-generated method stub
		String str = "update SequenceTable set Sequence = '"+ZLoadSequence+"' where Kind = 'ZLoadDoc'";
		SQL.databaseUpdate(str);
		SQL.closeDatabase();
	}

	@Override
	public void saveZArrivalDocPO(ZArrivalDocPO po) {
		// TODO Auto-generated method stub
		String ID;
		Date date;
		String fromID;
		String from;
		String itemAndState;
		int checked;
		ID = po.getID();
		date = po.getDate();
		fromID = po.getfromID();
		from = po.getFrom();
		String[][] strings = po.getItemAndState();
		String[] strings2 = new String[strings.length*2];
		for(int i = 0;i<strings2.length;i++) {
			if(i%2==0) {
				strings2[i] = strings[i/2][0];
			}else {
				strings2[i] = strings[i/2][1];
			}
		}
		itemAndState = StringTools.toAString(strings2);
		if(po.isChecked()) {
			checked = 1;
		}else {
			checked = 0;
		}
		String str = "replace into ZArricalDoc (ID,date,fromID,from,itemandstate,checked) values("
		+ "'"+ID+"','"+date+"','"+fromID+"','"+from+"','"+itemAndState+"',"
		+ "'"+checked+"');";
		SQL.databaseUpdate(str);
		SQL.closeDatabase();
	}

	@Override
	public String getZArrivalSequence() {
		// TODO Auto-generated method stub
		String str = "get Sequence from SequenceTable where Kind = 'ZArrivalDoc';";
		String ret = "";
		SQL.databaseQuery(str);
		try {
			ret =  SQL.rs.getString("Sequence");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SQL.closeDatabase();
		return ret;
	}

	@Override
	public void changeZArrivalSequence(String ZArrivalSequence) {
		// TODO Auto-generated method stub
		String str = "update SequenceTable set Sequence = '"+ZArrivalSequence+"' where Kind = 'ZArrivalDoc'";
		SQL.databaseUpdate(str);
		SQL.closeDatabase();
	}

	@Override
	public void saveYArrivalDocPO(YArrivalDocPO po) {
		// TODO Auto-generated method stub
		String ID;
		Date date;
		String transferDocID;
		String from;
		String itemAndState;
		int checked;
		ID = po.getID();
		date = po.getDate();
		transferDocID = po.getTransferDocID();
		from = po.getFrom();
		String[][] strings = po.getItemAndState();
		String[] strings2 = new String[strings.length*2];
		for(int i = 0;i<strings2.length;i++) {
			if(i%2==0) {
				strings2[i] = strings[i/2][0];
			}else {
				strings2[i] = strings[i/2][1];
			}
		}
		itemAndState = StringTools.toAString(strings2);
		if(po.isChecked()) {
			checked = 1;
		}else {
			checked = 0;
		}
		String str = "replace into YArricalDoc (ID,date,transferDocID,from,itemandstate,checked) values("
		+ "'"+ID+"','"+date+"','"+transferDocID+"','"+from+"','"+itemAndState+"',"
		+ "'"+checked+"');";
		SQL.databaseUpdate(str);
		SQL.closeDatabase();
	}

	@Override
	public String getYArrivalSequence() {
		// TODO Auto-generated method stub
		String str = "get Sequence from SequenceTable where Kind = 'YArrivalDoc';";
		String ret = "";
		SQL.databaseQuery(str);
		try {
			ret =  SQL.rs.getString("Sequence");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SQL.closeDatabase();
		return ret;
	}

	@Override
	public void changeYArrivalSequence(String YArrivalSequence) {
		// TODO Auto-generated method stub
		String str = "update SequenceTable set Sequence = '"+YArrivalSequence+"' where Kind = 'YArrivalDoc'";
		SQL.databaseUpdate(str);
		SQL.closeDatabase();
	}

	@Override
	public void saveYDeliverDocPO(YDeliverDocPO po) {
		// TODO Auto-generated method stub
		String ID;
		Date date;
		String courier;
		String itemIDs;
		int checked;
		ID = po.getID();
		date = po.getDate();
		courier = po.getCourier();
		itemIDs = StringTools.toAString(po.getItemIDs());
		if(po.isChecked()) {
			checked = 1;
		}else {
			checked = 0;
		}
		String str = "replace into YDeliverDoc (ID,date,courier,itemIDs,checked) values("
		+ "'"+ID+"','"+date+"','"+courier+"','"+itemIDs+"',"
		+ "'"+checked+"');";
		SQL.databaseUpdate(str);
		SQL.closeDatabase();
	}

	@Override
	public String getYDeliverSequence() {
		// TODO Auto-generated method stub
		String str = "get Sequence from SequenceTable where Kind = 'YDeliverDoc';";
		String ret = "";
		SQL.databaseQuery(str);
		try {
			ret =  SQL.rs.getString("Sequence");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SQL.closeDatabase();
		return ret;
	}

	@Override
	public void changeYDeliverSequence(String YDeliverSequence) {
		// TODO Auto-generated method stub
		String str = "update SequenceTable set Sequence = '"+YDeliverSequence+"' where Kind = 'TDeliverDoc'";
		SQL.databaseUpdate(str);
		SQL.closeDatabase();
	}

	@Override
	public void saveOverDocPO(OverDocPO po) {
		// TODO Auto-generated method stub
		String ID;
		Date date;
		String courier;
		String receiver;
		String itemIDs;
		int checked;
		ID = po.getID();
		date = po.getDate();
		courier = po.getCourier();
		receiver = StringTools.toAString(po.getReceiver());
		itemIDs = StringTools.toAString(po.getItemID());
		if(po.isChecked()) {
			checked = 1;
		}else {
			checked = 0;
		}
		String str = "replace into OverDoc (ID,date,itemIDs,receiver,courier,checked) values("
		+ "'"+ID+"','"+date+"','"+itemIDs+"','"+receiver+"','"+courier+"',"
		+ "'"+checked+"');";
		SQL.databaseUpdate(str);
		SQL.closeDatabase();
	}

	@Override
	public String getOverSequence() {
		// TODO Auto-generated method stub
		String str = "get Sequence from SequenceTable where Kind = 'OverDoc';";
		String ret = "";
		SQL.databaseQuery(str);
		try {
			ret =  SQL.rs.getString("Sequence");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SQL.closeDatabase();
		return ret;
	}

	@Override
	public void changeOverSequence(String OverSequence) {
		// TODO Auto-generated method stub
		String str = "update SequenceTable set Sequence = '"+OverSequence+"' where Kind = 'OverDoc'";
		SQL.databaseUpdate(str);
		SQL.closeDatabase();
	}
	@Override
	public TransferDocPO getTransferDocPO(String TransferDocID,boolean normal) {
		// TODO Auto-generated method stub
		String ID = null;
		Date date = null;
		String planeNum= null;
		String TrainNum= null;
		String CarNum= null;
		String tranceID= null;
		String corriage= null;
		String container= null;
		String from= null;
		String targetCity= null;
		String[] itemIDs= null;
		double price = 0;


		String str;
		if (normal) {
			str = "select * from TransferDoc where ID = '"+TransferDocID+"' and checked = '1';";
		} else {
			str = "select * from TransferDoc where ID = '"+TransferDocID+"';";
		}
	

		SQL.databaseQuery(str);
		try {
			while (SQL.rs.next()) {
				ID = SQL.rs.getString("ID");
				date = SQL.rs.getDate("date");
				planeNum = SQL.rs.getString("planeNum");
				TrainNum = SQL.rs.getString("TrainNum");
				CarNum = SQL.rs.getString("CarNum");
				tranceID = SQL.rs.getString("tranceID");
				corriage = SQL.rs.getString("corriage");
				container = SQL.rs.getString("container");
				from = SQL.rs.getString("from");
				targetCity = SQL.rs.getString("targetCity");
				itemIDs = SQL.rs.getString("itemIDs").split(" ");
				price = SQL.rs.getDouble("price");
			}
			SQL.closeDatabase();
			return new TransferDocPO(ID, date, planeNum, TrainNum, CarNum, tranceID, corriage, container, from, targetCity, itemIDs, price);
		} catch (Exception e) {
			// TODO: handle exception
		}
		SQL.closeDatabase();
		return null;
	}

	@Override
	public ZLoadDocPO getZLoadDocPO(String ZLoadDocID,boolean normal) {
		// TODO Auto-generated method stub
		String ID = null;
		Date date= null;
		String tranceID= null;
		String targetBusinessHall= null;
		String CarID= null;
		String watcher= null;
		String driver= null;
		String[] itemIDs= null;
		double price = 0;
		String str;
		if (normal) {
			 str = "select * from ZLoadDoc where ID = '"+ZLoadDocID+"' and checked = '1';";
		} else {
			 str = "select * from ZLoadDoc where ID = '"+ZLoadDocID+"';";
		}
	
		SQL.databaseQuery(str);
		try {
			while (SQL.rs.next()) {
				ID = SQL.rs.getString("ID");
				date = SQL.rs.getDate("date");
				tranceID = SQL.rs.getString("tranceID");
				targetBusinessHall = SQL.rs.getString("targetBusinessHall");
				CarID = SQL.rs.getString("CarID");
				watcher = SQL.rs.getString("watcher");
				driver = SQL.rs.getString("driver");
				itemIDs = SQL.rs.getString("itemIDs").split(" ");
				price = SQL.rs.getDouble("price");
				SQL.closeDatabase();
				return new ZLoadDocPO(ID, date, tranceID, targetBusinessHall, CarID, watcher, driver, itemIDs, price);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SQL.closeDatabase();
		return null;
	}

	@Override
	public ZArrivalDocPO getZArrivalDocPO(String ZArrivalDocID,boolean normal) {
		// TODO Auto-generated method stub
		String ID;
		Date date;
		String fromID;
		String from = null;
		String[][] itemAndState;
		String str;
		if (normal) {
			str = "select * from ZArrivalDoc where id = '"+ZArrivalDocID+"' and checked = '1';";
		} else {
			str = "select * from ZArrivalDoc where id = '"+ZArrivalDocID+"';";
		}
		SQL.databaseQuery(str);
		try {
			while (SQL.rs.next()) {
				ID = SQL.rs.getString("id");
				date = SQL.rs.getDate("date");
				fromID = SQL.rs.getString("fromid");
				String[] strings = SQL.rs.getString("itemandstate").split(" ");
				itemAndState = new String[strings.length/2][2];
				for(int i = 0;i<strings.length;i++) {
					if(i%2==0) {
						itemAndState[i/2][0] = strings[i];
					}else {
						itemAndState[i/2][1] = strings[i];
					}
				}
				SQL.closeDatabase();
				return new ZArrivalDocPO(ID, date, fromID, from, itemAndState);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SQL.closeDatabase();
		return null;
	}

	@Override
	public YArrivalDocPO getYArrivalDocPO(String YArrivalDocID,boolean normal) {
		// TODO Auto-generated method stub
		String ID;
		Date date;
		String TransferDocID;
		String from = null;
		String[][] itemAndState;
		String str;
		if (normal) {
			str = "select * from YArrivalDoc where id = '"+YArrivalDocID+"' and checked = '1';";
		} else {
			str = "select * from YArrivalDoc where id = '"+YArrivalDocID+"';";
		}
		SQL.databaseQuery(str);
		try {
			while (SQL.rs.next()) {
				ID = SQL.rs.getString("id");
				date = SQL.rs.getDate("date");
				TransferDocID = SQL.rs.getString("fromid");
				String[] strings = SQL.rs.getString("itemandstate").split(" ");
				itemAndState = new String[strings.length/2][2];
				for(int i = 0;i<strings.length;i++) {
					if(i%2==0) {
						itemAndState[i/2][0] = strings[i];
					}else {
						itemAndState[i/2][1] = strings[i];
					}
				}
				SQL.closeDatabase();
				return new YArrivalDocPO(ID, date, TransferDocID, from, itemAndState);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SQL.closeDatabase();
		return null;
	}

	@Override
	public YDeliverDocPO getYDeliverDocPO(String YDeliverDocID,boolean normal) {
		// TODO Auto-generated method stub
		String ID;
		Date date;
		String courier;
		String[] itemIDs;
		String str;
		if (normal) {
			str = "select * from YDeliverDoc where id = '"+YDeliverDocID+"' and checked = '1';";
		} else {
			str = "select * from YDeliverDoc where id = '"+YDeliverDocID+"';";
		}
		SQL.databaseQuery(str);
		try {
			while (SQL.rs.next()) {
				ID = SQL.rs.getString("id");
				date = SQL.rs.getDate("date");
				courier = SQL.rs.getString("courier");
				itemIDs =SQL.rs.getString("itemIDs").split(" ");
				SQL.closeDatabase();
				return new YDeliverDocPO(ID, date, courier, itemIDs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SQL.closeDatabase();
		return null;
	}

	@Override
	public OverDocPO getOverDocPO(String OverDocID,boolean normal) {
		// TODO Auto-generated method stub
		String ID;
		Date date;
		String[] receiver;
		String[] itemIDs;
		String courier;
		String str;
		if (normal) {
			str = "select * from OverDoc where id = '"+OverDocID+"' and checked = '1';";
		} else {
			str = "select * from OverDoc where id = '"+OverDocID+"';";
		}
		SQL.databaseQuery(str);
		try {
			while (SQL.rs.next()) {
				ID = SQL.rs.getString("id");
				date = SQL.rs.getDate("date");
				courier = SQL.rs.getString("courier");
				receiver = SQL.rs.getString("receiver").split(" ");
				itemIDs =SQL.rs.getString("itemIDs").split(" ");
				SQL.closeDatabase();
				return new OverDocPO(ID, itemIDs, receiver, date, courier);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SQL.closeDatabase();
		return null;
	}

	@Override
	public ArrayList<YDeliverDocPO> getAllYDeliverDoc() {
		// TODO Auto-generated method stub
		ArrayList<YDeliverDocPO> yDeliverDocPOs = new ArrayList<YDeliverDocPO>();
		String sql = "select ID from YDeliverDoc where checked='0';";
		SQL.databaseQuery(sql);
		try {
			while (SQL.rs.next()) {
				yDeliverDocPOs.add(getYDeliverDocPO(SQL.rs.getString("ID"),false));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		SQL.closeDatabase();
		return yDeliverDocPOs;
	}

	@Override
	public ArrayList<YArrivalDocPO> getAllYArrivalDoc() {
		// TODO Auto-generated method stub
		ArrayList<YArrivalDocPO> yArrivalDocPOs = new ArrayList<YArrivalDocPO>();
		String sql = "select ID from YArrivalDoc where checked='0';";
		SQL.databaseQuery(sql);
		try {
			while (SQL.rs.next()) {
				yArrivalDocPOs.add(getYArrivalDocPO(SQL.rs.getString("ID"),false));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		SQL.closeDatabase();
		return yArrivalDocPOs;
	}

	@Override
	public ArrayList<ZArrivalDocPO> getAllZArrivalDoc() {
		// TODO Auto-generated method stub
		ArrayList<ZArrivalDocPO> zArrivalDocPOs = new ArrayList<ZArrivalDocPO>();
		String sql = "select ID from ZArrivalDoc where checked='0';";
		SQL.databaseQuery(sql);
		try {
			while (SQL.rs.next()) {
				zArrivalDocPOs.add(getZArrivalDocPO(SQL.rs.getString("ID"),false));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		SQL.closeDatabase();
		return zArrivalDocPOs;
	}

	@Override
	public ArrayList<TransferDocPO> getAllTransferDoc() {
		// TODO Auto-generated method stub
		ArrayList<TransferDocPO> transferDocPOs = new ArrayList<TransferDocPO>();
		String sql = "select ID from TransferDoc where checked='0';";
		SQL.databaseQuery(sql);
		try {
			while (SQL.rs.next()) {
				transferDocPOs.add(getTransferDocPO(SQL.rs.getString("ID"),false));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		SQL.closeDatabase();
		return transferDocPOs;
	}

	@Override
	public ArrayList<YLoadDocPO> getAllYLoadDoc() {
		// TODO Auto-generated method stub
		ArrayList<YLoadDocPO> yLoadDocPOs = new ArrayList<YLoadDocPO>();
		String sql = "select ID from YLoadDoc where checked='0';";
		SQL.databaseQuery(sql);
		try {
			while (SQL.rs.next()) {
				yLoadDocPOs.add(getYLoadDocPO(SQL.rs.getString("ID"),false));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		SQL.closeDatabase();
		return yLoadDocPOs;
	}

	@Override
	public ArrayList<ZLoadDocPO> getAllZloadDoc() {
		// TODO Auto-generated method stub
		ArrayList<ZLoadDocPO> zLoadDocPOs = new ArrayList<ZLoadDocPO>();
		String sql = "select ID from ZLoadDoc where checked='0';";
		SQL.databaseQuery(sql);
		try {
			while (SQL.rs.next()) {
				zLoadDocPOs.add(getZLoadDocPO(SQL.rs.getString("ID"),false));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		SQL.closeDatabase();
		return zLoadDocPOs;
	}

	@Override
	public ArrayList<OverDocPO> getAllOverDoc() {
		// TODO Auto-generated method stub
		ArrayList<OverDocPO> overDocPOs = new ArrayList<OverDocPO>();
		String sql = "select ID from YLoadDoc where checked='0';";
		SQL.databaseQuery(sql);
		try {
			while (SQL.rs.next()) {
				overDocPOs.add(getOverDocPO(SQL.rs.getString("ID"),false));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		SQL.closeDatabase();
		return overDocPOs;
	}

	@Override
	public String getTransferID() {
		// TODO Auto-generated method stub
		String str = "get Sequence from SequenceTable where Kind = 'TransferID';";
		String ret = "";
		SQL.databaseQuery(str);
		try {
			ret =  SQL.rs.getString("Sequence");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SQL.closeDatabase();
		return ret;
	}

	@Override
	public String getTransferID_Plain() {
		// TODO Auto-generated method stub
		String str = "get Sequence from SequenceTable where Kind = 'TransferID_Plain';";
		String ret = "";
		SQL.databaseQuery(str);
		try {
			ret =  SQL.rs.getString("Sequence");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SQL.closeDatabase();
		return ret;
	}

	@Override
	public String getTransferID_Train() {
		// TODO Auto-generated method stub
		String str = "get Sequence from SequenceTable where Kind = 'TransferID_Train';";
		String ret = "";
		SQL.databaseQuery(str);
		try {
			ret =  SQL.rs.getString("Sequence");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SQL.closeDatabase();
		return ret;
	}

	@Override
	public void changeTransferID(String transferDocID) {
		// TODO Auto-generated method stub
		String str = "update SequenceTable set Sequence = '"+transferDocID+"' where Kind = 'TransferID'";
		SQL.databaseUpdate(str);
		SQL.closeDatabase();
	}

	@Override
	public void changeTransferID_Plain(String transferDocID) {
		// TODO Auto-generated method stub
		String str = "update SequenceTable set Sequence = '"+transferDocID+"' where Kind = 'TransferID_Plain'";
		SQL.databaseUpdate(str);
		SQL.closeDatabase();
	}

	@Override
	public void changeTransferID_Train(String transferDocID) {
		// TODO Auto-generated method stub
		String str = "update SequenceTable set Sequence = '"+transferDocID+"' where Kind = 'TransferID_Train'";
		SQL.databaseUpdate(str);
		SQL.closeDatabase();
	}
	@Override
	public ArrayList<TransferDocPO> getunPaidTransferDocPO() {
		// TODO Auto-generated method stub
		ArrayList<TransferDocPO> transferDocPOs = new ArrayList<TransferDocPO>();
		String sql = "select ID from TransferDoc where paid='0';";
		SQL.databaseQuery(sql);
		try {
			while (SQL.rs.next()) {
				transferDocPOs.add(getTransferDocPO(SQL.rs.getString("ID"),true));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		SQL.closeDatabase();
		return transferDocPOs;
	}
	@Override
	public ArrayList<YLoadDocPO> getunPaidYLoadDocPO() {
		// TODO Auto-generated method stub
		ArrayList<YLoadDocPO> yLoadDocPOs = new ArrayList<YLoadDocPO>();
		String sql = "select ID from YLoadDoc where paid='0';";
		SQL.databaseQuery(sql);
		try {
			while (SQL.rs.next()) {
				yLoadDocPOs.add(getYLoadDocPO(SQL.rs.getString("ID"),true));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		SQL.closeDatabase();
		return yLoadDocPOs;
	}
	@Override
	public ArrayList<ZLoadDocPO> getunPaidZLoadDocPO() {
		// TODO Auto-generated method stub
		ArrayList<ZLoadDocPO> zLoadDocPOs = new ArrayList<ZLoadDocPO>();
		String sql = "select ID from ZLoadDoc where paid='0';";
		SQL.databaseQuery(sql);
		try {
			while (SQL.rs.next()) {
				zLoadDocPOs.add(getZLoadDocPO(SQL.rs.getString("ID"),true));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		SQL.closeDatabase();
		return zLoadDocPOs;
	}
	@Override
	public void saveYLoadDocPO(YLoadDocPO po) {
		// TODO Auto-generated method stub
		String ID;
		Date date;
		String tranceID;
		String target;
		String CarID;
		String watcher;
		String driver;
		String itemIDs;
		double price;
		int checked;
		int paid;
		ID = po.getID();
		date = po.getDate();
		tranceID = po.getTranceID();
		target = po.getTarget();
		CarID = po.getCarID();
		watcher = po.getWatcher();
		driver = po.getDriver();
		itemIDs = StringTools.toAString(po.getItemIDs());
		price = po.getPrice();
		if(po.isChecked()) {
			checked = 1;
		}else {
			checked = 0;
		}
		if (po.isPaid()) {
			paid = 1;
		} else {
			paid = 0;
		}
		String str = "replace into ZLoadDoc (ID,date,tranceid,targetbusinesshall,"
		+ "carid,watcher,driver,itemids,price,checked,paid) values("
		+ "'"+ID+"','"+date+"','"+tranceID+"','"+target+"','"+CarID+"',"
		+ "'"+watcher+"','"+driver+"','"+itemIDs+"','"+price+"','"+checked+"',"
		+"'"+paid+"',);";
		SQL.databaseUpdate(str);
		SQL.closeDatabase();
	}
	@Override
	public String getYLoadSequence() {
		// TODO Auto-generated method stub
		String str = "get Sequence from SequenceTable where Kind = 'TLoadDoc';";
		String ret = "";
		SQL.databaseQuery(str);
		try {
			ret =  SQL.rs.getString("Sequence");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SQL.closeDatabase();
		return ret;
	}
	@Override
	public void changeYLoadSequence(String YLoadSequence) {
		// TODO Auto-generated method stub
		String str = "update SequenceTable set Sequence = '"+YLoadSequence+"' where Kind = 'YLoadDoc'";
		SQL.databaseUpdate(str);
		SQL.closeDatabase();
	}
	@Override
	public void saveHistoryTimePO(HistoryTimePO po) {
		// TODO Auto-generated method stub
		String start;
		String end;
		int days;
		start = po.getStart();
		end = po.getEnd();
		days = po.getDays();
		String str = "insert into HistoryTime (start,end,days) values('"+start+"','"+end+"','"+days+"');";
		SQL.databaseUpdate(str);
		SQL.closeDatabase();
	}
	@Override
	public ArrayList<HistoryTimePO> getHistoryTimePO(String sCity, String rCity) {
		// TODO Auto-generated method stub
		ArrayList<HistoryTimePO> historyTimePOs = new ArrayList<HistoryTimePO>();
		String str = "select * from HistoryTime where start = '"+sCity+"' and end = '"+rCity+"';";
		String start;
		String end;
		int days;
		try {
			while (SQL.rs.next()) {
				start = SQL.rs.getString("start");
				end = SQL.rs.getString("end");
				days = SQL.rs.getInt("days");
				historyTimePOs.add(new HistoryTimePO(start, end, days));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SQL.closeDatabase();
		return historyTimePOs;
	}
	@Override
	public YLoadDocPO getYLoadDocPO(String YLoadDocID, boolean normal) {
		// TODO Auto-generated method stub
		String ID = null;
		Date date= null;
		String tranceID= null;
		String targetBusinessHall= null;
		String CarID= null;
		String watcher= null;
		String driver= null;
		String[] itemIDs= null;
		double price = 0;
		String str;
		if (normal) {
			 str = "select * from ZLoadDoc where ID = '"+YLoadDocID+"' and checked = '1';";
		} else {
			 str = "select * from ZLoadDoc where ID = '"+YLoadDocID+"';";
		}
	
		SQL.databaseQuery(str);
		try {
			while (SQL.rs.next()) {
				ID = SQL.rs.getString("ID");
				date = SQL.rs.getDate("date");
				tranceID = SQL.rs.getString("tranceID");
				targetBusinessHall = SQL.rs.getString("targetBusinessHall");
				CarID = SQL.rs.getString("CarID");
				watcher = SQL.rs.getString("watcher");
				driver = SQL.rs.getString("driver");
				itemIDs = SQL.rs.getString("itemIDs").split(" ");
				price = SQL.rs.getDouble("price");
				SQL.closeDatabase();
				return new YLoadDocPO(ID, date, tranceID, targetBusinessHall, CarID, watcher, driver, itemIDs, price);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SQL.closeDatabase();
		return null;
	}
	@Override
	public int getDriverTime_YLoad(String driverID) {
		// TODO Auto-generated method stub
		int result = 0;
		String dateStr;
		String str = "select date from YLoadDoc where driver = '"+driverID+"';";
		SQL.databaseQuery(str);
		try {
			while (SQL.rs.next()) {
				dateStr = Time.toDocTime(SQL.rs.getDate("date")).substring(4, 6);
				if(Time.toDaysTime(new Date()).substring(4, 6).equals(dateStr)) {
					result++;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	@Override
	public int getDriverTime_ZLoad(String driverID) {
		// TODO Auto-generated method stub
		int result = 0;
		String dateStr;
		String str = "select date from ZLoadDoc where driver = '"+driverID+"';";
		SQL.databaseQuery(str);
		try {
			while (SQL.rs.next()) {
				dateStr = Time.toDocTime(SQL.rs.getDate("date")).substring(4, 6);
				if(Time.toDaysTime(new Date()).substring(4, 6).equals(dateStr)) {
					result++;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	
}
