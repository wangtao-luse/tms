package com.tms.member.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnectionTest {
//数据库连接地址
private static String url="jdbc:oracle:thin:@10.103.32.24:1521:onlinetest";
//用户名
private static String username= "onlinetest";
//密码
private static String password ="onlinetest438";
//驱动名称
private static String jdbcName = "oracle.jdbc.driver.OracleDriver";

private static String mysql_jdbcName = "com.mysql.cj.jdbc.Driver";
private static String mysql_url="jdbc:mysql://106.54.162.159:3308/itour?serverTimezone=UTC";
private static String mysql_username= "root";
private static String mysql_password ="root";
static {
	try {
        Class.forName(jdbcName);
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }

}
public static Connection getConnection() {
	Connection connection = null;
	try {
		connection = DriverManager.getConnection(url, username, password);		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return connection;
}
public static void main(String[] args) throws SQLException {
	Connection connection = DbConnectionTest.getConnection();
	System.out.println(connection);
	System.out.println(connection.getSchema());
}
}
