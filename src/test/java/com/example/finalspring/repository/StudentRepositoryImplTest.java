package com.example.finalspring.repository;

import com.example.finalspring.entity.Student;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

class StudentRepositoryImplTest {
	@Mock
	SessionFactory sessionFactory;
	@InjectMocks
	StudentRepositoryImpl studentRepositoryImpl;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testGetAllStudent() {
		List<Student> result = studentRepositoryImpl.getAllStudent();
		Assertions.assertEquals(Arrays.<Student>asList(new Student(0, "name", "password", 0d, "role")), result);
	}

	@Test
	void testGetStudent() {
		Student result = studentRepositoryImpl.getStudent(0);
		Assertions.assertEquals(new Student(0, "name", "password", 0d, "role"), result);
	}

	@Test
	void testAddNewStudent() {
		studentRepositoryImpl.addNewStudent(new Student(0, "name", "password", 0d, "role"));
	}

	@Test
	void testUpdateStudent() {
		studentRepositoryImpl.updateStudent(new Student(0, "name", "password", 0d, "role"));
	}

	@Test
	void testDeleteStudent() {
		studentRepositoryImpl.deleteStudent(0);
	}
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme