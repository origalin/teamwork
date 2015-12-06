package edu.nju.data.collectionDataServiceImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import com.sun.crypto.provider.RSACipher;

import edu.nju.data.database.SQL;
import edu.nju.dataservice.collectiondataservice.CollectionDataService;
import edu.nju.exception.DatabaseNULLException;
import edu.nju.po.CourierMoneyPO;
import edu.nju.po.CourierMoneyPO.CourierMessage;
import edu.nju.po.HistoryTimePO;
import edu.nju.po.PositionPO;
import edu.nju.po.SendDocPO;
import edu.nju.tools.Time;

public class CollectionDataServiceImpl extends UnicastRemoteObject implements CollectionDataService {
	String ID;
	String sName, sCity, sAddress, sUnit, sTelePhone, sMobilePhone;
	String rName, rCity, rAddress, rUnit, rTelePhone, rMobilePhone;
	int itemNum;
	double weight;
	double[] volume = new double[3];// Ìå»ý
	String item_type;
	int packageType;
	double sumPrice;
	// int itemID;
	int courier_Type;
	int time;
	Date date;
	int checked;

	public CollectionDataServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void saveSendDocPO(SendDocPO po) {
		// TODO Auto-generated method stub

		ID = po.getID();
		date = po.getDate();
		sName = po.getsName();
		sCity = po.getsCity();
		sAddress = po.getaAddress();
		sUnit = po.getsUnit();
		sTelePhone = po.getsTelePhone();
		sMobilePhone = po.getsMobilePhone();
		rName = po.getrName();
		rCity = po.getrCity();
		rAddress = po.getrAddress();
		rUnit = po.getrUnit();
		rTelePhone = po.getrTelePhone();
		rMobilePhone = po.getrMobilePhone();
		itemNum = po.getItemNum();
		weight = po.getWeight();
		volume = po.getVolume();
		item_type = po.getItem_type();

		if(po.isChecked()) {
			checked = 1;
		}else {
			checked = 0;
		}
		packageType = po.getPackageType();
		sumPrice = po.getSumPrice();
		courier_Type = po.getCourier_Type();
		time = po.getTime();
		String sql = "replace into sendDoc (id,sName, sAddress, sCity, sUnit, "
				+ "sTelePhone, sMobilePhone, rName, rAddress, rCity, rUnit, "
				+ "rTelePhone, rMobilePhone, itemNum, weight, lehgth,wideth,height, item_type, "
				+ "packageType, sumPrice, courier_Type, date, time, checked) " + "values('" + ID + "','" + sName + "','"
				+ sAddress + "','" + sCity + "','" + sUnit + "'," + "'" + sTelePhone + "','" + sMobilePhone + "','"
				+ rName + "','" + rAddress + "'," + "'" + rCity + "','" + rUnit + "','" + rTelePhone + "','"
				+ rMobilePhone + "','" + itemNum + "'," + "'" + weight + "','" + volume[0] + "','" + volume[1] + "','"
				+ volume[2] + "','" + item_type + "'," + "'" + packageType + "','" + sumPrice + "','" + courier_Type
				+ "','" + Time.toDaysTime(date) + "','" + time + "'," + "'" + checked + "');";
		System.out.println(sql);
		SQL.databaseUpdate(sql);
		SQL.closeDatabase();
	}

	@Override
	public String getSequence() {
		// TODO Auto-generated method stub
		String sql = "select Sequence from SequenceTable where Kind='SendDoc';";
		SQL.databaseQuery(sql);
		try {
			while (SQL.rs.next()) {
				String result = SQL.rs.getString("Sequence");
				SQL.closeDatabase();
				return result;
			}
		} catch (SQLException e) {
			System.out.println("´íÎó");
			e.printStackTrace();
		}
		SQL.closeDatabase();
		return null;
	}

	@Override
	public void changeSequence(String sequence) {
		// TODO Auto-generated method stub
		String sql = "UPDATE SequenceTable SET Sequence='" + sequence + "'where Kind='SendDoc';";
		SQL.databaseUpdate(sql);
		SQL.closeDatabase();
	}

