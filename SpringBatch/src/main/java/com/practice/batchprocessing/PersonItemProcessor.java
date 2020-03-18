package com.practice.batchprocessing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import com.practice.model.Person;

public class PersonItemProcessor implements ItemProcessor<Person, Person> {

	private static final Logger log = LoggerFactory.getLogger(PersonItemProcessor.class);
	
	@Override
	public Person process(final Person item) throws Exception {
		log.info("Entered into PersonItemProcessor.process");
		final Person p=new Person(); 
		p.setFirstname(item.getFirstname().toLowerCase());
		p.setLastname(item.getLastname().toLowerCase());
		p.setDesignation(item.getDesignation().toUpperCase());
		log.info("EXIT from  PersonItemProcessor.process");
		return p;
	}

}
