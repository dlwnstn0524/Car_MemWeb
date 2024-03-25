package com.ssafy.test.model;

/*
 * 
 * create table `cars` (
  `number` varchar(20) primary key not null,
  `model` varchar(20) not null,
  `price` int not null,
  `brand` varchar(20) not null,
  `size` varchar(10) default '소형'
);
 */
public class Car {
	
	private String number;
	private String model;
	private String price;
	private String brand;
	private String size;
	
	@Override
	public String toString() {
		return "Car [number=" + number + ", model=" + model + ", price=" + price + ", brand=" + brand + ", size=" + size
				+ "]";
	}

	public Car(String number) {
		super();
		this.number = number;
	}

	public Car(String number, String model, String price, String brand, String size) {
		super();
		this.number = number;
		this.model = model;
		this.price = price;
		this.brand = brand;
		this.size = size;
	}
	
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}	
}
