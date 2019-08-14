package com.example.springbatchexample1.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Citizen {

	@Id
	private Long citizenId;
	private String fornames;
	private String surname;
	private String homeAddress;
	private String dateOfBirth;
	private String placeOfBirth;
	private String sex;

	public Citizen() {

	}

	public Citizen(Long citizenId, String fornames, String surname, String homeAddress, String dateOfBirth,
			String placeOfBirth, String sex) {
		this.citizenId = citizenId;
		this.fornames = fornames;
		this.surname = surname;
		this.homeAddress = homeAddress;
		this.dateOfBirth = dateOfBirth;
		this.placeOfBirth = placeOfBirth;
		this.sex = sex;
	}
}