package com.klef.jfsd;

public class Product
{
	private int id;
	private String category;
	private String name;
	private String description;
	private Double price;
	private String manufactureddate;
	private boolean expiry;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getManufactureddate() {
		return manufactureddate;
	}
	public void setManufactureddate(String manufactureddate) {
		this.manufactureddate = manufactureddate;
	}
	public boolean isExpiry() {
		return expiry;
	}
	public void setExpiry(boolean expiry) {
		this.expiry = expiry;
	}
}
