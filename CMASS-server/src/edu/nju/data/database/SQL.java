package edu.nju.data.database;

import java.sql.*;

import edu.nju.presentation.mainui.Main;

/**
 * @author ��
 *�������ں����ݿ⽻��
 *ʹ��ʱ����databaseQuery����databaseUpdate����
 *ע�⣺�������������������ResultSet�����ݴ�������PO֮����ص���closeDatabase�����ر����ݿ�����
 */
public class SQL {
	public static Connection conn = null;
	public static Statement stmt = null;
	public static ResultSet rs = null;
	public static String url ="jdbc:mysql://localhost/cmass";	
	public static String user = "root";
	public static String password = "1314..zJ";

	// static String sql = null;
//	public static void main(String[] args) {
//		rs=databaseQuery("select * from Products;");
//		// ִ��sql���
//		try {
//			while (SQL.rs.next()) {
//				System.out.print(rs.getString("prod_name") + " ");
//
//				System.out.println(rs.getString("prod_price") + " ");
//				System.out.println(rs.getString("vend_id") + " ");
//			}
//			closeDatabase();
//		} catch (SQLException e) {
//			System.out.println("���ݲ�ѯ����");
//			e.printStackTrace();
//		}
//	}

	public static ResultSet databaseQuery(String sql) {

		loadDrive();
		linkToDatabase();

		try {
			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);
//			while(rs.next()){
//				System.out.println(rs.getString("his"));
//			}

		} catch (SQLException e) {
			System.out.println("���ݲ�������");
			e.printStackTrace();
		}

	//	closeDatabase();

		return rs;

	}

	public static int databaseUpdate(String sql) {

		try {
			stmt = conn.createStatement();
			sql = "UPDATE Customers set cust_name='lpt' WHERE cust_id='1310901401';";// dept���ű���deptno��deptname��age�������ֶ�
			System.out.print(stmt.executeUpdate(sql));
			;// ִ��sql���
				// while(rs.next()) {
				// System.out.print(rs.getString("prod_name") + " ");
				//
				// System.out.println(rs.getString("prod_price") + " ");
				// System.out.println(rs.getString("vend_id") + " ");
				// }
		} catch (SQLException e) {
			System.out.println("���ݲ�������");
			e.printStackTrace();
		}
		// �ر����ݿ�
//		try {
//			if (rs != null) {
//				rs.close();
//				rs = null;
//			}
//			if (stmt != null) {
//				stmt.close();
//				stmt = null;
//			}
//			if (conn != null) {
//				conn.close();
//				conn = null;
//			}
//		} catch (Exception e) {
//			System.out.println("���ݿ�رմ���");
//			e.printStackTrace();
//		}
		return 0;

	}

	public static void loadDrive() {
		try {
			Class.forName("com.mysql.jdbc.Driver"); // ����mysq����
		} catch (ClassNotFoundException e) {
			System.out.println("�������ش���");
			e.printStackTrace();// ��ӡ������ϸ��Ϣ
		}
	}

	public static void linkToDatabase() {
		try {
		//	url = "jdbc:mysql://localhost/demo?user=root&password=1314..zJ&useUnicode=true&&characterEncoding=gb2312&autoReconnect = true";// ��д����url
																																// user=root(�û�)&password=yqs2602555(����)";
			
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			System.out.println("���ݿ����Ӵ���");
			e.printStackTrace();
		}
	}

	public static int closeDatabase() {
		try {
			if (rs != null) {
				rs.close();
				rs = null;
			}
			if (stmt != null) {
				stmt.close();
				stmt = null;
			}
			if (conn != null) {
				conn.close();
				conn = null;
			}
		} catch (Exception e) {
			System.out.println("���ݿ�رմ���");
			e.printStackTrace();
		}
		return 0;

	}

	
}
