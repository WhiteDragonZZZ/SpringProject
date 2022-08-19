package com.example.finalspring.controller;

import com.example.finalspring.entity.Exam;
import com.example.finalspring.entity.Proctor;
import com.example.finalspring.service.ProctorService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

class ProctorControllerTest {
	@Mock
	ProctorService proctorService;
	@InjectMocks
	ProctorController proctorController;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testShowAllProctor() {
		when(proctorService.showAllProctor()).thenReturn(Arrays.<Proctor>asList(new Proctor(0, "name", "work", new Exam(0, "name", "status"))));

		List<Proctor> result = proctorController.showAllProctor();
		Assertions.assertEquals(Arrays.<Proctor>asList(new Proctor(0, "name", "work", new Exam(0, "name", "status"))), result);
	}
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme