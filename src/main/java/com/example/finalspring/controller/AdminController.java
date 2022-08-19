package com.example.finalspring.controller;


import com.example.finalspring.entity.*;
import com.example.finalspring.exceptionHandling.NoSuchTeacherException;
import com.example.finalspring.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/api")
public class AdminController {
	private final ProctorService proctorService;
	private final StudentService studentService;
	private final TeacherService teacherService;

	private final FacultyService facultyService;


	@Autowired
	private ExamService examService;

	@Autowired
	public AdminController(ProctorService proctorService, StudentService studentService, TeacherService teacherService, FacultyService facultyService) {
		this.proctorService = proctorService;
		this.studentService = studentService;
		this.teacherService = teacherService;
		this.facultyService = facultyService;
	}


	@GetMapping("/proctor/{id}")
	public Proctor getProctor(@PathVariable int id) {
		return proctorService.getProctor(id);
	}

	@PostMapping("/addProctor")
	public Proctor addProctor(@RequestBody Proctor proctor) {
		proctorService.addProctor(proctor);
		return proctor;
	}

	@PostMapping("/addExam")
	public Exam addExam(@RequestBody Exam exam) {
		examService.addExam(exam);
		return exam;
	}

	@GetMapping("/students")
	public List<Student> showAllStudents() {
		List<Student> allStudents = studentService.getAllStudent();
		return allStudents;
	}

	@DeleteMapping("/deleteStudent/{id}")
	public String deleteStudent(@PathVariable int id) {
		studentService.deleteStudent(id);

		return "Student with ID = "+ id + " was deleted";
	}

	@GetMapping("/teachers")
	public List<Teacher> showAllTeachers() {
		List<Teacher> allTeachers = teacherService.getAllTeacher();
		return allTeachers;
	}

	@GetMapping("/teacher/{id}")
	public Teacher getTeacher(@PathVariable int id) {
		Teacher teacher = teacherService.getTeacher(id);
		if (teacher == null) {
			throw new NoSuchTeacherException("There is no teacher with ID = "+id + " in Database");
		}
		return teacher;
	}


	@PutMapping("/updateTeacher")
	public Teacher updateTeacher(@RequestBody Teacher teacher) {
		teacherService.updateTeacher(teacher);
		return teacher;
	}

	@PostMapping("/addTeacher")
	public Teacher addTeacher(@RequestBody Teacher teacher) {
		teacherService.addTeacher(teacher);
		return teacher;
	}

	@DeleteMapping("/deleteTeacher/{id}")
	public String deleteTeacher(@PathVariable int id) {
		teacherService.deleteTeacher(id);
		return "Teacher with ID " + id + "was deleted";
	}

	@GetMapping("/faculties")
	public List<Faculty> showAllFaculty() {
		List<Faculty> allFaculty = facultyService.getAllFaculty();
		return allFaculty;
	}



}
