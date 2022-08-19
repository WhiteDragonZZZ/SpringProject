package com.example.finalspring.controller;


import com.example.finalspring.entity.Audience;
import com.example.finalspring.service.AudienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/audiences")
public class AudienceController {
	@Autowired
	AudienceService audienceService;

	@GetMapping("/audience")
	public List<Audience> showALlAudience() {
		List<Audience> showAudience = audienceService.getAllAudience();
		return showAudience;
	}
}
