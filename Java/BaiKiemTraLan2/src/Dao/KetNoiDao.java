package Dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class KetNoiDao {
	public static Connection cn;
	public void ketnoi() throws Exception {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		System.out.println("Da xac dinh he csdl");
		cn = DriverManager.getConnection("jdbc:sqlserver://ADMIN\\DATSQL:1433;databaseName=BaiTap; user=sa; password=123");
		System.out.println("Da ket noi");
	}
}
