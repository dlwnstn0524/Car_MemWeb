package com.ssafy.test.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.test.dao.CarDao;
import com.ssafy.test.dao.CarDaoImpl;
import com.ssafy.test.model.Car;
import com.ssafy.test.util.DBUtil;

public class CarServiceImpl implements CarService{

	
	private static CarServiceImpl instance = new CarServiceImpl();
	private CarDao carDao = CarDaoImpl.getInstance();
	
	public static CarServiceImpl getInstance() {
		return instance;
	}
	@Override
	public List<Car> getCars() throws SQLException {
		List<Car> cars = carDao.getCars();
		return cars;
	}
	@Override
	public Car getDetail(Car car) throws SQLException {
		Car c = carDao.getDetail(car);
		return c;
	}
	@Override
	public int insert(Car c) throws SQLException {
		carDao.insertCar(c);
		return 0;
	}
	@Override
	public void delete(Car c) throws SQLException {
		carDao.deleteCar(c);
	}
	@Override
	public void update(Car c) throws Exception {
		carDao.update(c);
	}

}
