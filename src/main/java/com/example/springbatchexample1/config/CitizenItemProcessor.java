//package com.example.springbatchexample1.config;
//
//import java.util.Date;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.batch.item.ItemProcessor;
//
//import com.example.springbatchexample1.model.Citizen;
//
//public class CitizenItemProcessor implements ItemProcessor<Citizen, Citizen> {
//
//	private static final Logger log = LoggerFactory.getLogger(CitizenItemProcessor.class);
//
//	@Override
//	public Citizen process(final Citizen citizen) throws Exception {
//		final Long citizenId = citizen.getCitizenId();
//		final String fornames = citizen.getFornames();
//		final String surname = citizen.getSurname();
//		final String homeAddress = citizen.getHomeAddress();
//		final Date dateOfBirth = citizen.getDateOfBirth();
//		final String placeOfBirth = citizen.getPlaceOfBirth();
//		final String sex = citizen.getSex();
//
//		final Citizen transformedPerson = new Citizen(citizenId, fornames, surname, homeAddress, dateOfBirth,
//				placeOfBirth, sex);
//
//		log.info("Converting (" + citizen + ") into (" + transformedPerson + ")");
//
//		return transformedPerson;
//	}
//
//}