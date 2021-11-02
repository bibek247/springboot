package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class accountService {
	
	@Autowired
	private accountRepository repo;
	
	     
	    public List<account> listAll() {
	        return repo.findAll();
	    }
	     
	    public void save(account account) {
	        repo.save(account);
	    }
	     
	    public account get(Integer slno) {
	        return repo.findById(slno).get();
	    }
	     
	    public void delete(Integer slno) {
	        repo.deleteById(slno);
	    }
}
