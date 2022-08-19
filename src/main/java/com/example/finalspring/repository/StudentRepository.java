package com.example.finalspring.repository;


import com.example.finalspring.entity.Student;

import java.util.List;

public interface StudentRepository {
	public List<Student> getAllStudent();

	public Student getStudent(int id);

	public void addNewStudent(Student student);

	public void updateStudent(Student student);

	public void deleteStudent(int id);

}
