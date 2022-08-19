package com.example.finalspring.controller;


import com.example.finalspring.entity.Student;
import com.example.finalspring.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/staff/api")
public class TeacherController {

	private final StudentService studentService;

	@Autowired
	public TeacherController(StudentService studentService) {
		this.studentService = studentService;
	}

	@GetMapping("/students")
	public List<Student> showAllStudents() {
		List<Student> allStudents = studentService.getAllStudent();
		return allStudents;
	}

	@PostMapping("/addStudent")
	public Student addStudent(@RequestBody Student student) {
		studentService.addStudent(student);
		return student;
	}

	@DeleteMapping("/deleteStudent/{id}")
	public String deleteStudent(@PathVariable int id) {
		studentService.deleteStudent(id);

		return "Student with ID = "+ id + " was deleted";
	}


}
