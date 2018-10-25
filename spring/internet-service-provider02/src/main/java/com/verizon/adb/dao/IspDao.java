package com.verizon.adb.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.verizon.adb.model.IspModel;

@Repository
public interface IspDao extends JpaRepository<IspModel, String>{
	
	IspModel findByTitle(String title);
	List<IspModel> findAllByCharge(String  charge);
	//function name called should be same as the props name
	List<IspModel> findAllBySpeed(String speed);
	List<IspModel> findAllByMaxUsage(String maxUsage);
}
