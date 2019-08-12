package com.example.springbatchexample1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springbatchexample1.model.Citizen;

public interface CitizenRepository extends JpaRepository<Citizen, Long> {

}