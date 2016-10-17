package group3.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import group3.dao.DishDao;
import group3.po.Dish;
import group3.util.DBUtil;

public class DishDaoImpl implements DishDao {

	@Override
	public void addDish(Dish dish) {
		String sql ="insert into dish_info values(?,DISH_INFO_SEQ.nextval,?,?,?,?,?,?)";
		Connection con = null;
		PreparedStatement pst = null;
		
		con=DBUtil.createConnection();
		try {
			pst=con.prepareStatement(sql);
			pst.setInt(1, dish.getMerchantId());
			pst.setString(2, dish.getDescription());
			pst.setDouble(3, dish.getPrice());
			pst.setString(4, dish.getDishPicUrl());
			pst.setString(5, dish.getName());
			pst.setString(6, dish.isValid());
			pst.setDouble(7, dish.getQty());
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBUtil.free(con, pst, null);
		}
	}

	@Override
	public void updateDish(Dish dish) {

		String sql ="update dish_info set MERCHANT_ID=?, DESCRIPTION=?,PRICE=?,DISH_PIC_URL=?,NAME=?,ISVALID=?,QTY=? where dish_id=?";
		Connection con = null;
		PreparedStatement pst = null;
		
		con=DBUtil.createConnection();
		try {
			pst=con.prepareStatement(sql);
			pst.setInt(1, dish.getMerchantId());
			pst.setString(2, dish.getDescription());
			pst.setDouble(3, dish.getPrice());
			pst.setString(4, dish.getDishPicUrl());
			pst.setString(5, dish.getName());
			pst.setString(6, dish.isValid());
			pst.setDouble(7, dish.getQty());
			pst.setInt(8, dish.getDishId());
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBUtil.free(con, pst, null);
		}

		
	}

	@Override
	public void deleteDish(int id) {

		

		String sql ="delete from dish_info where dish_id=?";
		Connection con = null;
		PreparedStatement pst = null;
		
		con=DBUtil.createConnection();
		try {
			pst=con.prepareStatement(sql);
			pst.setInt(1, id);
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBUtil.free(con, pst, null);
		}
		
		
		
	}


	@Override
	public Dish loadDish(int id) {
		Dish dish=null;
		String sql = "select merchant_id mid,dish_id did,description des,price p,DISH_PIC_URL pic,name name,isvalid isv,qty qty from dish_info where dish_id=?";
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		con=DBUtil.createConnection();
		try {
			pst=con.prepareStatement(sql);
			pst.setInt(1, id);
			rs=pst.executeQuery();
			if(rs.next()){
				dish = new Dish();
				
				dish.setMerchantId(rs.getInt("mid"));
				dish.setDishId(rs.getInt("did"));
				dish.setDescription(rs.getString("des"));
				dish.setPrice(rs.getDouble("p"));
				dish.setDishPicUrl(rs.getString("pic"));
				dish.setName(rs.getString("name"));
				dish.setValid(rs.getString("isv"));
				dish.setQty(rs.getDouble("qty"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBUtil.free(con, pst, null);
		}
		
		
		return dish;
	}

	@Override
	public List<Dish> findAllDish() {
		List<Dish> dishes = new ArrayList<Dish>(); 
		
		String sql = "select merchant_id mid,dish_id did,description des,price p,DISH_PIC_URL pic,name name,isvalid isv,qty qty from dish_info";
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		con=DBUtil.createConnection();
		try {
			pst=con.prepareStatement(sql);
			rs=pst.executeQuery();
			while(rs.next()){
				Dish dish = new Dish();
				
				dish.setMerchantId(rs.getInt("mid"));
				dish.setDishId(rs.getInt("did"));
				dish.setDescription(rs.getString("des"));
				dish.setPrice(rs.getDouble("p"));
				dish.setDishPicUrl(rs.getString("pic"));
				dish.setName(rs.getString("name"));
				dish.setValid(rs.getString("isv"));
				dish.setQty(rs.getDouble("qty"));
				
				dishes.add(dish);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBUtil.free(con, pst, null);
		}
		
		return dishes;
	}

	@Override
	public List<Dish> findMerchantDish(int id) {
List<Dish> dishes = new ArrayList<Dish>(); 
		
		String sql = "select merchant_id mid,dish_id did,description des,price p,DISH_PIC_URL pic,name name,isvalid isv,qty qty from dish_info where merchant_id= ?";
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		con=DBUtil.createConnection();
		try {
			pst=con.prepareStatement(sql);
			pst.setInt(1, id);
			rs=pst.executeQuery();
			while(rs.next()){
				Dish dish = new Dish();
				
				dish.setMerchantId(rs.getInt("mid"));
				dish.setDishId(rs.getInt("did"));
				dish.setDescription(rs.getString("des"));
				dish.setPrice(rs.getDouble("p"));
				dish.setDishPicUrl(rs.getString("pic"));
				dish.setName(rs.getString("name"));
				dish.setValid(rs.getString("isv"));
				dish.setQty(rs.getDouble("qty"));
				
				dishes.add(dish);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBUtil.free(con, pst, null);
		}
		
		return dishes;
	}

}
