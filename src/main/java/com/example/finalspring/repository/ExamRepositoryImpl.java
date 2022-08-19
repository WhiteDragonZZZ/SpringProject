package com.example.finalspring.repository;

import com.example.finalspring.entity.Exam;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ExamRepositoryImpl implements ExamRepository{

	private final SessionFactory sessionFactory;

	@Autowired
	public ExamRepositoryImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addNewProctor(Exam exam) {
		Session session = sessionFactory.getCurrentSession();
		session.save(exam);
	}

	@Override
	public List<Exam> getAllExam() {
		return null;
	}
}
