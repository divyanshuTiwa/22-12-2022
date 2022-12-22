package com.spring.boot.data.jpa.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.data.jpa.demo.exception.ProductNotFoundException;
import com.spring.boot.data.jpa.demo.model.Product;
import com.spring.boot.data.jpa.repository.ProductRepository;

@Controller
@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;
	
		//Get all Product
		@GetMapping
		public List<Product> getAll(){
			return productRepository.findAll();
		}
		
		@GetMapping("{id}")
	    public ResponseEntity<Product> getById(@PathVariable  int id) throws ProductNotFoundException {
	        Product product = productRepository.findById(id)
	                .orElseThrow(() -> new ProductNotFoundException ("Product not exist with id :" + id));
	        
	        return ResponseEntity.ok(product);
	    }
	    
	  //Find the Product By name
	    @GetMapping("{productName}")
	    public ResponseEntity<List<Product>> findByProductName(@PathVariable  String productName){
	    	  List<Product> products = productRepository.findByProductName(productName);

	    	    if ( products.isEmpty()) {
	    	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    	    }
	    	    
	    	    return new ResponseEntity<>( products, HttpStatus.OK);
	    	  }
	    	 
	    //GetMapping category List and Product
	    @GetMapping
	    public List<Product> getsortedByPrice(@RequestBody Product productdetails)  {
	        return productRepository.SortedByPrice(productdetails);
	             
	    }
	    
	    //Sort the Product List
	    @GetMapping
	    public List<Product> getSortedByName(@RequestBody Product productdetails)  {
	          return productRepository.SortedByName(productdetails);
	             
	    }
	    
	    //GetMapping  Products by page
	    @GetMapping
	    public ResponseEntity<List<Product>> getProducts() throws ProductNotFoundException {
			org.springframework.data.domain.Pageable pageable = PageRequest.of(0, 7);
			List<Product> list = productRepository.findProducts(pageable);
			
			if(list.size()<=0) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
			return new ResponseEntity<List<Product>>(productRepository.findProducts(pageable), HttpStatus.OK);
		}
	    
	    //Update Product
	    @PutMapping("{id}")
	  	public ResponseEntity<Product> update(@RequestBody Product product, @PathVariable int id) {
	  		
	  		try{
	  			product.setId(id);
	  			
	  		//	productRepository.save(product);
	  		
	  			return ResponseEntity.ok().body(product);
	  			
	  		}
	  		
	  		catch(Exception e) {
	  			e.printStackTrace();
	  			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	  		}
	  		
	  	}
	    
	    
	    //Delete By Id
	    @DeleteMapping("{id}")
	    public ResponseEntity<HttpStatus> deleteById(@PathVariable int id) throws ProductNotFoundException {

	        Product product =  productRepository.findById(id)
	                .orElseThrow(() -> new ProductNotFoundException ("Product not exist with id : " + id));

	        productRepository.delete(product);

	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

	    }

		public void save(Product product) {
			// TODO Auto-generated method stub
			
		}	
		

}
