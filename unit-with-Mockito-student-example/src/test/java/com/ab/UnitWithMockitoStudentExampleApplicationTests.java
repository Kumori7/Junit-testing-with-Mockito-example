package com.ab;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.ab.Entities.Student;
import com.ab.Repositories.StudentRepository;
import com.ab.Services.StudentServiceImpl;

//@RunWith provides a bridge between spring boot test features and Junit
@RunWith(SpringRunner.class)
@SpringBootTest
class UnitWithMockitoStudentExampleApplicationTests {

	@Autowired
	private StudentServiceImpl serviceImpl;

	// we want to mock the repository by creating a fake version of our DB
	// so the unit test does not interact with our real DB
	@MockBean
	private StudentRepository repository;

	@Test
	public void getStudentsTest() {
		Student s1 = new Student(66, "Rakin", 23, "schoolY");
		Student s2 = new Student(62, "Sam", 33, "schoolB");
		Student s3 = new Student(33, "Sarah", 25, "schoolA");

		// "when" we call a repository method we want to "return" the mock data instead
		// of accessing the DB itself
		when(repository.findAll()).thenReturn(Stream.of(s1, s2, s3).collect(Collectors.toList()));

		// here we are testing if the expected input of 3 students match ..
		// findAllStudents()
		// if 3 student match this List.size() test case passes
		assertEquals(3, serviceImpl.findAllStudents().size());

	}

	@Test
	public void getStudentBySchoolTest() {

		String school = "schoolX";

		Student student = new Student(55, "Jake", 21, "schoolW");

		when(repository.findBySchool(school)).thenReturn(Stream.of(student).collect(Collectors.toList()));

		// we are only getting one data from DB so we only expect value of 1
		// we are comparing the size against out expected output
		assertEquals(1, serviceImpl.findBySchool(school).size());

	}

	@Test
	public void saveStudentTest() {

		Student student = new Student(111, "Niyaz", 23, "schoolA");
		when(repository.save(student)).thenReturn(student);

		// input the student we want to save
		// output = what we get from service layer
		assertEquals(student, serviceImpl.addStudent(student));
	}
	
	@Test
	public void deleteStudentTest() {
		// deleting the student we created for testing purpose 
		
		Student student = new Student(111, "Niyaz", 23, "schoolA");

		serviceImpl.deleteStudent(student);
		// due to no return type for deleteStudent() we cannot use assertEquals()
		// we can verify if our method is called or not instead
		// we want to verify our mock data (from repo)
		// we want to verify if it was called once by using times() method
		// then call the method we want response from
		
		verify(repository,times(1)).delete(student);
		
	}

} // end of class
