package com.example.finalspring.service;

import com.example.finalspring.entity.Student;
import com.example.finalspring.entity.Teacher;

import java.util.List;

public interface TeacherService {
	public List<Teacher> getAllTeacher();

	public Teacher getTeacher(int id);

	public void updateTeacher(Teacher Teacher);

	public void addTeacher(Teacher Teacher);

	public void deleteTeacher(int id);
}
