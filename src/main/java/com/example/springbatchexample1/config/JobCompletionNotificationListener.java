//package com.example.springbatchexample1.config;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.batch.core.BatchStatus;
//import org.springframework.batch.core.JobExecution;
//import org.springframework.batch.core.listener.JobExecutionListenerSupport;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Component;
//
//import com.example.springbatchexample1.model.Citizen;
//
//@Component
//public class JobCompletionNotificationListener extends JobExecutionListenerSupport {
//
//	private static final Logger log = LoggerFactory.getLogger(JobCompletionNotificationListener.class);
//
//	private final JdbcTemplate jdbcTemplate;
//
//	@Autowired
//	public JobCompletionNotificationListener(JdbcTemplate jdbcTemplate) {
//		this.jdbcTemplate = jdbcTemplate;
//	}
//
//	@Override
//	public void afterJob(JobExecution jobExecution) {
//		if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
//			log.info("!!! JOB FINISHED! Time to verify the results");
//
//			jdbcTemplate
//					.query("SELECT fornames, surname FROM Citizen",
//							(rs, row) -> new Citizen(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4),
//									rs.getDate(5), rs.getString(6), rs.getString(7)))
//					.forEach(citizen -> log.info("Found <" + citizen + "> in the database."));
//		}
//	}
//}