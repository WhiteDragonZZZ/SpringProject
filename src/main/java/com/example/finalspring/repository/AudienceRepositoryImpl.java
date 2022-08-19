package com.example.finalspring.repository;

import com.example.finalspring.entity.Audience;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AudienceRepositoryImpl implements AudienceRepository{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Audience> showAllAudience() {
		Session session = sessionFactory.getCurrentSession();
		List<Audience> allAudience = session.createQuery("from Audience ",Audience.class).getResultList();
		return allAudience;
	}
}
