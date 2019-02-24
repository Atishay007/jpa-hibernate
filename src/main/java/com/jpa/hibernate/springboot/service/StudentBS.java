package com.jpa.hibernate.springboot.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.hibernate.springboot.dto.Passport;
import com.jpa.hibernate.springboot.dto.Student;
import com.jpa.hibernate.springboot.repository.StudentRepositoryBSI;

@Service
@Transactional
public class StudentBS implements StudentRepositoryBSI {

	private static final Logger LOGGER = LoggerFactory.getLogger(StudentBS.class);

	// @PersistenceContext: We can use this annotation also.
	@Autowired
	private EntityManager em;

	@Override
	public Student findById(long id) {
		return em.find(Student.class, id);
	}

	@Override
	public Student saveOrUpdate(Student student) {
		// It will update Student if Id matches otherwise it
		// will insert the new Student.
		if (student.getId() == null) {
			em.persist(student);
		} else {
			em.merge(student);
		}
		return student;
	}

	@Override
	public Student deleteStudentById(long id) {
		Student student = findById(id);
		em.remove(student);
		return student;
	}

	@Override
	public List<Student> findAllStudents() {
		return null;
	}

	@Override
	public Student saveStudentWithPassPort() {
		Student stu = new Student("Joshua Bloch");
		Passport pass = new Passport("B47811QWER");
		stu.setPassport(pass);
		em.persist(pass);
		em.persist(stu);
		return stu;
	}

	@Override
	public Student getStudentWithPassPort() {
		Student stu = em.find(Student.class, 2l);
		LOGGER.info("Student is {}", stu);
		return stu;
	}
}
