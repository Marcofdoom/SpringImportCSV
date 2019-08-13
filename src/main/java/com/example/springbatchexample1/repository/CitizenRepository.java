package com.example.springbatchexample1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;

import com.example.springbatchexample1.model.Citizen;

public interface CitizenRepository extends JpaRepository<Citizen, Long> {

//	@Query("SELECT c FROM Citizen c WHERE (:name is null or c.name = :name) and (:address is null or c.address = :address)")
//	@Query("SELECT c FROM Citizen c WHERE (:name is null or c.name = :name) and (:address is null or c.address = :address)")
//	@Query("SELECT c FROM Citizen c WHERE c.name = name")
	List<Citizen> findCitizenByNameAndAddress(@Nullable String name, @Nullable String address);
//	@Query("SELECT c FROM Citizen c WHERE (:name is null or c.name = :name)")
//	List<Citizen> findCitizenByName(@Param("name") String name);
//	List<Citizen> findCitizenByName(@Nullable String name, @Nullable String address);
//	List<Citizen> findCitizenByName(@Param("name") String name);
}