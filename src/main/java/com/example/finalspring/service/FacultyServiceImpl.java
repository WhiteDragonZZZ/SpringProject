package com.example.finalspring.service;

import com.example.finalspring.entity.Faculty;
import com.example.finalspring.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FacultyServiceImpl implements FacultyService{
	@Autowired
	FacultyRepository facultyRepository;

	@Override
	@Transactional
	public List<Faculty> getAllFaculty() {
		return facultyRepository.getAllFaculty();
	}
}
