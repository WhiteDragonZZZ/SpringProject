package com.example.finalspring.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

class StudentTest {
	@Mock
	Faculty faculty;
	@InjectMocks
	Student student;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testInit() {
		student.init();
	}

	@Test
	void testDestroy() {
		student.destroy();
	}

	@Test
	void testToString() {
		String result = student.toString();
		Assertions.assertEquals("replaceMeWithExpectedResult", result);
	}
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme