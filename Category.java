package com.spring.boot.data.jpa.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="categories")
public class Category {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id",nullable = false,length=11)
	private int id;
	
	@Column(name ="name",nullable = false,length =50)
	private String name;
	
	@Column(name = "description",length=100)
	private String description;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="categories")
	private List<Product> product;

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Category(int id, String name, String description, List<Product> product) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.product = product;
	}
	
	public Category( String name, String description, List<Product> product) {
		super();
		this.name = name;
		this.description = description;
		this.product = product;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", description=" + description + ", product=" + product + "]";
	}
	
	

}
