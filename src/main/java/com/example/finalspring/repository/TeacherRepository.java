package com.example.finalspring.repository;

import com.example.finalspring.entity.Student;
import com.example.finalspring.entity.Teacher;

import java.util.List;

public interface TeacherRepository {
	public List<Teacher> getAllTeacher();

	public Teacher getTeacher(int id);

	public void addNewTeacher(Teacher teacher);

	public void updateTeacher(Teacher teacher);

	public void deleteTeacher(int id);
}
