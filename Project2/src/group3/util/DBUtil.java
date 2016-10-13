package group3.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;

public class DBUtil {
	private static final String username = "candy001";
	private static final String password = "123";
	private static final String dbUrl = "jdbc:oracle:thin:@ITA-031-W7.corp.oocl.com:1521:XE";
	private static final String driver_classname = "oracle.jdbc.OracleDriver";
	private static BasicDataSource ds;
	static {
		ds = new BasicDataSource();
		ds.setMaxActive(2);
		ds.setUrl(dbUrl);
		ds.setDriverClassName(driver_classname);
		ds.setUsername(username);
		ds.setPassword(password);
	}
	
	public static Connection createConnection() {
		Connection con = null;
		try {
			con=ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	public static void free(Connection con, PreparedStatement pst, ResultSet rs) {
		if (rs!=null)
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if (pst!=null)
			try {
				pst.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if (con!=null)
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public static void main(String[] args) {
		Connection con1 = DBUtil.createConnection();
		System.out.println((con1!=null)?con1:"null");
		Connection con2 = DBUtil.createConnection();
		System.out.println((con2!=null)?con2:"null");
		Connection con3 = DBUtil.createConnection();
		System.out.println((con3!=null)?con3:"null");
	}
}
