package com.verizon.adb.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="isp")

public class IspModel {


	@Id
	private String title;
	
	private String speed;
	private String maxUsage;
	private String charge;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSpeed() {
		return speed;
	}
	public void setSpeed(String speed) {
		this.speed = speed;
	}
	public String getMaxUsage() {
		return maxUsage;
	}
	public void setMaxUsage(String maxUsage) {
		this.maxUsage = maxUsage;
	}
	public String getCharge() {
		return charge;
	}
	public void setCharge(String charge) {
		this.charge = charge;
	}
	
	
}
