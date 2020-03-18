package com.practice.config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.database.JpaItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import com.practice.batchprocessing.PersonWriter;
import com.practice.model.Person;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {
	
		@Autowired
	  public JobBuilderFactory jobBuilderFactory;

	  @Autowired
	  public StepBuilderFactory stepBuilderFactory;
	  
	  @Autowired
	  DataSource dataSource;
	  
	  @Autowired
	  EntityManagerFactory entityManager;
	  
	  @Value("classpath:/test.xls")
	  private Resource personInput;
	  
	  @Bean
	  public FlatFileItemReader<Person> reader(){
		  FlatFileItemReader<Person> flatfile=new FlatFileItemReader<Person>();
		  flatfile.setName("personItemReader");
		  flatfile.setResource(personInput);
		  DelimitedLineTokenizer delimiter=new DelimitedLineTokenizer();
		  String[] tokens= {"firstname","lastname","designation","salary","experience"};
		  delimiter.setNames(tokens);
		  DefaultLineMapper<Person> default=new DefaultLineMapper<Person>();
		  flatfile.setLineMapper(lineMapper);
		  
		  return null;
	  }
	  
	  @Bean
	  public PersonWriter writer() {
		  return new PersonWriter();
	  }
	  @Bean
	  public JpaItemWriter<Person> jpaWriter(){
		  JpaItemWriter<Person> jpa=new JpaItemWriter<>();
		  jpa.setEntityManagerFactory(entityManager);
		  return jpa;
	  }
}
