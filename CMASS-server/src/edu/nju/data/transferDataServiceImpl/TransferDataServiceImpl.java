package edu.nju.data.transferDataServiceImpl;

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
import sun.launcher.resources.launcher;

public class TransferDataServiceImpl   implements TransferDataService{
	String institutionID;
	public TransferDataServiceImpl(String institutionID) {
		// TODO Auto-generated constructor stub
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
		+"'"+paid+"',);";
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
	public TransferDocPO getTransferDocPO(String TransferDocID) {
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
		String str = "select * from TransferDoc where ID = '"+TransferDocID+"';";
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
	public ZLoadDocPO getZLoadDocPO(String ZLoadDocID) {
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
		String str = "select * from ZLoadDoc where ID = '"+ZLoadDocID+"'";
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
	public ZArrivalDocPO getZArrivalDocPO(String ZArrivalDocID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public YArrivalDocPO getYArrivalDocPO(String YArrivalDocID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public YDeliverDocPO getYDeliverDocPO(String YDeliverDocID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OverDocPO getOverDocPO(String OverDocID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<YDeliverDocPO> getAllYDeliverDoc() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<YArrivalDocPO> getAllYArrivalDoc() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ZArrivalDocPO> getAllZArrivalDoc() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<TransferDocPO> getAllTransferDoc() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<YLoadDocPO> getAllYLoadDoc() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ZLoadDocPO> getAllZloadDoc() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<OverDocPO> getAllOverDoc() {
		// TODO Auto-generated method stub
		return null;
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
		return null;
	}
	@Override
	public ArrayList<YLoadDocPO> getunPaidYLoadDocPO() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<ZLoadDocPO> getunPaidZLoadDocPO() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void saveYLoadDocPO(YLoadDocPO po) {
		// TODO Auto-generated method stub
		
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
		
	}
	@Override
	public ArrayList<HistoryTimePO> getHistoryTimePO(String sCity, String rCity) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
