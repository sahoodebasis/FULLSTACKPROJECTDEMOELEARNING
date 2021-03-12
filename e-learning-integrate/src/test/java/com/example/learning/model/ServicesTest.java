package com.example.learning.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ServicesTest {

	Services service = new Services();
	@Test
	void testNoArgsConstructor() {
		Services service1 = new Services();
		assertNotNull(service1);
	}
	@Test
	void testAllArgsConstructor() {
		Services service1 = new Services(1,"Online Training",true);
		assertNotNull(service1);
	}
	@Test
	void testServiceId() {
		service.setServiceId(1);
		assertEquals(1, service.getServiceId());
	}
	@Test
	void testServiceName() {
		service.setServiceName("service");
		assertEquals("service", service.getServiceName());
	}
	@Test
	void testServiceIsActive() {
		service.setActive(false);
		assertEquals(false, service.isActive());
	}
}
