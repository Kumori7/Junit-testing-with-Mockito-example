package com.ab.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ab.Entities.Student;
import com.ab.Repositories.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository repository;

	@Override
	public Student addStudent(Student student) {

		return repository.save(student);
	}

	@Override
	public List<Student> findAllStudents() {

		List<Student> list = repository.findAll();

		return list;
	}

	@Override
	public List<Student> findBySchool(String school) {
		
		return repository.findBySchool(school);
	}

	@Override
	public void deleteStudent(Student student) {
		
		repository.delete(student);
		
	}

} // end of method
