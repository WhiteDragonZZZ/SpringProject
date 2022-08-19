package com.example.finalspring.repository;

import com.example.finalspring.entity.Audience;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

class AudienceRepositoryImplTest {
	@Mock
	SessionFactory sessionFactory;
	@InjectMocks
	AudienceRepositoryImpl audienceRepositoryImpl;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testShowAllAudience() {
		List<Audience> result = audienceRepositoryImpl.showAllAudience();
		Assertions.assertEquals(Arrays.<Audience>asList(new Audience(0, 0, "audience")), result);
	}
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme