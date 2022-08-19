package com.example.finalspring.repository;

import com.example.finalspring.entity.Proctor;
import com.example.finalspring.entity.Student;

import java.util.List;

public interface ProctorRepository {
	public List<Proctor> getAllProctors();
	public Proctor getProctor(int id);

	public void addNewProctor(Proctor proctor);

	public void updateProctor(Proctor proctor);

	public void deleteProctor(int id);
}
