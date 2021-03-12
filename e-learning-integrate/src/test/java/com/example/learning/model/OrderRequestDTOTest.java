package com.example.learning.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class OrderRequestDTOTest {
	
	OrderRequestDTO or = new OrderRequestDTO();
	OrderRequestDTO or1 = new OrderRequestDTO(1,1,1);
	
	@Test
	public void testOrder() {
		or.setCourseid(1);
		or.setUserid(1);
		or.setServiceid(1);
		assertEquals(or.getCourseid(), 1);
		assertEquals(or.getUserid(), 1);
		assertEquals(or.getServiceid(), 1);
	}

}
