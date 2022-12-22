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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.data.jpa.demo.exception.CategoryNotFoundException;
import com.spring.boot.data.jpa.demo.model.Category;
import com.spring.boot.data.jpa.repository.CategoryRepository;


@Controller
@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
		//Get all category
		@GetMapping
		public List<Category> getAll(){
			return categoryRepository.findAll();
		}
		
		//Add category
		@PostMapping
		public Category save(@RequestBody Category category) {
			return category;
	//		 categoryRepository.save(category);
		}
		//GetMapping  all category
		@GetMapping("{id}")
		public ResponseEntity<Category> categorygetById(@PathVariable int id) throws CategoryNotFoundException {
			Category category = categoryRepository.findById(id)
	                .orElseThrow(() -> new CategoryNotFoundException ("Category not exist with id :" + id));
	        
	        return ResponseEntity.ok(category);
	    }
		
		//Get By name
	    @GetMapping("{name}")
	    public ResponseEntity<Category> getByName(@PathVariable  String name){
	    	Category category = categoryRepository.getByName(name);
		
	    	return ResponseEntity.ok(category);

	    }
	    
	  //Get all the Category By name
	    @GetMapping("/getbynames/{name}")
	    public ResponseEntity<List<Category>> getByNames(@PathVariable  String name){
	    	  List<Category> products = categoryRepository.getByNames(name);

	    	    if ( products.isEmpty()) {
	    	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    	    }
	    	    
	    	    return new ResponseEntity<>( products, HttpStatus.OK);
	    	  }
	    
	    //GetMapping Category List
	    @GetMapping
	    public List<Category> SortedByName(@RequestBody List<Category> category) {
			return category;
	    }
	//      return  categoryRepository.sortedByName(category);
	             
	    
	    
	    //GetMapping  Category get by Page
	    @GetMapping()
	    public ResponseEntity<List<Category>> getCategories() throws CategoryNotFoundException {
			org.springframework.data.domain.Pageable pageable = PageRequest.of(0, 4);
			List<Category> list = categoryRepository.findCategories(pageable);
			
			if(list.size()<=0) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
			return new ResponseEntity<List<Category>>(categoryRepository.findCategories(pageable), HttpStatus.OK);
		}
	    
	    //Update Category
	    @PutMapping("{id}")
	  	public ResponseEntity<Category> update(@RequestBody Category category, @PathVariable int id) {
	  		
	  		try
	  		{
	  			category.setId(id);
	  			
	  		//	 return categoryRepository.save(category);
	  		
	  			return ResponseEntity.ok().body(category);
	  		}
	  		catch(Exception e) {
	  			e.printStackTrace();
	  			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	  		}
	  		
	  		}
	    
	    
	    //Delete Mapping
	    @DeleteMapping("{id}")
	    public ResponseEntity<HttpStatus> deleteById(@PathVariable int id) throws CategoryNotFoundException {

	    	Category category =  categoryRepository.findById(id)
	                .orElseThrow(() -> new CategoryNotFoundException ("Category not exist with id : " + id));

	    	categoryRepository.delete(category);

	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

	    }	
	
		
	}
