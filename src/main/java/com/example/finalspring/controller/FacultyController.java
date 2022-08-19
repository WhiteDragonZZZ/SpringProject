package com.example.finalspring.controller;


import com.example.finalspring.entity.Faculty;
import com.example.finalspring.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/faculty")
public class FacultyController {
	@Autowired
	FacultyService facultyService;

	@GetMapping("/faculties")
	public List<Faculty> showAllFaculty() {
		List<Faculty> allFaculty = facultyService.getAllFaculty();
		return allFaculty;
	}
}
