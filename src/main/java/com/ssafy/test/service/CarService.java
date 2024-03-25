package com.ssafy.test.service;

import java.util.List;

import com.ssafy.test.model.Car;

public interface CarService {
	public List<Car> getCars() throws Exception;
	public Car getDetail(Car car) throws Exception;
	public int insert(Car c) throws Exception;
	public void delete(Car c) throws Exception;
	public void update(Car c) throws Exception;	
}
