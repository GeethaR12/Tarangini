package com.verizon.adb.service;

import java.util.List;

import com.verizon.adb.model.IspModel;

public interface IspService {
	IspModel findByTitle(String title);
	public List<IspModel> getAll();
	IspModel getByTitle(String title);
	public List<IspModel> findAllByCharge(String  charge);
	public //function name called should be same as the props name
	 List<IspModel> findAllBySpeed(String speed);
	public List<IspModel> findAllByMaxUsage(String maxUsage);
}
