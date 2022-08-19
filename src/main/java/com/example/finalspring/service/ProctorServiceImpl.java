package com.example.finalspring.service;

import com.example.finalspring.entity.Proctor;
import com.example.finalspring.repository.ProctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProctorServiceImpl implements ProctorService{

	private final ProctorRepository proctorRepository;

	@Autowired
	public ProctorServiceImpl(ProctorRepository proctorRepository) {
		this.proctorRepository = proctorRepository;
	}

	@Override
	public List<Proctor> showAllProctor() {
		return proctorRepository.getAllProctors();
	}

	@Override
	public Proctor getProctor(int id) {
		return proctorRepository.getProctor(id);
	}

	@Override
	public void updateProctor(Proctor proctor) {
		proctorRepository.updateProctor(proctor);
	}

	@Override

	public void addProctor(Proctor proctor) {
		proctorRepository.addNewProctor(proctor);
	}

	@Override
	public void deleteProctor(int id) {
		proctorRepository.deleteProctor(id);
	}
}
