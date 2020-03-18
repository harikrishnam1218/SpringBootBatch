package com.practice.batchprocessing;


import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import com.practice.model.Person;

public class PersonMapper implements FieldSetMapper<Person>{
	boolean batchjob=false;
	@Override
	public Person mapFieldSet(FieldSet fieldSet) throws BindException {
		if(!batchjob) {
	Person per=new Person();
	//per.setPid(fieldSet.readLong(0));
	per.setFirstname(fieldSet.readString(1));
	per.setLastname(fieldSet.readString(2));
	per.setDesignation(fieldSet.readString(3));
	per.setSalary(fieldSet.readDouble(4));
	per.setExperience(fieldSet.readDouble(5));
		batchjob=true;
		return per;
	}
		return null;
	}
}
