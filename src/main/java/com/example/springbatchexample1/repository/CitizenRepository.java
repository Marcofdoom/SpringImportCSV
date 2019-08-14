package com.example.springbatchexample1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springbatchexample1.model.Citizen;

@Repository
public interface CitizenRepository extends JpaRepository<Citizen, Long>, CitizenRepositoryCustom {

}