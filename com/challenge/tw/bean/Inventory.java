package com.challenge.tw.bean;

/***************************************************************************************************
 * 	Bean class to manage all the products data in the store 
 *  @author: Ravi Sankar Karuturi
 *  @createddate: 25/08/2016
 *****************************************************************************************************/
public class Inventory {
	
	int id;
	String brand;
	String category;
	int price;
	double finalprice;
	int discount;
	
	String categorypath;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public double getFinalprice() {
		return finalprice;
	}
	public void setFinalprice(double finalprice) {
		this.finalprice = finalprice;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
		double discountprice = (double)(price*discount)/100;
		this.finalprice = price - discountprice;
	}
	public String getCategorypath() {
		return categorypath;
	}
	public void setCategorypath(String categorypath) {
		this.categorypath = categorypath;
	}
	
	

}
