package com.example.finalspring.service;

import com.example.finalspring.entity.Exam;
import com.example.finalspring.repository.ExamRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

class ExamServiceImplTest {
	@Mock
	ExamRepository examRepository;
	@InjectMocks
	ExamServiceImpl examServiceImpl;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testAddExam() {
		examServiceImpl.addExam(new Exam(0, "name", "status"));
	}

	@Test
	void testCheckStatus() {
		examServiceImpl.checkStatus();
	}
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme