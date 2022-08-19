package com.example.finalspring.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ExamTest {
	Exam exam = new Exam(0, "name", "status");

	@Test
	void testToString() {
		String result = exam.toString();
		Assertions.assertEquals("replaceMeWithExpectedResult", result);
	}
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme