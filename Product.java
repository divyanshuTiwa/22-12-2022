package com.spring.boot.data.jpa.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="products")
public class Product {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id",nullable=false,length=11)
	private int id;
	
	@Column(name = "Product_name", nullable = false, length = 50)
	private String name;
	
	@Column(name = "Product_price")
	private double price;
	
	@Column(name = "Units_In_Stock")
	private int unitsInStock;
	
	@Column(name = "Discontinue")
	private boolean discontinued;
	
	//ManyToOne Mapping...
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "products")
	private List <Category> category;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(int id, String name, double price, int unitsInStock, boolean discontinued, List<Category> category) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.unitsInStock = unitsInStock;
		this.discontinued = discontinued;
		this.category = category;
	}
	
	public Product( String name, double price, int unitsInStock, boolean discontinued, List<Category> category) {
		super();
		this.name = name;
		this.price = price;
		this.unitsInStock = unitsInStock;
		this.discontinued = discontinued;
		this.category = category;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getUnitsInStock() {
		return unitsInStock;
	}

	public void setUnitsInStock(int unitsInStock) {
		this.unitsInStock = unitsInStock;
	}

	public boolean isDiscontinued() {
		return discontinued;
	}

	public void setDiscontinued(boolean discontinued) {
		this.discontinued = discontinued;
	}

	public List<Category> getCategory() {
		return category;
	}

	public void setCategory(List<Category> category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", unitsInStock=" + unitsInStock
				+ ", discontinued=" + discontinued + ", category=" + category + "]";
	}
	
	

	
}
