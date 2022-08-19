package com.example.finalspring.repository;

import com.example.finalspring.entity.Exam;
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

class ExamRepositoryImplTest {
	@Mock
	SessionFactory sessionFactory;
	@InjectMocks
	ExamRepositoryImpl examRepositoryImpl;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testAddNewProctor() {
		examRepositoryImpl.addNewProctor(new Exam(0, "name", "status"));
	}

	@Test
	void testGetAllExam() {
		List<Exam> result = examRepositoryImpl.getAllExam();
		Assertions.assertEquals(Arrays.<Exam>asList(new Exam(0, "name", "status")), result);
	}
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme