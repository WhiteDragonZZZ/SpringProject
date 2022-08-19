package com.example.finalspring.repository;

import com.example.finalspring.entity.Faculty;
import com.example.finalspring.entity.Student;

import java.util.List;

public interface FacultyRepository {
	public void addStudentToFaculty(Student student);
	public List<Faculty> getAllFaculty();
}
