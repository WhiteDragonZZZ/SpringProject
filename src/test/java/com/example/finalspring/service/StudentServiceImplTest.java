package com.example.finalspring.service;

import com.example.finalspring.entity.Student;
import com.example.finalspring.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

class StudentServiceImplTest {
	@Mock
	StudentRepository studentRepository;
	@InjectMocks
	StudentServiceImpl studentServiceImpl;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testGetAllStudent() {
		when(studentRepository.getAllStudent()).thenReturn(Arrays.<Student>asList(new Student(0, "name", "password", 0d, "role")));

		List<Student> result = studentServiceImpl.getAllStudent();
		Assertions.assertEquals(Arrays.<Student>asList(new Student(0, "name", "password", 0d, "role")), result);
	}

	@Test
	void testGetStudent() {
		when(studentRepository.getStudent(anyInt())).thenReturn(new Student(0, "name", "password", 0d, "role"));

		Student result = studentServiceImpl.getStudent(0);
		Assertions.assertEquals(new Student(0, "name", "password", 0d, "role"), result);
	}

	@Test
	void testUpdateStudent() {
		studentServiceImpl.updateStudent(new Student(0, "name", "password", 0d, "role"));
	}

	@Test
	void testAddStudent() {
		studentServiceImpl.addStudent(new Student(0, "name", "password", 0d, "role"));
	}

	@Test
	void testDeleteStudent() {
		studentServiceImpl.deleteStudent(0);
	}
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme