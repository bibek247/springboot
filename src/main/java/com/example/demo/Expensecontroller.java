package com.example.demo;

//import com.example.demo.Expense;
//import com.example.demo.Expenseservice;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.jdbc.Expectations;
//import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.client.RestTemplate;

@ControllerAdvice
@RestController
public class Expensecontroller {
  @Autowired
  ExpenseRepository expensesrepository;
  
  @RequestMapping({"/homeexp"})
  String home() {
    return " home expense ";
  }
  
  @GetMapping(value = {"/listexpense"}, produces = {"application/json"})
  public List<Expense> listallexpense() {
    return this.expensesrepository.findAll();
  }
  
  @RequestMapping(value = {"/viewExpense/{id}"}, headers = {"Accept=application/json"})
  @ResponseBody
  public Expense viewAllItems(@PathVariable String id) {
    List<Expense> allExpense = this.expensesrepository.findAll();
    return allExpense.get(Integer.parseInt(id) - 1);
  }
  
  @RequestMapping({"/viewExpense2/{id}"})
  @ResponseBody
  public String viewAllItems2(@PathVariable String id) {
    List<Expense> allExpense = this.expensesrepository.findAll();
    String str = allExpense.toString();
    return "output=" + str;
  }
  
  @GetMapping(value = {"/expensejson"}, produces = {"application/json"})
  public ResponseEntity<List<Expense>> getAllExpense(@RequestParam(required = false) Long id, String item) {
    try {
      List<Expense> expenceobj = new ArrayList<>();
      if (id == null && item == null) {
        this.expensesrepository.findAll().forEach(expenceobj::add);
      } else if (id.longValue() > 0L) {
        this.expensesrepository.findByid(id).forEach(expenceobj::add);
      } else if (item.trim().length() > 0) {
        this.expensesrepository.findByItem(item).forEach(expenceobj::add);
      } 
      if (expenceobj.isEmpty())
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      
      return new ResponseEntity<>(expenceobj, HttpStatus.OK);
      
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    } 
  }
  
  @GetMapping(value = {"/expenseamt"}, produces = {"application/json"})
  public ResponseEntity<List<Expense>> getExpenseamt(@RequestParam(required = false) String amt) {
    try {
      List<Expense> expenceobj = new ArrayList<>();
      float famt = Float.parseFloat(amt);
      this.expensesrepository.listItemsWithPriceOver(famt).forEach(expenceobj::add);
      if (expenceobj.isEmpty())
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); 
      return new ResponseEntity<>(expenceobj, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    } 
  }
  
  @GetMapping(value = {"/expensestream"}, produces = {"application/json"})
  public List<Expense> getexpensejson() {
    List<Expense> allExpense = this.expensesrepository.findAll();
    List<Expense> show = (List<Expense>)allExpense.stream().collect(Collectors.toList());
    return show;
  }
  
  @RequestMapping(value = {"/listexpjson"}, method = {RequestMethod.GET}, produces = {"application/json"})
  @ResponseBody
  public ResponseEntity<Iterable<Expense>> listexpjson() {
    try {
      return new ResponseEntity<>(this.expensesrepository.findAll(), HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    } 
  }
  
  
  @PostMapping("/newexpense")
  Expense createOrSaveExpense(@RequestBody Expense newExpense) {
      return expensesrepository.save(newExpense);
  }
  
  // expense is a object of Expense entity
  @PutMapping("/updateexpense/{id}")
  Expense updateExpense(@RequestBody Expense newExpense, @PathVariable Long id) {
	  
	  return expensesrepository.findById(id).map(expense -> {
		  expense.setItem(newExpense.getItem());
		  expense.setAmount(newExpense.getAmount());
          return expensesrepository.save(expense);
      }).orElseGet(() -> {
    	  newExpense.setId(id);
          return expensesrepository.save(newExpense);
      });
	  
  }
  
  @DeleteMapping("/deleteexpense/{id}")
  String deleteExpense(@PathVariable Long id) {
	 String  ret="delete" + " Success" ;
	 try {
	  expensesrepository.deleteById(id);
	 } catch(Exception e) {
		 ret="Falure"+ e.getMessage();
	 }
	 
	 return ret;
  }
    
 
}