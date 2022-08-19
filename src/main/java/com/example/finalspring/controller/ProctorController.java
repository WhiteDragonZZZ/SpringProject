package com.example.finalspring.controller;


import com.example.finalspring.entity.Proctor;
import com.example.finalspring.service.ProctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/proctors")
public class ProctorController {

	@Autowired
	private  ProctorService proctorService;





	@GetMapping("/showProctors")
	public List<Proctor> showAllProctor() {
		List<Proctor> proctorsList = proctorService.showAllProctor();
		return proctorsList;
	}
}
