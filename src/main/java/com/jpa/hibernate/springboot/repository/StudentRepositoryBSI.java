package com.jpa.hibernate.springboot.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jpa.hibernate.springboot.dto.Student;

@Repository
public interface StudentRepositoryBSI {

	public Student findById(long id);

	public Student saveOrUpdate(Student student);

	public Student deleteStudentById(long id);

	public List<Student> findAllStudents();
	
	public Student saveStudentWithPassPort();

	public Student getStudentWithPassPort();

}
