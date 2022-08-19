package com.example.finalspring.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.Mockito.*;

class FacultyTest {
	@Mock
	List<Student> students;
	@InjectMocks
	Faculty faculty;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testInit() {
		faculty.init();
	}

	@Test
	void testDestroy() {
		faculty.destroy();
	}

	@Test
	void testToString() {
		String result = faculty.toString();
		Assertions.assertEquals("replaceMeWithExpectedResult", result);
	}
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme