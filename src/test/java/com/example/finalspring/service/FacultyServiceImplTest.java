package com.example.finalspring.service;

import com.example.finalspring.entity.Faculty;
import com.example.finalspring.repository.FacultyRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

class FacultyServiceImplTest {
	@Mock
	FacultyRepository facultyRepository;
	@InjectMocks
	FacultyServiceImpl facultyServiceImpl;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testGetAllFaculty() {
		when(facultyRepository.getAllFaculty()).thenReturn(Arrays.<Faculty>asList(new Faculty(0, "name", 0)));

		List<Faculty> result = facultyServiceImpl.getAllFaculty();
		Assertions.assertEquals(Arrays.<Faculty>asList(new Faculty(0, "name", 0)), result);
	}
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme