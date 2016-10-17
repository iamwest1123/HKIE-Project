package group3.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;

public class DBUtil {
	private static BasicDataSource ds;
	static {
		ds = new BasicDataSource();
		ds.setMaxActive(2);
		ds.setUrl(ProjectConstant.DB_URL);
		ds.setDriverClassName(ProjectConstant.DB_DRIVER_CLASSNAME);
		ds.setUsername(ProjectConstant.DB_USERNAME);
		ds.setPassword(ProjectConstant.DB_PASSWORD);
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
}
