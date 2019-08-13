package com.example.springbatchexample1.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Citizen {

	@Id
	private Long citizen_id;
	private String name;
	private Integer age;
	private String address;

	public Citizen() {

	}

	public Citizen(Long citizen_id, String name, Integer age, String address) {
		this.citizen_id = citizen_id;
		this.name = name;
		this.age = age;
		this.address = address;
	}

	public Long getCitizen_id() {
		return citizen_id;
	}

	public void setCitizen_id(Long citizen_id) {
		this.citizen_id = citizen_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}