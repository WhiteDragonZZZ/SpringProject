package com.example.finalspring.repository;

import com.example.finalspring.entity.Faculty;
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

class FacultyRepositoryImpTest {
	@Mock
	SessionFactory sessionFactory;
	@InjectMocks
	FacultyRepositoryImp facultyRepositoryImp;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testAddStudentToFaculty() {
		facultyRepositoryImp.addStudentToFaculty(new Student(0, "name", "password", 0d, "role"));
	}

	@Test
	void testGetAllFaculty() {
		List<Faculty> result = facultyRepositoryImp.getAllFaculty();
		Assertions.assertEquals(Arrays.<Faculty>asList(new Faculty(0, "name", 0)), result);
	}
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme