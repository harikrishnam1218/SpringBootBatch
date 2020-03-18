package com.practice.batchprocessing;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import com.practice.model.Person;

public class PersonMapper implements FieldSetMapper<Person> {
	boolean batchjob = false;

	@Override
	public Person mapFieldSet(FieldSet fieldSet) throws BindException {
		if (!batchjob) {
			Person per = new Person();
			 per.setPid(fieldSet.readLong("pid"));
			per.setFirstname(fieldSet.readString("firstname"));
			per.setLastname(fieldSet.readString("lastname"));
			per.setDesignation(fieldSet.readString("designation"));
			per.setSalary(fieldSet.readDouble("salary"));
			per.setExperience(fieldSet.readDouble("experience"));
			batchjob = true;
			return per;
		}
		return null;
	}
}
