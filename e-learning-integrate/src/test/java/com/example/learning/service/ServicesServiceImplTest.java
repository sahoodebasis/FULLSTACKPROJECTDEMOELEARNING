package com.example.learning.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.learning.exception.ListEmptyException;
import com.example.learning.exception.ServiceAlreadyPresentException;
import com.example.learning.exception.ServiceNotFoundException;
import com.example.learning.model.CourseDetails;
import com.example.learning.model.Services;
import com.example.learning.repository.CourseDetailsRepository;
import com.example.learning.repository.OrdersRepository;
import com.example.learning.repository.ServicesRepository;


@SpringBootTest
public class ServicesServiceImplTest {

	@InjectMocks
	ServicesServiceImpl servicesService;
	
	@Mock
	CourseDetailsRepository courseDetailsRepo;
	
	@Mock
	OrdersRepository orderRepo;
	
	@Mock
	ServicesRepository serviceRepo;
	
	@Test
	void testGetAllServices() {
		List<Services> services = new ArrayList<Services>();
		Services service = new Services(1,"Online Training",true);
		services.add(service);
		when(serviceRepo.findAll()).thenReturn(services);
		assertThat(servicesService.getAllServices()).size().isGreaterThan(0);
	}
	@Test
	void testAddService() throws Exception {
		Services service = new Services(1,"Online Training",true);
		when(serviceRepo.save(service)).thenReturn(service);
		assertThat(servicesService.addService(service)).isEqualTo("Added service Successfully" );
	}
	@Test
	void testAddServiceException() {
		Services service = new Services(1,"Online Training",true);
		when(serviceRepo.findByServiceName("Online Training")).thenReturn(service);
		Assertions.assertThrows(ServiceAlreadyPresentException.class, ()->servicesService.addService(service));
	}
	@Test
	void testUpdateActiveStatus() throws Exception {
		Services service = new Services(1,"Online Training",true);
		Optional<Services> data = Optional.of(service);
		when(serviceRepo.findById(1)).thenReturn(data);
		assertThat(servicesService.updateActiveStatus(true,1)).isEqualTo("activation status changed successfully");
	}
	@Test
	void testUpdateActiveStatusException() {
		Services service1 = new Services();
		Optional<Services> data = Optional.of(service1);
		when(serviceRepo.findById(1)).thenReturn(data);
		assertThrows(ServiceNotFoundException.class, ()->servicesService.updateActiveStatus(true,2));
	}
	
	@Test
	void getAllCoursesForVendorByServiceException1() {
		Services service1 = new Services(1,"Online Training",false);
		Optional<Services> data = Optional.of(service1);
		when(serviceRepo.findById(1)).thenReturn(data);
		assertThrows(ServiceNotFoundException.class, ()->servicesService.getAllCoursesForVendorByService(1, 1));
	}
	@Test
	void getAllCoursesForVendorByService() throws Exception {
		Services service1 = new Services(1,"Online Training",true);
		Optional<Services> data = Optional.of(service1);
		when(serviceRepo.findById(1)).thenReturn(data);
		List<CourseDetails> list = new ArrayList<CourseDetails>();
		CourseDetails courseDetails1=new CourseDetails(1,"abc", "abc", "abc", 1, true, 1, 1,
				new SimpleDateFormat("dd/mm/yyyy").parse("28/01/1998"), "abc", "abc", "abc", "abc", "abc", "abc", null);
		list.add(courseDetails1);
		when(courseDetailsRepo.getAllCoursesForVendorByService(1,1)).thenReturn(list);
		assertThat(servicesService.getAllCoursesForVendorByService(1, 1)).size().isEqualTo(1); 
	}
	@Test
	void getAllCoursesForVendorByServiceException2() {
		Services service1 = new Services(1,"Online Training",true);
		Optional<Services> data = Optional.of(service1);
		when(serviceRepo.findById(1)).thenReturn(data);
		List<CourseDetails> list = new ArrayList<CourseDetails>();
		when(courseDetailsRepo.getAllCoursesForVendorByService(1,1)).thenReturn(list);
		assertThrows(ListEmptyException.class, ()->servicesService.getAllCoursesForVendorByService(1, 1));
	}
}
