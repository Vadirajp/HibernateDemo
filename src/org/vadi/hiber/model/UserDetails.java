package org.vadi.hiber.model;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@SuppressWarnings("unused")
@Entity 
@Table (name="USER_DETAILS")
public class UserDetails {

	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="USER_ID")
	private int userId;
	
	@Column(name="USER_NAME")
	//@Transient  //this will ignore while saving data
	private String userName;
	
	@Column(name="JOIN_DATE")
	@Temporal(TemporalType.DATE) //only date, no time 
	private Date joinDate;
	
	@Embedded //not mandatory as we are using class name here
	@AttributeOverrides({
		@AttributeOverride (name="street",column=@Column(name="HOME_STREET_NAME")),
		@AttributeOverride (name="state",column=@Column(name="HOME_STATE_NAME")),
		@AttributeOverride (name="city",column=@Column(name="HOME_CITY_NAME")),
		@AttributeOverride (name="pincode",column=@Column(name="HOME_PIN_CODE"))
	})
	private Address homeAddress;
	
	@Embedded
	private Address officeAddress;
	
	@Column(name="DESCRIPTION")
	@Lob //If we don't know the size
	private String description;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	
	
	
	public Address getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}
	public Address getOfficeAddress() {
		return officeAddress;
	}
	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "UserDetails [userId=" + userId + ", userName=" + userName + ", joinDate=" + joinDate + ", homeAddress="
				+ homeAddress + ", officeAddress=" + officeAddress + ", description=" + description + "]";
	}
	
	
	
	
	
	
	
}
