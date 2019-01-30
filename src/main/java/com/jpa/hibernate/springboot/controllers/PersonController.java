package com.jpa.hibernate.springboot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.hibernate.springboot.dto.Person;
import com.jpa.hibernate.springboot.service.PersonBS;

@RestController
public class PersonController {

	@Autowired
	private PersonBS personBS;

	@GetMapping("/user/{id}")
	public Person getUserByUserId(@PathVariable long id) {
		return personBS.findById(id);
	}

	@GetMapping("/users")
	public List<Person> getUserByUserId() {
		return personBS.findAllPersons();
	}

	@PostMapping("/user")
	public Person saveOrUpdateUser(@RequestBody Person person) {
		return personBS.saveOrUpdate(person);
	}

	@DeleteMapping("/user/{id}")
	public Person deleteUserById(@PathVariable long id) {
		return personBS.delete(id);
	}
}
