package com.example.springbatchexample1.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.springbatchexample1.model.Citizen;

@Repository
public class CitizenRepositoryCustomImpl implements CitizenRepositoryCustom {

	private EntityManager entityManager;

	@Autowired
	public CitizenRepositoryCustomImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public List<Citizen> findCitizenByNameAndAddress(String name, String address) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Citizen> cq = cb.createQuery(Citizen.class);

		Root<Citizen> citizen = cq.from(Citizen.class);
		List<Predicate> predicates = new ArrayList<Predicate>();

		if (name != null && !name.trim().contentEquals("")) {
			predicates.add(cb.equal(cb.lower(citizen.get("name")), name.toLowerCase()));
		}

		if (address != null && !address.trim().contentEquals("")) {
			predicates.add(cb.equal(cb.lower(citizen.get("address")), address.toLowerCase()));
		}

		if (predicates.isEmpty()) {
			return new ArrayList<Citizen>();
		}

		cq.where(predicates.toArray(new Predicate[0]));

		TypedQuery<Citizen> query = entityManager.createQuery(cq);

		return query.getResultList();
	}

	public Citizen findCitizen(String fornames, String surname) {
		TypedQuery<Citizen> query = entityManager.createQuery("SELECT c FROM Citizen c WHERE c.fornames = :fornames",
				Citizen.class);

		query.setParameter("fornames", fornames);
//		query.setParameter("surname", surname);

		return query.getResultList().get(0);
	}
}