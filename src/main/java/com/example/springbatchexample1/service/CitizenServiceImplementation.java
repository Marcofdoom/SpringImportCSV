package com.example.springbatchexample1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springbatchexample1.model.Citizen;
import com.example.springbatchexample1.repository.CitizenRepository;

@Service
public class CitizenServiceImplementation implements CitizenService {

	private CitizenRepository citizenRepository;

	@Autowired
	public CitizenServiceImplementation(CitizenRepository citizenRepository) {
		this.citizenRepository = citizenRepository;
	}

	@Override
	public List<Citizen> getAllCitizen(Citizen citizen) {
		return citizenRepository.findCitizenByNameAndAddress(citizen.getFornames(), citizen.getSurname());
	}

	@Override
	public Citizen getCitizen(Citizen citizen) {
		return citizenRepository.findCitizen(citizen.getFornames(), citizen.getSurname());
	}
}