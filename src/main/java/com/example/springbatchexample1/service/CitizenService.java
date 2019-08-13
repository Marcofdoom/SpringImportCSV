package com.example.springbatchexample1.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.springbatchexample1.model.Citizen;

@Service
public interface CitizenService {

	public List<Citizen> getAllCitizen(Citizen citizen);
}