package com.example.finalspring.repository;

import com.example.finalspring.entity.Faculty;
import com.example.finalspring.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class FacultyRepositoryImp implements FacultyRepository {


	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addStudentToFaculty(Student student) {

	}

	@Override
	public List<Faculty> getAllFaculty() {
		Session session = sessionFactory.getCurrentSession();
		List<Faculty> allFaculty = session.createQuery("from Faculty ",Faculty.class).getResultList();

		return allFaculty;
	}
}
