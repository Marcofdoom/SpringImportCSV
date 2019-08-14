package com.example.springbatchexample1.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.springbatchexample1.model.Citizen;

@Repository
public interface CitizenRepositoryCustom {

	public List<Citizen> findCitizenByNameAndAddress(String fornames, String surname);

	public Citizen findCitizen(String fornames, String surname);
}