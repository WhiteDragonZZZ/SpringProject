package com.example.finalspring.service;

import com.example.finalspring.entity.Exam;
import com.example.finalspring.repository.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ExamServiceImpl implements ExamService {

	@Autowired
	private ExamRepository examRepository;

	@Override
	public void addExam(Exam exam) {
		examRepository.addNewProctor(exam);
	}

	@Scheduled(fixedRate = 1000)
	public void checkStatus() {

	}
}
