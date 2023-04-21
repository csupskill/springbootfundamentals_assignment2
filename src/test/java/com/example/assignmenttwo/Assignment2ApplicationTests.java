package com.example.assignmenttwo;

import com.example.assignmenttwo.entities.Student;
import com.example.assignmenttwo.repositories.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class Assignment2ApplicationTests {
	@Autowired
	StudentRepository studentRepo;

	@Test
	void test() {
		assertNotNull(studentRepo);

		Student testStudent = new Student();

		testStudent.setId(1);
		testStudent.setName("John Doe");
		testStudent.setTestScore(22);

		//create
		studentRepo.save(testStudent);

		assertEquals(1, studentRepo.findAll().size());

		//read
		testStudent = studentRepo.findById(1).orElse(null);
		assertNotNull(testStudent);

		//update
		testStudent.setTestScore(60);
		studentRepo.save(testStudent);

		testStudent = studentRepo.findById(1).orElse(null);
		assertNotNull(testStudent);
		assertEquals(60, testStudent.getTestScore());

		//delete
		studentRepo.deleteById(1);
		assertEquals(0, studentRepo.findAll().size());
	}
}
