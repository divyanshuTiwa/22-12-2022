package com.spring.boot.app.data.jpa.demo;

 
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.spring.boot.data.jpa.demo.controller.CategoryController;
import com.spring.boot.data.jpa.demo.controller.ProductController;
import com.spring.boot.data.jpa.demo.model.Category;
import com.spring.boot.data.jpa.demo.model.Product;



@SpringBootApplication
public class SpringBootJpaAppsTestApplication implements CommandLineRunner {
	
	@Autowired
	private ProductController productController;
	
	@Autowired
	private CategoryController categoryController;

	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaAppsTestApplication.class, args);
	}
	

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("\n\n________*********All Categories*********_________\n");
		addCategories(createCategories());
		
		System.out.println("\n\n________*********All Products*********_________\n");
		addProducts(createProducts());
		
		
	}
	
	
		private void addCategories(List<Category> categories) {
			for (Category category : categories) {
				categoryController.save(category);
				
			}
		}
		
		private void addProducts(List<Product> products) {
			for (Product product : products) {
				productController.save(product);
				
			}
		}
			
		private List<Category> createCategories() {
			
			//create object
					
			Category category01= new  Category(1,"Junk Food","It is very harmfull for our healths",null);
			Category category02= new  Category(2,"Cold  Coffee","It is very tasty",null);
			Category category03= new  Category(3,"Formal Shirts","This is availiable in 25-30% Discounts",null);
			

							
			//add in list
			List<Category> category= new ArrayList<>();
			category.add(category01);
			category.add(category02);
			category.add(category03);
					
			return category;
			

		}

		
		private List<Product> createProducts() {
			
			//create object
					
			Product product01 = new  Product(1,"Chaumin",60.7,20,true,null);		
			Product product02 = new  Product(2,"Pizza",80.0,20,true,null);		
			Product product03 = new  Product(3,"Berger",70.7,20,true,null);		
			Product product04 = new  Product(4,"Fizz",15.50,20,true,null);		
			Product product05 = new  Product(5,"Shirts",800.0,20,true,null);		
			Product product06 = new  Product(6,"Blezer",2000.50,20,true,null);		
			
							
			// List of Products
			List<Product> products= new ArrayList<>();
			products.add(product01);
			products.add(product02);
			products.add(product03);
			products.add(product04);
			products.add(product05);
			products.add(product06);
			
					
			return products;
			
		
		}

	}
