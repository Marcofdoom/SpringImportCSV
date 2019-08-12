package com.example.springbatchexample1.batch;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.springbatchexample1.model.Citizen;
import com.example.springbatchexample1.repository.CitizenRepository;

@Component
public class DBWriter implements ItemWriter<Citizen> {

	private CitizenRepository citizenRepository;

	@Autowired
	public DBWriter(CitizenRepository citizenRepository) {
		this.citizenRepository = citizenRepository;
	}

	@Override
	public void write(List<? extends Citizen> items) throws Exception {
		citizenRepository.saveAll(items);
	}
}