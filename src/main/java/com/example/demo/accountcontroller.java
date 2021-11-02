package com.example.demo;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class accountcontroller {
	
   @Autowired
   private accountService service;
   
   @RequestMapping("/acc")
	String homeacc() {
		return " account  jpa ";
	}
   
 // RESTful API methods for Retrieval operations
   @GetMapping("/account")
   public List<account> list() {
       return service.listAll();
   }
   
   @GetMapping("/account/{id}")
   public ResponseEntity<account> get(@PathVariable Integer slno) {
       try {
           account account = service.get(slno);
           return new ResponseEntity<account>(account, HttpStatus.OK);
       } catch (NoSuchElementException e) {
           return new ResponseEntity<account>(HttpStatus.NOT_FOUND);
       }      
   }
   
   // RESTful API method for Create operation
    
   // RESTful API method for Update operation
    
   // RESTful API method for Delete operation
	
   

}