	@Override
	public ArrayList<SendDocPO> getAllSendDoc() {
		// TODO Auto-generated method stub
		String sql = "select ID from SendDoc where checked='0';";
		SQL.databaseQuery(sql);
		ArrayList<SendDocPO> sendDocPOs = new ArrayList<SendDocPO>();
		try {
			while (SQL.rs.next()) {
				sendDocPOs.add(getSendDocPOByID(SQL.rs.getString(ID)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		SQL.closeDatabase();
		return sendDocPOs;
	}

	@Override
	public SendDocPO getSendDocPOByID(String ID) throws DatabaseNULLException {
		// TODO Auto-generated method stub
		String sql = "select * from SendDoc where ID='" + ID + "';";
		SQL.databaseQuery(sql);
		try {
			while (SQL.rs.next()) {
				sName = SQL.rs.getString("sName");
				sCity = SQL.rs.getString("sCity");
				sAddress = SQL.rs.getString("sAddress");
				sUnit = SQL.rs.getString("sUnit");
				sTelePhone = SQL.rs.getString("sTelePhone");
				sMobilePhone = SQL.rs.getString("sMobilePhone");
				rName = SQL.rs.getString("rName");
				rCity = SQL.rs.getString("rCity");
				rAddress = SQL.rs.getString("rAddress");
				rUnit = SQL.rs.getString("rUnit");
				rTelePhone = SQL.rs.getString("rTelePhone");
				rMobilePhone = SQL.rs.getString("rMobilePhone");
				itemNum = SQL.rs.getInt("itemNum");
				weight = SQL.rs.getDouble("weight");
				volume[0] = SQL.rs.getDouble("length");
				volume[1] = SQL.rs.getDouble("wideth");
				volume[2] = SQL.rs.getDouble("height");
				item_type = SQL.rs.getString("item_type");
				packageType = SQL.rs.getInt("packageType");
				sumPrice = SQL.rs.getDouble("sumPrice");
				courier_Type = SQL.rs.getInt("courier_Type");
				time = SQL.rs.getInt("time");
				date = SQL.rs.getDate("date");
				
			}
			SQL.closeDatabase();
			if (ID == null) {
				throw new DatabaseNULLException();
			}
			return new SendDocPO(ID, sName, sAddress, sCity, sUnit, sTelePhone, sMobilePhone, rName, rAddress,
					rCity, rUnit, rTelePhone, rMobilePhone, itemNum, weight, volume, item_type, packageType,
					sumPrice, courier_Type, date, time);
		} catch (SQLException e) {
			System.out.println("´íÎó");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void saveCourierMoneyPO(CourierMoneyPO po) {
		// TODO Auto-generated method stub
		String courierID;
		Double money = 0.0;
		String itemIDs = "";
		ArrayList<CourierMessage> courierList = po.getCourierList();
		for(CourierMessage cm : courierList) {
			itemIDs = "";
			courierID = cm.getCourierID();
			money = cm.getMoney();
			ArrayList<String> str = cm.getItemIDs();
			for(String s : str) {
				itemIDs+=s+" ";
			}
			String cmd = "replace into CourieMoney(courierID,money,itemIDs) values('"+courierID+"','"+money+"','"+itemIDs+"')";
			SQL.databaseUpdate(cmd);
			SQL.closeDatabase();
		}
		
	}

	@Override
	public CourierMoneyPO getCourierMoneyPO(String courierID) {
		// TODO Auto-generated method stub
		ArrayList<CourierMessage> courierMessages = new ArrayList<CourierMessage>();
		String[] itemIDs;
		double money;
		String string = "select * from CourierMoney where courierID = '"+courierID+"';";
		SQL.databaseQuery(string);
		try {
			while (SQL.rs.next()) {
				money = SQL.rs.getDouble("money");
				itemIDs = SQL.rs.getString("itemIDs").split(" ");
				ArrayList<String> items = new ArrayList<String>();
				for(String s : itemIDs) {
					items.add(s);
				}
				courierMessages.add(new CourierMoneyPO().new CourierMessage(courierID, items, money));			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CourierMoneyPO courierMoney= new CourierMoneyPO();
		courierMoney.setCourierList(courierMessages);
		SQL.closeDatabase();
		return courierMoney;
	}

}
