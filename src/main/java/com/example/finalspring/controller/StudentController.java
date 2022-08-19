package com.example.finalspring.controller;


import com.example.finalspring.entity.Student;
import com.example.finalspring.exceptionHandling.NoSuchStudentException;
import com.example.finalspring.exceptionHandling.StudentIncorrectData;
import com.example.finalspring.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student")
public class StudentController {

	private  final StudentService studentService;

	@Autowired
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}


	@GetMapping("/students/{id}")
	public Student getStudent(@PathVariable int id) {
		Student student = studentService.getStudent(id);
		if (student==null) {
			throw new NoSuchStudentException("There is no student with ID = "+id + " in Database");
		}
		return student;
	}

	@ExceptionHandler
	public ResponseEntity<StudentIncorrectData> handlerException(NoSuchStudentException exception) {
		StudentIncorrectData studentIncorrectData = new StudentIncorrectData();
		studentIncorrectData.setInfo(exception.getMessage());

		return new ResponseEntity<>(studentIncorrectData, HttpStatus.NOT_FOUND);
	}


	@PutMapping("/updateStudent")
	public Student updateStudent(@RequestBody Student student) {
		studentService.updateStudent(student);
		return student;
	}
}
