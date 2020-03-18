package com.practice.batchprocessing;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

import com.practice.model.Person;

public class PersonWriter implements ItemWriter<Person> {

	@Override
	public void write(List<? extends Person> items) throws Exception {
		items.forEach(System.out::print);
	}

}
