package com.example.finalspring.repository;

import com.example.finalspring.entity.Exam;
import com.example.finalspring.entity.Proctor;

import java.util.List;

public interface ExamRepository {
	public void addNewProctor(Exam exam);
	public List<Exam> getAllExam();
}
