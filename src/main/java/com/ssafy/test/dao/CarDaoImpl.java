package com.ssafy.test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.test.model.Car;
import com.ssafy.test.util.DBUtil;

public class CarDaoImpl implements CarDao {

	private static CarDao instance = new CarDaoImpl();
	private DBUtil dbUtil = DBUtil.getInstance();
	
	public static CarDao getInstance() {
		return instance;
	}
	
	@Override
	public List<Car> getCars() {
		try {
			Connection conn = dbUtil.getConnection();
			String sql = "select * from cars";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			List<Car> list = new ArrayList<>();
			while(rs.next()) {
				list.add(new Car(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
			}
			rs.close();
			pstmt.close();
			conn.close();
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Car getDetail(Car c) {
		try {
			Connection conn = dbUtil.getConnection();
			String sql = "select * from cars where number= ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, c.getNumber());
			ResultSet rs = pstmt.executeQuery();
			Car car = null;
			while(rs.next()) {
				car = new Car(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			}
			rs.close();
			pstmt.close();
			conn.close();
			return car;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int insertCar(Car c) {
		try {
			Connection conn = dbUtil.getConnection();
			String sql = "insert into cars values (? ,? ,? ,? ,?);";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, c.getNumber());
			pstmt.setString(2, c.getModel());
			pstmt.setInt(3, Integer.parseInt(c.getPrice()));
			pstmt.setString(4, c.getBrand());
			pstmt.setString(5, c.getSize());
			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
			return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int getCarInfo(Car c) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteCar(Car c) {
		// TODO Auto-generated method stub
		try {
			Connection conn = dbUtil.getConnection();
			String sql = "delete from cars where number like ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, c.getNumber());
			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
			return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public void update(Car c) throws SQLException {
		try {
			Connection conn = dbUtil.getConnection();
			String sql = "update cars set model = ?, price=?, brand=?, size=? where number = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, c.getModel());
			pstmt.setInt(2, Integer.parseInt(c.getPrice()));
			pstmt.setString(3, c.getBrand());
			pstmt.setString(4, c.getSize());
			pstmt.setString(5, c.getNumber());
			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
