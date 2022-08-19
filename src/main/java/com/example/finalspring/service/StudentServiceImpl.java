package com.example.finalspring.service;

import com.example.finalspring.entity.Student;
import com.example.finalspring.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	StudentRepository studentRepository;
	@Override
	@Transactional
	public List<Student> getAllStudent() {
		return studentRepository.getAllStudent();
	}

	@Override
	@Transactional
	public Student getStudent(int id) {
		return studentRepository.getStudent(id);
	}

	@Override
	@Transactional
	public void updateStudent(Student student) {
		studentRepository.updateStudent(student);
	}

	@Override
	@Transactional
	public void addStudent(Student student) {
		studentRepository.addNewStudent(student);
	}

	@Override
	@Transactional
	public void deleteStudent(int id) {
		studentRepository.deleteStudent(id);
	}
}
