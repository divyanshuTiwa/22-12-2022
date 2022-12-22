package com.spring.boot.data.jpa.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.boot.data.jpa.demo.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
	

	
	public List<Product> getByName(Product productdetails);
	
	@Query(value = "SELECT * FROM Products  WHERE Product_Name = ?",nativeQuery=true)
	List<Product> findByProductName(String productName);
	
	
	@Query(value = "SELECT p FROM Product p ORDER BY price")
	public List<Product> SortedByPrice(Product productdetails);		  
	   
	@Query(value = "SELECT p FROM Product p ORDER BY name")
	public List<Product> SortedByName(Product productdetails);
	   
	@Query("from Product" )
	List<Product> findProducts(Pageable pageable);

}
	//public List<Product> getByNames(Product productdetails);
	
//	public List<Product> getByBetweenPrice(double iPrice,double oPrice);
	
	//select * from products where price between 300 and 1200;
	
	

//	public List<Product> findProducts(Pageable pageable);

	//public List<Product> findProducts(Pageable productName);

	


