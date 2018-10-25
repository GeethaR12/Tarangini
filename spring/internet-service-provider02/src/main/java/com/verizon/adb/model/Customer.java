package com.verizon.adb.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name="customers")
public class Customer {
	
	@Id
	private String title;
	
	private String name;
	private String mobile;
	private String address;
	private String timeSlot;
	private double charge;
	@DateTimeFormat(iso=ISO.DATE)
	@Column(name="dor")
	private LocalDate dateOfRequest; 
	@DateTimeFormat(iso=ISO.DATE)
	@Transient
	private LocalDate dateOfInstallation;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTimeSlot() {
		return timeSlot;
	}
	public void setTimeSlot(String timeSlot) {
		this.timeSlot = timeSlot;
	}
	public double getCharge() {
		return charge;
	}
	public void setCharge(double charge) {
		this.charge = charge;
	}
	public LocalDate getDateOfRequest() {
		return dateOfRequest;
	}
	public void setDateOfRequest(LocalDate dateOfRequest) {
		this.dateOfRequest = dateOfRequest;
	}
	public LocalDate getDateOfInstallation() {
		return dateOfInstallation;
	}
	public void setDateOfInstallation(LocalDate dateOfInstallation) {
		this.dateOfInstallation = dateOfInstallation;
	} 
	
	
}