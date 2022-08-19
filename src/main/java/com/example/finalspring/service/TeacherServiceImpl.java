package com.example.finalspring.service;

import com.example.finalspring.entity.Teacher;
import com.example.finalspring.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService{

	@Autowired
	private TeacherRepository teacherRepository;

	@Override
	@Transactional
	public List<Teacher> getAllTeacher() {
		return teacherRepository.getAllTeacher();
	}

	@Override
	@Transactional
	public Teacher getTeacher(int id) {
		return teacherRepository.getTeacher(id);
	}

	@Override
	@Transactional
	public void updateTeacher(Teacher teacher) {
		teacherRepository.updateTeacher(teacher);
	}

	@Override
	@Transactional
	public void addTeacher(Teacher teacher) {
		teacherRepository.addNewTeacher(teacher);
	}

	@Override
	@Transactional
	public void deleteTeacher(int id) {
		teacherRepository.deleteTeacher(id);
	}
}
