package com.example.learning.service;

import java.util.List;

import com.example.learning.model.CourseDetails;
import com.example.learning.model.Orders;
import com.example.learning.model.OrdersDTO;
import com.example.learning.model.Services;
import com.example.learning.model.ServicesDTO;

public interface ServicesService {

	public List<Services> getAllServices();
	public String addService(Services service) throws Exception;
	public String updateActiveStatus(boolean isActive,int serviceId) throws Exception ;
	public List<ServicesDTO> getAllServicesForVendor(int vendorId) throws Exception;
	public List<CourseDetails> getAllCoursesForVendorByService(int vendorId, int serviceId) throws Exception;
	public List<ServicesDTO> getAllServicesPurchasedByLearner(int userId) throws Exception;
	public List<Orders> getAllCoursesForLearnerByService(int userId, int serviceId) throws Exception ;
	public List<OrdersDTO> getAllOrdersForVendorByServiceId(int serviceId,int vendorId) throws Exception;
}
