package com.jpa.hibernate.springboot.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.hibernate.springboot.dto.Person;

@Service
@Transactional
public class PersonBS implements PersonRepositoryBSI {

	// @PersistenceContext: We can use this annotation also.
	@Autowired
	private EntityManager entity;

	@Override
	public Person findById(long id) {
		return entity.find(Person.class, id);
	}

	@Override
	public Person saveOrUpdate(Person person) {
		// It will update Person if Id matches otherwise it
		// will insert the new Person.
		entity.merge(person);
		return person;
	}

	@Override
	public Person delete(long id) {
		Person person = findById(id);
		entity.remove(person);
		return person;

	}

	@Override
	public List<Person> findAllPersons() {
		return entity.createNamedQuery("find_all_persons", Person.class).getResultList();
	}

}
