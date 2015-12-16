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
	 * ��������
	 * @param storageID
	 * @param ctrl
	 * @return
	 */
	public ArrayList<RecordPO> getStorageItems(String storageID,int ctrl){
		
		//������
		String[] sqls={"SELECT * FROM �ֿ�洢���� WHERE ��='������'&&�ֿ�ID='" + storageID + "'&&�����ռ��='1';",
			"SELECT * FROM �ֿ�洢���� WHERE ��='������'&&�ֿ�ID='" + storageID + "'&&�����ռ��='1';",
			"SELECT * FROM �ֿ�洢���� WHERE ��='������'&&�ֿ�ID='" + storageID + "'&&�����ռ��='1';"};
		String[] districts={"������","������","������"};
		String sql=sqls[ctrl];
		String district=districts[ctrl];
			
		ArrayList<RecordPO> list = new ArrayList<RecordPO>();
		SQL.databaseQuery(sql);
		try {
			while (SQL.rs.next()) {
				String storageItem_ID = SQL.rs.getString("StorageItem_ID");
				Date date = SQL.rs.getDate("�������");
				String destination = SQL.rs.getString("Ŀ�ĵ�");
				String location = SQL.rs.getString("λ��");
				
				RecordPO recordPO = new RecordPO(storageItem_ID, date, destination, district, location,storageID);
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
//		String sql = "SELECT * FROM �ֿ�洢���� WHERE ��='������'&&�ֿ�ID='" + storageID + "';";
//		ArrayList<RecordPO> list = new ArrayList<RecordPO>();
//		SQL.databaseQuery(sql);
//		try {
//			while (SQL.rs.next()) {
//				String storageItem_ID = SQL.rs.getString("StorageItem_ID");
//				Date date = SQL.rs.getDate("�������");
//				String destination = SQL.rs.getString("Ŀ�ĵ�");
//				String location = SQL.rs.getString("λ��");
//				RecordPO recordPO = new RecordPO(storageItem_ID, date, destination, "������", location);
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
//		String sql = "SELECT * FROM �ֿ�洢���� WHERE ��='������'&&�ֿ�ID='" + storageID + "';";
//		ArrayList<RecordPO> list = new ArrayList<RecordPO>();
//		SQL.databaseQuery(sql);
//		try {
//			while (SQL.rs.next()) {
//				String storageItem_ID = SQL.rs.getString("StorageItem_ID");
//				Date date = SQL.rs.getDate("�������");
//				String destination = SQL.rs.getString("Ŀ�ĵ�");
//				String location = SQL.rs.getString("λ��");
//				RecordPO recordPO = new RecordPO(storageItem_ID, date, destination, "������", location);
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
//		String sql = "SELECT * FROM �ֿ�洢���� WHERE ��='������'&&�ֿ�ID='" + storageID + "';";
//		ArrayList<RecordPO> list = new ArrayList<RecordPO>();
//		SQL.databaseQuery(sql);
//		try {
//			while (SQL.rs.next()) {
//				String storageItem_ID = SQL.rs.getString("StorageItem_ID");
//				Date date = SQL.rs.getDate("�������");
//				String destination = SQL.rs.getString("Ŀ�ĵ�");
//				String location = SQL.rs.getString("λ��");
//				RecordPO recordPO = new RecordPO(storageItem_ID, date, destination, "������", location);
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
	public ArrayList<RecordPO> getStorageItemList(int[] SendDocIDList) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	

	/**
	 * �Ѳ���
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
		sql = "INSERT INTO ���ⵥ(ID,��������,װ����ʽ,�ֿ�ID) VALUES('" + iD + "','" + Time.toDaysTime(outDate) + "','"
				+ transferPattern + "','" + storageID + "');";
		SQL.databaseUpdate(sql);
		for (OutRecord temp : list) {
			sql = "INSERT INTO ���ⵥitems VALUES('" + temp.getItemID() + "','" + temp.getDestination() + "','" + iD
					+ "');";

			SQL.databaseUpdate(sql);
		}

		SQL.closeDatabase();
		return;

	}

	public static void main(String[] args) throws RemoteException {
		StorageDataServiceImpl serviceImpl = new StorageDataServiceImpl();
		System.out.println(serviceImpl.getInWarehouseDoc());
//		serviceImpl.exportToExcel("001000");
//		RecordPO recordPO=new RecordPO("0025033965", new Date(), "�Ͼ���", "������", "000005", "001000");
//		serviceImpl.addNewStorageItem(recordPO);
		
//		serviceImpl.getValidLocation( "001000","������");
		
		
//		ArrayList<OutRecord> list = new ArrayList<OutRecord>();//���ǲ��Ը��³��ⵥ
//		OutRecord outRecord=new OutRecord("0025010250", "����", "09000001");
//		list.add(outRecord);		
//		OutWareHouseDocPO outWareHouseDocPO=new OutWareHouseDocPO("09000001", new Date(), "����", "001000", list);		
//		serviceImpl.updateOutWareHouseDoc(outWareHouseDocPO);
//		
//		ArrayList<InWareHouseDocLineItem> list=new ArrayList<InWareHouseDocLineItem>();
//		InWareHouseDocLineItem in=new InWareHouseDocLineItem("08000010", new Date(), "�Ͼ�����ϼ��", "������","");
		
		//System.out.println(serviceImpl.getStorageItems("001000",2));
		
		
//		serviceImpl.clear();
//		ArrayList<OutRecord> outRecords=new ArrayList<OutRecord>();
//		outRecords.add(new OutRecord("0025010010", "", "09000010"));
//		outRecords.add(new OutRecord("0025010011", "", "09000010"));
//		OutWareHouseDocPO outWareHouseDocPO=new OutWareHouseDocPO("09000010", new Date(), "����", "001000", outRecords);
//		serviceImpl.saveOutWareHouseDoc(outWareHouseDocPO);
//
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

	

	/* (non-Javadoc)
	 * �÷������޸ģ���ղֿⲻӦ��ֱ����ձ�Ӧ�ñ�Ǹ�λ��Ϊ�ռ���
	 * @see edu.nju.dataservice.storagedataservice.StorageDataService#clear()
	 */
	@Override
	public void clear() throws RemoteException {
		String sql = "UPDATE �ֿ�洢���� SET �����ռ�� ='0';";
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
		String sql = "UPDATE �ֿ�洢���� SET �����ռ��='1',StorageItem_ID='" + recordPO.getItemID() + "',�������='" + date + "',Ŀ�ĵ�='"
				+ recordPO.getDestination() + "' WHERE �����ռ��='0'&&����ⵥռ��='0' && ��='" + distriction + "'&&�ֿ�ID='"
				+ storageID + "' LIMIT 1;";
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
	public ArrayList<RecordPO> getOutWarehouseDoc() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc) Ϊ�ܾ�����δ��������ⵥ�б� δ������
	 * 
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
		ArrayList<String> district = new ArrayList<String>();
		try {
			while (SQL.rs.next()) {
				iDs.add(SQL.rs.getString("ID"));
				dates.add(SQL.rs.getDate("�������"));
				storageIDs.add(SQL.rs.getString("�ֿ�ID"));
				SendDocID.add(SQL.rs.getString("��ݱ��"));
				destination.add(SQL.rs.getString("Ŀ�ĵ�"));
				location.add(SQL.rs.getString("λ��"));
				district.add(SQL.rs.getString("��"));
			}
		} catch (SQLException e) {
			System.out.println("δ������ⵥ��ȡ����");
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
		
		list.add(element);
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
		
		return getCurrDoc_ID(0);
	}
	
	public String getCurrDoc_ID(int ctrl) throws RemoteException{
		String[] sqls={ "SELECT currID from currid where Name='��ⵥ';", "SELECT currID from currid where Name='���ⵥ';"};
		String sql=sqls[ctrl];
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
		int i=-1;
		String sql="SELECT * FROM �ֿ�洢���� WHERE �ֿ�ID='"+sID+"'&&��='"+distriction+"'&&(�����ռ��='1'||����ⵥռ��='1');";
		SQL.databaseQuery(sql);
		try {
			SQL.rs.last();
			i=SQL.rs.getRow();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		if(i>=200)
			JOptionPane.showMessageDialog(null, distriction+" ���澯�����������п�������");
		
		
		System.out.println("sID:" + sID + ";distriction:" + distriction);
		StorageLocation storageLocation = null;
		String location = null;
		sql = "SELECT λ�� FROM �ֿ�洢���� WHERE �����ռ��='"+'0'+"'&&�ֿ�ID='" + sID + "'&&����ⵥռ��!=1&&��='"
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
					+ Time.toDaysTime(temp.getDate()) + "',Ŀ�ĵ�='" + temp.getDestination() + "',�����ռ��='"+0+"' WHERE �ֿ�ID='"
					+ in.getStorageID() + "'&&λ��='" + temp.getLocation() + "';";
			SQL.databaseUpdate(sql);
		}

		SQL.closeDatabase();

	}

	/* (non-Javadoc)
	 * δ������
	 * @see edu.nju.dataservice.storagedataservice.StorageDataService#getCurrOutWare_ID()
	 */
	@Override
	public String getCurrOutWare_ID() throws RemoteException {
		return getCurrDoc_ID(1);

	}

	/**
	 * �Ѳ���
	 * @param out
	 * @throws RemoteException
	 */
	@Override
	public void saveOutWareHouseDoc(OutWareHouseDocPO out) throws RemoteException {
		ArrayList<OutRecord> list=out.getOutRecords();
		String outWareHouseDocID=out.getOutWareHouseDocID();
		String sql = "UPDATE ���ⵥ SET ������='1' WHERE ID= '" + outWareHouseDocID + "';";
		SQL.databaseUpdate(sql);
		
		for(OutRecord temp:list){
			sql="UPDATE �ֿ�洢���� SET �����ռ��='"+0+"',����ⵥռ��='0' WHERE StorageItem_ID='"+temp.getItemID()+"';";
			SQL.databaseUpdate(sql);
		}
		return;
	}

	/**
	 * �ȴ����������ɲ���
	 * @return
	 * @throws RemoteException
	 */
	@Override
	public ArrayList<OutWareHouseDocPO> getOutWareHouseDoc_unchecked() throws RemoteException {
		ArrayList<OutWareHouseDocPO> list = new ArrayList<OutWareHouseDocPO>();
		String sql = "SELECT ID,��������,װ����ʽ,�ֿ�ID,��ݱ��,Ŀ�ĵ� FROM ���ⵥ,����items WHERE ������='0'&&���ⵥ.ID=����items.���ⵥID ORDER BY ���ⵥ.ID;";
		SQL.databaseQuery(sql);
		OutWareHouseDocPO element = null;
		String curroutWareHouseDoc_ID = "";
		String outWareHouseDoc_ID = "";

		ArrayList<String> iDs = new ArrayList<String>();
		ArrayList<Date> dates = new ArrayList<Date>();
		ArrayList<String> transferPattern=new ArrayList<String>();
		ArrayList<String> storageIDs = new ArrayList<String>();
		ArrayList<String> SendDocID = new ArrayList<String>();
		ArrayList<String> destination = new ArrayList<String>();
		
		try {
			while (SQL.rs.next()) {
				iDs.add(SQL.rs.getString("ID"));
				dates.add(SQL.rs.getDate("��������"));
				transferPattern.add(SQL.rs.getString("װ����ʽ"));
				storageIDs.add(SQL.rs.getString("�ֿ�ID"));
				SendDocID.add(SQL.rs.getString("��ݱ��"));
				destination.add(SQL.rs.getString("Ŀ�ĵ�"));
				
			}
		} catch (SQLException e) {
			System.out.println("δ�������ⵥ��ȡ����");
			e.printStackTrace();
		}
		//���ݿ��ȡ���
		//�������
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
		list.add(element);
		return list;
	}
	@Override
	public void storageModify(String to,String storageID) throws RemoteException {
		
			assert(to.equals("������")||to.equals("������")||to.equals("������")):"����Ŀ���������";
			int i1=-1,i2=-1;
			String sql="SELECT * FROM �ֿ�洢���� WHERE �ֿ�ID='"+storageID+"'&&��='"+to+"';";
			SQL.databaseQuery(sql);
			try {
				SQL.rs.last();
				i1=SQL.rs.getRow();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			
			sql="UPDATE �ֿ�洢���� SET ��='"+to+"' WHERE ��='������'&&����ⵥռ��='0'&&�����ռ��='0'&&�ֿ�ID='"+storageID+"' LIMIT 10;";//��10Ϊ��λ������������ʱ���ֵ�������
			SQL.databaseUpdate(sql);
			
			sql="SELECT * FROM �ֿ�洢���� WHERE �ֿ�ID='"+storageID+"'&&��='"+to+"';";
			SQL.databaseQuery(sql);
			try {
				SQL.rs.last();
				i2=SQL.rs.getRow();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			SQL.closeDatabase();
			assert(i2==(i1+10)):"��������ʧ��";
			return;
		
	

}

	@Override
	public void exportToExcel(String storageID) throws RemoteException {
		String sql="grant file on *.* to root@114.212.42.72;";

		SQL.databaseQuery(sql);
		sql="select * from �ֿ�洢����  into outfile  'D:/1212.xls'";
		SQL.databaseQuery(sql);
		SQL.closeDatabase();
		
	}}
