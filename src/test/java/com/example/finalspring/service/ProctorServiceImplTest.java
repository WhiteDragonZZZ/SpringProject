package com.example.finalspring.service;

import com.example.finalspring.entity.Exam;
import com.example.finalspring.entity.Proctor;
import com.example.finalspring.repository.ProctorRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

class ProctorServiceImplTest {
	@Mock
	ProctorRepository proctorRepository;
	@InjectMocks
	ProctorServiceImpl proctorServiceImpl;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testShowAllProctor() {
		when(proctorRepository.getAllProctors()).thenReturn(Arrays.<Proctor>asList(new Proctor(0, "name", "work", new Exam(0, "name", "status"))));

		List<Proctor> result = proctorServiceImpl.showAllProctor();
		Assertions.assertEquals(Arrays.<Proctor>asList(new Proctor(0, "name", "work", new Exam(0, "name", "status"))), result);
	}

	@Test
	void testGetProctor() {
		when(proctorRepository.getProctor(anyInt())).thenReturn(new Proctor(0, "name", "work", new Exam(0, "name", "status")));

		Proctor result = proctorServiceImpl.getProctor(0);
		Assertions.assertEquals(new Proctor(0, "name", "work", new Exam(0, "name", "status")), result);
	}

	@Test
	void testUpdateProctor() {
		proctorServiceImpl.updateProctor(new Proctor(0, "name", "work", new Exam(0, "name", "status")));
	}

	@Test
	void testAddProctor() {
		proctorServiceImpl.addProctor(new Proctor(0, "name", "work", new Exam(0, "name", "status")));
	}

	@Test
	void testDeleteProctor() {
		proctorServiceImpl.deleteProctor(0);
	}
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme