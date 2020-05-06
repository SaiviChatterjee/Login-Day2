package com.cognizant.model;

public class User {
	private int id;
	private String name;
	private String contact;
	private String company;
	private String gender;
	private String country;
	private String state;
	private String city;
	
	public User() {
		super();
	}

	public User(int id, String name, String contact, String company, String gender, String country,
			String state, String city) {
		super();
		this.id = id;
		this.name = name;
		this.contact = contact;
		this.company = company;
		this.gender = gender;
		this.country = country;
		this.state = state;
		this.city = city;
	}



	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", contact=" + contact + ", company=" + company + ", gender="
				+ gender + ", country=" + country + ", state=" + state + ", city=" + city + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
}
