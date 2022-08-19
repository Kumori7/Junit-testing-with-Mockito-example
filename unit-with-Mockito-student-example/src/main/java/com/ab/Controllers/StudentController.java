package com.ab.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ab.Entities.Student;
import com.ab.Services.StudentServiceImpl;

@RestController
public class StudentController {

	@Autowired
	private StudentServiceImpl serviceImpl;

	@PostMapping("/save")
	public Student saveStudent(@RequestBody Student student) {

		return serviceImpl.addStudent(student);
	}

	@GetMapping("/getStudents")
	public List<Student> findStudents() {
		return serviceImpl.findAllStudents();
	}

	@GetMapping("/findStudentBySchool/{school}")
	public List<Student> findStudentsBySchool(@PathVariable String school) {

		return serviceImpl.findBySchool(school);
	}

	@DeleteMapping("/remove")
	public Student remoStudent(@RequestBody Student student) {
		serviceImpl.deleteStudent(student);
		return student;
	}

}
