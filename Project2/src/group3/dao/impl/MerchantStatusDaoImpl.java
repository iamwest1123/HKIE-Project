package group3.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import group3.dao.MerchantStatusDao;
import group3.po.MerchantStatus;

public class MerchantStatusDaoImpl implements MerchantStatusDao {

	@Override
	public void addMerchantStatus(MerchantStatus ms) {
		
		String sql="insert into merchant_status(id,status) values (?,?)";		
		Connection con=null;
		PreparedStatement pst = null;
		
		con=group3.util.DBUtil.createConnection();
		try {
			pst=con.prepareStatement(sql);
			pst.setInt(1, ms.getId());
			pst.setString(2, ms.getStatus());
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			group3.util.DBUtil.free(con, pst, null);
		}
		
	}

	@Override
	public void updateMerchantStatus(MerchantStatus ms) {
		String sql = "update merchant_status set status=? where id=?";
		Connection con = null;
		PreparedStatement pst = null;
		con=group3.util.DBUtil.createConnection();
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, ms.getStatus());
			pst.setInt(2, ms.getId());
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			group3.util.DBUtil.free(con, pst, null);
		}
		
	}

	@Override
	public void deleteMerchantStatus(int id) {
		
		String sql = "delete from merchant_status where id=?";
		Connection con = null;
		PreparedStatement pst = null;

		con = group3.util.DBUtil.createConnection();
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			group3.util.DBUtil.free(con, pst, null);
		}
	}

	@Override
	public MerchantStatus findMerchantStatus(int id) {
		
		MerchantStatus ms=null;
		String sql = "select id,status from merchant_status where id=?";
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs=null;

		con = group3.util.DBUtil.createConnection();
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			rs=pst.executeQuery();
			if(rs.next()){
				ms=new MerchantStatus();
				ms.setStatus(rs.getString("status"));			
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			group3.util.DBUtil.free(con, pst, rs);
		}
		
		return ms;
	}

	@Override
	public List<MerchantStatus> findAllMerchantStatus() {
		
		List<MerchantStatus> ms=new ArrayList<MerchantStatus>();
		String sql = "select id,status from merchant_status";
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs=null;

		con = group3.util.DBUtil.createConnection();
		try {
			pst = con.prepareStatement(sql);
			rs=pst.executeQuery();
			while(rs.next()){
				MerchantStatus m=new MerchantStatus();
				m.setId(rs.getInt("id"));
				m.setStatus(rs.getString("status"));
				ms.add(m);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			group3.util.DBUtil.free(con, pst, rs);
		}
		
		return ms;
	}

}
