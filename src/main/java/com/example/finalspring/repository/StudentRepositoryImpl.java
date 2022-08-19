package com.example.finalspring.repository;

import com.example.finalspring.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentRepositoryImpl implements StudentRepository {


	private final SessionFactory sessionFactory;


	@Autowired
	public StudentRepositoryImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	@Override
	@Transactional()
	public List<Student> getAllStudent() {

        Session session = sessionFactory.getCurrentSession();
		List<Student> allStudent = session.createQuery("from Student ",Student.class).getResultList();

		return allStudent;
	}

	@Override
	public Student getStudent(int id) {
		Session session = sessionFactory.getCurrentSession();
		Student student = session.get(Student.class,id);

		return student;
	}

	@Override
	public void addNewStudent(Student student) {
		Session session = sessionFactory.getCurrentSession();
		session.save(student);

	}

	@Override
	public void updateStudent(Student student) {
		Session session = sessionFactory.getCurrentSession();
		session.update(student);
	}

	@Override
	public void deleteStudent(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query<Student> query = session.createQuery("delete from Student " +
				"where id =:studId");
		query.setParameter("studId",id);
		query.executeUpdate();
	}


}
