package group3.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import group3.dao.MerchantInfoDao;
import group3.po.MerchantInfo;
import group3.util.DBUtil;

public class MerchantInfoDaoImpl implements MerchantInfoDao{
	
	/**
		ID            NOT NULL NUMBER(38)     
		1.MERCHANT_NAME          VARCHAR2(255)  
		2.AGE                    NUMBER(38)     
		3.REGISTER_TIME          DATE           
		4.ADDRESS                VARCHAR2(4000) 
		5.SHOP_PIC_URL           VARCHAR2(4000) 
		6.TEL                    NUMBER(11)     
		7.GENDER                 VARCHAR2(1)    
		8.SHOP_NAME              VARCHAR2(255) 
	 */
	
	@Override
	public void addMerchantInfo(MerchantInfo m) {
		String sql = "INSERT INTO MERCHANT_INFO values (MERCHANT_INFO_SEQ.nextval,?,?,?,?,?,?,?,?)";
		PreparedStatement pst = null;	
		Connection con = DBUtil.createConnection();
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1,m.getMerchantName());
			pst.setInt(2, m.getAge());
			pst.setDate(3, m.getRegisterTime());
			pst.setString(4,m.getAddress());
			pst.setString(5,m.getShopPicUrl());
			pst.setString(6, m.getTelNum());
			pst.setString(7, m.getGender());
			pst.setString(8, m.getShopName());
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.free(con, pst, null);
		}	
	}

	@Override
	public void updateMerchantInfo(MerchantInfo m) {
		String sql = "UPDATE MERCHANT_INFO SET SHOP_NAME = ?, SHOP_PIC_URL = ?,TEL = ?, ADDRESS = ? WHERE ID=?";
		PreparedStatement pst = null;
		Connection con = DBUtil.createConnection();
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, m.getShopName());
			pst.setString(2, m.getShopPicUrl());
			pst.setString(3, m.getTelNum());
			pst.setString(4, m.getAddress());
			pst.setInt(5, m.getId());
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.free(con, pst, null);
		}
	}

	@Override
	public void deleteMerchantInfo(int id) {
		String sql = "DELETE FROM MERCHANT_INFO WHERE ID=?";
		PreparedStatement pst = null;
		Connection con = DBUtil.createConnection();
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.free(con, pst, null);
		}		
	}

	@Override
	public MerchantInfo findMerchantInfo(int id) {
		// TODO Auto-generated method stub
		MerchantInfo mer = null;			
		String sql = "SELECT * FROM MERCHANT_INFO WHERE ID = ?";
		PreparedStatement pst = null;		
		Connection con = DBUtil.createConnection();
		ResultSet rs = null;
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			if(rs.next()) {
				mer = new MerchantInfo();
				mer.setId(rs.getInt("ID"));
				mer.setMerchantName(rs.getString("MERCHANT_NAME"));
				mer.setAge(rs.getInt("AGE"));
				mer.setRegisterTime(rs.getDate("REGISTER_TIME"));
				mer.setAddress(rs.getString("ADDRESS"));
				mer.setShopPicUrl(rs.getString("SHOP_PIC_URL"));
				mer.setTelNum(rs.getString("TEL"));
				mer.setGender(rs.getString("GENDER"));
				mer.setShopName(rs.getString("SHOP_NAME"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.free(con, pst, rs);
		}		
		return mer;
	}

	@Override
	public List<MerchantInfo> findAllMerchantInfo() {
		List<MerchantInfo> mers = new ArrayList<MerchantInfo>();
		String sql = "SELECT * FROM MERCHANT_INFO";
		PreparedStatement pst = null;
		ResultSet rs = null;
		Connection con = DBUtil.createConnection();
		try {
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()) {
				MerchantInfo mer = new MerchantInfo();
				mer.setId(rs.getInt("ID"));
				mer.setMerchantName(rs.getString("MERCHANT_NAME"));
				mer.setAge(rs.getInt("AGE"));
				mer.setRegisterTime(rs.getDate("REGISTER_TIME"));
				mer.setAddress(rs.getString("ADDRESS"));
				mer.setShopPicUrl(rs.getString("SHOP_PIC_URL"));
				mer.setTelNum(rs.getString("TEL"));
				mer.setGender(rs.getString("GENDER"));
				mer.setShopName(rs.getString("SHOP_NAME"));
				mers.add(mer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.free(con, pst, rs);
		}
		return mers;
	}

	@Override
	public MerchantInfo findMerchantInfoByName(String name) {
		MerchantInfo mer = null;			
		String sql = "SELECT * FROM MERCHANT_INFO WHERE MERCHANT_NAME = ?";
		PreparedStatement pst = null;		
		Connection con = DBUtil.createConnection();
		ResultSet rs = null;
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, name);
			rs = pst.executeQuery();
			if(rs.next()) {
				mer = new MerchantInfo();
				mer.setId(rs.getInt("ID"));
				mer.setMerchantName(rs.getString("MERCHANT_NAME"));
				mer.setAge(rs.getInt("AGE"));
				mer.setRegisterTime(rs.getDate("REGISTER_TIME"));
				mer.setAddress(rs.getString("ADDRESS"));
				mer.setShopPicUrl(rs.getString("SHOP_PIC_URL"));
				mer.setTelNum(rs.getString("TEL"));
				mer.setGender(rs.getString("GENDER"));
				mer.setShopName(rs.getString("SHOP_NAME"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.free(con, pst, rs);
		}		
		return mer;
	}

}
