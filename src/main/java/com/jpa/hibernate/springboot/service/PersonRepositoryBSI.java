package com.jpa.hibernate.springboot.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jpa.hibernate.springboot.dto.Person;

@Repository
public interface PersonRepositoryBSI {

	public Person findById(long id);

	public Person saveOrUpdate(Person person);

	public Person delete(long id);
	
	public List<Person> findAllPersons();

}
