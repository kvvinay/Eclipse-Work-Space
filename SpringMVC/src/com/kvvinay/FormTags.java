package com.kvvinay;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FormTags {
	
	private String firstName;
	private String lastName;
	private String country;
	private Map<String,String> map;
	private String language;
	private List<String> os = new ArrayList<>();;

	
	public FormTags() {
		map = new HashMap<>();
		map.put("CND", "Canada");
		map.put("IND", "India");
		map.put("AF", "Africa");
		map.put("NZL", "Newzland");
		map.put("USA", "Usa(Americas)");
		map.put("AUS", "Australia");
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstname) {
		this.firstName = firstname;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastname) {
		this.lastName = lastname;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Map<String, String> getMap() {
		return map;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public List<String> getOs() {
		return os;
	}

	public void setOs(List<String> os) {
		this.os = os;
	}

	

	

}
