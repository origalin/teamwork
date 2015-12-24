package edu.nju.data.LogisticsDataServiceImpl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.*;
import java.util.ArrayList;

import com.sun.crypto.provider.RSACipher;

import edu.nju.data.database.SQL;
import edu.nju.dataservice.logisticsqueryDataService.LogisticsDataService;
import edu.nju.po.PositionPO;

public class LogisticsDataServiceImpl  extends UnicastRemoteObject implements LogisticsDataService {

	 public LogisticsDataServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
//	public static void main(String[] args) {
//	 LogisticsDataServiceImpl t = null;
//	try {
//		t = new LogisticsDataServiceImpl();
//	} catch (RemoteException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
////	 t.createPosition("0002500010","������Ӫҵ��,��������ת����,�Ͼ�����ת����,��ϼ��Ӫҵ��,�ɼ���" );
//	
//	t.createPosition("0544","lingpeitang");
//	t.changePosition("0544", "lzm");
//	 }
	@Override
	public PositionPO positionQuery(String ItemID)throws RemoteException  {
		String string = "SELECT his from history where itemId=" + ItemID + ";";
		SQL.databaseQuery(string);
		String temp ="";
		String[] pos=null;
		try {
			while(SQL.rs.next()){
				temp += SQL.rs.getString("his");
			}				
		} catch (SQLException e) {
			System.out.println("������ʷ�켣��ѯ����");
			e.printStackTrace();
		}
		if(temp!="")
			pos = temp.split(",");
		else {
			return null;
		}
		ArrayList<String>  history = new ArrayList<String>();
		for(String tmp2:pos)
			history.add(tmp2);
		PositionPO positionPO=new PositionPO(ItemID, history);
		SQL.closeDatabase();
		return positionPO;
		// try {
		// BufferedReader reader=new BufferedReader(new
		// FileReader("D:\\teamwork\\CMASS-server\\data\\LogisticsData\\Position.txt"));
		// PositionPO positionPO = null;
		// String input="";
		// try {
		// while((input=reader.readLine())!=null){
		//
		// String[] s1=input.split(" ");
		// String currID=s1[0];
		// if(!currID.equals(ItemID))
		// continue;
		// String[] s2=s1[1].split(",");
		// ArrayList<String> history=new ArrayList<String>();
		// for(String str:s2){
		// history.add(str);
		// }
		// positionPO=new PositionPO(currID, history);
		// break;
		// }
		// reader.close();
		// return positionPO;
		//
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// } catch (FileNotFoundException e) {
		// // TODO Auto-generated catch block
		// System.out.println("cannot find the LogisticsData file");
		// e.printStackTrace();
		//
		// }
		// return null;
	}

	@Override
	public void changePosition(String ItemID, String pos) throws RemoteException {
		String sql="select his from history where itemId="+ItemID+";";
		SQL.databaseQuery(sql);
		String history="";
		try {
			while(SQL.rs.next()){
				history += SQL.rs.getString("his");
			}
		} catch (SQLException e) {
			System.out.println("��ѯ��ʷ�켣����");
			e.printStackTrace();
		}
		history=history+","+pos;
		sql="UPDATE history SET his='"+history+"'where itemId="+ItemID+";";
		SQL.databaseUpdate(sql);
		SQL.closeDatabase();
	}

	@Override
	public void createPosition(String Item, String pos,String destination)throws RemoteException  {
		String sql="INSERT INTO history (itemId,his,Ŀ�ĵ�) VALUES('"+Item+"','"+pos+"','"+destination+"');";
		System.out.println(sql);
		SQL.databaseUpdate(sql);
		SQL.closeDatabase();
		
		
		
//		File file = new File("D:\\teamwork\\CMASS-server\\data\\LogisticsData\\Position.txt");
//		try {
//			FileWriter writer = new FileWriter(file, true);
//			writer.write(Item + " " + pos + "\n");
//			writer.close();
//		} catch (IOException e) {
//			System.out.println("cannot find the logisticsData file");
//			e.printStackTrace();
//		}

	}

}
