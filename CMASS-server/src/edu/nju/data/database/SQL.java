package edu.nju.data.database;

import java.sql.*;



/**
 * @author 健
 *该类用于和数据库交互
 *使用时调用databaseQuery或者databaseUpdate方法
 *注意：调用以上两个方法获得ResultSet并根据此生成了PO之后务必调用closeDatabase方法关闭数据库连接
 */
public class SQL {
	public static int rows;
	
	public static Connection conn = null;
	public static Statement stmt = null;
	public static ResultSet rs = null;

	public static String url ="jdbc:mysql://172.26.70.231:3306/cmass";	

	public static String user = "root";
	public static String password = "1314..zJ";

	// static String sql = null;
//	public static void main(String[] args) {
//		rs=databaseQuery("select * from Products;");
//		// 执行sql语句
//		try {
//			while (SQL.rs.next()) {
//				System.out.print(rs.getString("prod_name") + " ");
//
//				System.out.println(rs.getString("prod_price") + " ");
//				System.out.println(rs.getString("vend_id") + " ");
//			}
//			closeDatabase();
//		} catch (SQLException e) {
//			System.out.println("数据查询错误");
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
			System.out.println("数据操作错误");
			e.printStackTrace();
		}

	//	closeDatabase();

		return rs;

	}

	public static int databaseUpdate(String sql) {
		loadDrive();
		linkToDatabase();

		int result=0;
		try {
			stmt = conn.createStatement();
			result=stmt.executeUpdate(sql);
//			if(result!=0)
//				System.out.println("Update Success!");
//			else
//				System.out.println("Update failed");
			// 执行sql语句
				// while(rs.next()) {
				// System.out.print(rs.getString("prod_name") + " ");
				//
				// System.out.println(rs.getString("prod_price") + " ");
				// System.out.println(rs.getString("vend_id") + " ");
				// }
		} catch (SQLException e) {
			System.out.println("数据操作错误2");
			e.printStackTrace();
		}
		// 关闭数据库
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
//			System.out.println("数据库关闭错误");
//			e.printStackTrace();
//		}
		return result;

	}

	public static void loadDrive() {
		try {
			Class.forName("com.mysql.jdbc.Driver"); // 加载mysq驱动
		} catch (ClassNotFoundException e) {
			System.out.println("驱动加载错误");
			e.printStackTrace();// 打印出错详细信息
		}
	}

	public static void linkToDatabase() {
		try {
		//	url = "jdbc:mysql://localhost/demo?user=root&password=1314..zJ&useUnicode=true&&characterEncoding=gb2312&autoReconnect = true";// 简单写法：url
																																// user=root(用户)&password=yqs2602555(密码)";
			
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			System.out.println("数据库链接错误");
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
			System.out.println("数据库关闭错误");
			e.printStackTrace();
		}
		return 0;

	}

	
}
