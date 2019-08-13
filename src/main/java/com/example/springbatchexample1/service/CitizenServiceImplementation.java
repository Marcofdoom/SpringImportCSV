package com.example.springbatchexample1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springbatchexample1.model.Citizen;
import com.example.springbatchexample1.repository.CitizenClassRepository;

@Service
public class CitizenServiceImplementation implements CitizenService {

//	private CitizenRepository citizenRepository;
	
	private CitizenClassRepository citizenRepository;

//	@Autowired
//	public CitizenServiceImplementation(CitizenRepository citizenRepository) {
//		this.citizenRepository = citizenRepository;
//	}
	
	@Autowired
	public CitizenServiceImplementation(CitizenClassRepository citizenRepository) {
		this.citizenRepository = citizenRepository;
	}

	@Override
	public List<Citizen> getAllCitizen(Citizen citizen) {
		System.out.println(citizen.getName());
		System.out.println(citizen.getAddress());
		return citizenRepository.findCitizenByNameAndAddress(citizen.getName(), citizen.getAddress());
//		return citizenRepository.findCitizenByName(citizen.getName());
	}
}