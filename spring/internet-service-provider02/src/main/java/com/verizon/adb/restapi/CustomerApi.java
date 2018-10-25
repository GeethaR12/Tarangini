package com.verizon.adb.restapi;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.verizon.adb.model.Customer;
import com.verizon.adb.service.CustomerService;

@RestController
@CrossOrigin
@RequestMapping("/customer")
public class CustomerApi {
	
	@Autowired
	private CustomerService service;
	
	
	
	@PostMapping
	public ResponseEntity<Customer> addContact(@RequestBody Customer contact){
	
		ResponseEntity<Customer> resp=null;
		if(service.existsByMobile(contact.getMobile()))
		{
			resp=new ResponseEntity<Customer>(HttpStatus.ALREADY_REPORTED);
	
		}
		if(resp==null)
		{
			Customer c=service.add(contact);
			if(c==null)
			resp=new ResponseEntity<Customer>(contact,HttpStatus.BAD_REQUEST);
			else
				resp=new ResponseEntity<Customer>(contact,HttpStatus.OK);
		}
		return resp;
		
	}
	
}
