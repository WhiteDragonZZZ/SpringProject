package com.example.finalspring.service;

import com.example.finalspring.entity.Student;

import java.util.List;

public interface StudentService {
	public List<Student> getAllStudent();

	public Student getStudent(int id);

	public void updateStudent(Student student);

	public void addStudent(Student student);

	public void deleteStudent(int id);
}
