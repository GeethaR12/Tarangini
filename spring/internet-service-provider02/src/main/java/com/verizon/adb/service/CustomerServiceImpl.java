package com.verizon.adb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verizon.adb.dao.CustomerRepository;
import com.verizon.adb.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository cDao;


	

	@Override
	public Customer add(Customer customer) {
		// TODO Auto-generated method stub
		return cDao.save(customer);
	}

	@Override
	public boolean existsByMobile(String mobile) {
		// TODO Auto-generated method stub
		return cDao.existsByMobile(mobile);
	}

	


	

}
