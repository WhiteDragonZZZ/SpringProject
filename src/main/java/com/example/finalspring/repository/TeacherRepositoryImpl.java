package com.example.finalspring.repository;

import com.example.finalspring.entity.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TeacherRepositoryImpl implements TeacherRepository {

	private final SessionFactory sessionFactory;

	@Autowired
	public TeacherRepositoryImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Teacher> getAllTeacher() {
		Session session = sessionFactory.getCurrentSession();
		List<Teacher> teachers = session.createQuery("from Teacher ",Teacher.class).getResultList();
		return teachers;
	}

	@Override
	public Teacher getTeacher(int id) {
		Session session = sessionFactory.getCurrentSession();
		Teacher teacher = session.get(Teacher.class,id);
		return teacher;
	}

	@Override
	public void addNewTeacher(Teacher teacher) {
		Session session = sessionFactory.getCurrentSession();
		session.save(teacher);
	}

	@Override
	public void updateTeacher(Teacher teacher) {
		Session session = sessionFactory.getCurrentSession();
		session.update(teacher);
	}

	@Override
	public void deleteTeacher(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query<Teacher> query = session.createQuery("delete from Teacher "+ " where id =:techId");
		query.setParameter("techId",id);
		query.executeUpdate();
	}
}
