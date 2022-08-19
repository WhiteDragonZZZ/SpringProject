package com.example.finalspring.service;

import com.example.finalspring.entity.Audience;
import com.example.finalspring.repository.AudienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AudienceServiceImpl implements AudienceService{

	@Autowired
	AudienceRepository audienceRepository;

	@Override
	@Transactional
	public List<Audience> getAllAudience() {
		try {
			 audienceRepository.showAllAudience();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return audienceRepository.showAllAudience();
	}
}
