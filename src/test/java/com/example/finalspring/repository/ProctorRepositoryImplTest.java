package com.example.finalspring.repository;

import com.example.finalspring.entity.Exam;
import com.example.finalspring.entity.Proctor;
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

class ProctorRepositoryImplTest {
	@Mock
	SessionFactory sessionFactory;
	@InjectMocks
	ProctorRepositoryImpl proctorRepositoryImpl;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testGetAllProctors() {
		List<Proctor> result = proctorRepositoryImpl.getAllProctors();
		Assertions.assertEquals(Arrays.<Proctor>asList(new Proctor(0, "name", "work", new Exam(0, "name", "status"))), result);
	}

	@Test
	void testGetProctor() {
		Proctor result = proctorRepositoryImpl.getProctor(0);
		Assertions.assertEquals(new Proctor(0, "name", "work", new Exam(0, "name", "status")), result);
	}

	@Test
	void testAddNewProctor() {
		proctorRepositoryImpl.addNewProctor(new Proctor(0, "name", "work", new Exam(0, "name", "status")));
	}

	@Test
	void testUpdateProctor() {
		proctorRepositoryImpl.updateProctor(new Proctor(0, "name", "work", new Exam(0, "name", "status")));
	}

	@Test
	void testDeleteProctor() {
		proctorRepositoryImpl.deleteProctor(0);
	}
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme