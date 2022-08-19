package com.example.finalspring.repository;

import com.example.finalspring.entity.Proctor;
import com.example.finalspring.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class ProctorRepositoryImpl implements ProctorRepository{

	private final SessionFactory sessionFactory;

	@Autowired
	public ProctorRepositoryImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Proctor> getAllProctors() {
		Session session = sessionFactory.getCurrentSession();
		List<Proctor> showAllProctors = session.createQuery("from Proctor ",Proctor.class)
		                                       .getResultList();
		return showAllProctors;
	}

	@Override
	public Proctor getProctor(int id) {
		Session session = sessionFactory.getCurrentSession();
		Proctor proctor = session.get(Proctor.class,id);
		return proctor;
	}

	@Override
	public void addNewProctor(Proctor proctor) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(proctor);
	}

	@Override
	public void updateProctor(Proctor proctor) {
		Session session = sessionFactory.getCurrentSession();
		session.update(proctor);
	}

	@Override
	public void deleteProctor(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query<Proctor> query = session.createQuery("delete from Proctor "+" where id =:procId");
		query.setParameter("procId",id);
		query.executeUpdate();
	}
}
