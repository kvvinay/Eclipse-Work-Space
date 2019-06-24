package com.kvvinay;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Customer {
	
	@NotNull
	@Size(min=1,message="it is requires stupid")
	private String firstName;
	private String lastName;
	@Min(value=0,message="it should be min 0")
	@Max(value=10,message="it should be max 10")
	private Integer freePasses;
	@Pattern(regexp="^[a-zA-z0-9]{6}$",message="it must be only 6 alpha numerical")
	private String pinCode;
	
	public Customer() {
		
	}
	
	

	public String getPinCode() {
		return pinCode;
	}



	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}



	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getFreePasses() {
		return freePasses;
	}

	public void setFreePasses(Integer freePasses) {
		this.freePasses = freePasses;
	}
	

}
