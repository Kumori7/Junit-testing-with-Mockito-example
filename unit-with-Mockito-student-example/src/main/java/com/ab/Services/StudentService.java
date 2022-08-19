package com.ab.Services;

import java.util.List;


import com.ab.Entities.Student;

public interface StudentService {

	public Student addStudent(Student student);
	
	public List<Student> findAllStudents();
	
	 public List<Student> findBySchool(String school);
	
	 public void deleteStudent(Student student);
	

}
