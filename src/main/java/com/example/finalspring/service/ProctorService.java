package com.example.finalspring.service;

import com.example.finalspring.entity.Proctor;
import com.example.finalspring.entity.Student;

import java.util.List;

public interface ProctorService {
	public List<Proctor> showAllProctor();
	public Proctor getProctor(int id);

	public void updateProctor(Proctor proctor);

	public void addProctor(Proctor proctor);

	public void deleteProctor(int id);
}
