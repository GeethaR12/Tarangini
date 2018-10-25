package com.verizon.adb.service;

import java.util.List;

import com.verizon.adb.model.Customer;

public interface CustomerService {
	Customer add(Customer customer);
	boolean existsByMobile(String mobile);

}
