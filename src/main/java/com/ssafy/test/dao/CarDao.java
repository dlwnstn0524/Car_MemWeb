package com.ssafy.test.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.test.model.Car;

public interface CarDao {
	public List<Car> getCars() throws SQLException;
	public int insertCar(Car c) throws SQLException;
	public int getCarInfo(Car c) throws SQLException;
	public int deleteCar(Car c) throws SQLException;
	public Car getDetail(Car c) throws SQLException;
	public void update(Car c) throws SQLException;
}
