//package com.example.springbatchexample1.config;
//
//import javax.sql.DataSource;
//
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.core.launch.support.RunIdIncrementer;
//import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
//import org.springframework.batch.item.database.JdbcBatchItemWriter;
//import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
//import org.springframework.batch.item.file.FlatFileItemReader;
//import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
//import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.ClassPathResource;
//
//import com.example.springbatchexample1.model.Citizen;
//
//@Configuration
//@EnableBatchProcessing
//public class BatchConfiguration {
//
//	@Autowired
//	public JobBuilderFactory jobBuilderFactory;
//
//	@Autowired
//	public StepBuilderFactory stepBuilderFactory;
//
//	// tag::readerwriterprocessor[]
//	@Bean
//	public FlatFileItemReader<Citizen> reader() {
//		return new FlatFileItemReaderBuilder<Citizen>().name("citizenItemReader")
//				.resource(new ClassPathResource("citizen.csv"))
//				.delimited()
//				.names(new String[] { "citizenId", "fornames", "surname", "homeAddress", "dateOfBirth", "placeOfBirth", "sex" })
//				.fieldSetMapper(new BeanWrapperFieldSetMapper<Citizen>() {
//					{
//						setTargetType(Citizen.class);
//					}
//				}).build();
//	}
//
//	@Bean
//	public CitizenItemProcessor processor() {
//		return new CitizenItemProcessor();
//	}
//
//	@Bean
//	public JdbcBatchItemWriter<Citizen> writer(DataSource dataSource) {
//		return new JdbcBatchItemWriterBuilder<Citizen>()
//				.itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
//				.sql("INSERT INTO citizen (fornames, surname) VALUES (:fornames, :surname)").dataSource(dataSource)
//				.build();
//	}
//	// end::readerwriterprocessor[]
//
//	// tag::jobstep[]
//	@Bean
//	public Job importUserJob(JobCompletionNotificationListener listener, Step step1) {
//		return jobBuilderFactory.get("importUserJob").incrementer(new RunIdIncrementer()).listener(listener).flow(step1)
//				.end().build();
//	}
//
//	@Bean
//	public Step step1(JdbcBatchItemWriter<Citizen> writer) {
//		return stepBuilderFactory.get("step1").<Citizen, Citizen>chunk(10).reader(reader()).processor(processor())
//				.writer(writer).build();
//	}
//	// end::jobstep[]
//}
