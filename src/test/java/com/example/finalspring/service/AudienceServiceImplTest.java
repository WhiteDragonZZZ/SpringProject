package com.example.finalspring.service;

import com.example.finalspring.entity.Audience;
import com.example.finalspring.repository.AudienceRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

class AudienceServiceImplTest {
	@Mock
	AudienceRepository audienceRepository;
	@InjectMocks
	AudienceServiceImpl audienceServiceImpl;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testGetAllAudience() {
		when(audienceRepository.showAllAudience()).thenReturn(Arrays.<Audience>asList(new Audience(0, 0, "audience")));

		List<Audience> result = audienceServiceImpl.getAllAudience();
		Assertions.assertEquals(Arrays.<Audience>asList(new Audience(0, 0, "audience")), result);
	}
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme