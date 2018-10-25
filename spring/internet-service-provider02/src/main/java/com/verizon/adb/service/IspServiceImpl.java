package com.verizon.adb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verizon.adb.dao.IspDao;
import com.verizon.adb.model.IspModel;
@Service
public class IspServiceImpl implements IspService {
	@Autowired
	private IspDao iDao;

	@Override
	public IspModel findByTitle(String title) {
		return iDao.findByTitle(title);
	}

	@Override
	public List<IspModel> getAll() {
		return iDao.findAll();
	}

	


	@Override
	public List<IspModel> findAllByCharge(String charge) {
		// TODO Auto-generated method stub
		return iDao.findAllByCharge(charge);
	}

	@Override
	public List<IspModel> findAllBySpeed(String speed) {
		// TODO Auto-generated method stub
		return iDao.findAllBySpeed(speed);
	}

	@Override
	public List<IspModel> findAllByMaxUsage(String maxUsage) {
		// TODO Auto-generated method stub
		return iDao.findAllByMaxUsage(maxUsage);
	}

	@Override
	public IspModel getByTitle(String title) {
		
		return iDao.findByTitle(title);
	}



	

}
