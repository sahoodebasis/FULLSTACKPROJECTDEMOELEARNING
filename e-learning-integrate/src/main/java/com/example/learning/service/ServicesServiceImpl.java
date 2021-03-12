package com.example.learning.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.learning.exception.ListEmptyException;
import com.example.learning.exception.ServiceAlreadyPresentException;
import com.example.learning.exception.ServiceNotFoundException;
import com.example.learning.model.CourseDetails;
import com.example.learning.model.Orders;
import com.example.learning.model.OrdersDTO;
import com.example.learning.model.Services;
import com.example.learning.model.ServicesDTO;
import com.example.learning.repository.CourseDetailsRepository;
import com.example.learning.repository.OrdersRepository;
import com.example.learning.repository.ServicesRepository;

@Service
public class ServicesServiceImpl implements ServicesService {

	@Autowired
	ServicesRepository serviceRepo;

	@Autowired
	CourseDetailsRepository cd;

	@Autowired
	OrdersRepository or;

	@Override
	public List<Services> getAllServices() {
		List<Services> service = serviceRepo.findAll();
		return service;
	}

	@Override
	public String addService(Services service) {
		
		
		Services service1 = serviceRepo.findByServiceName(service.getServiceName());
		if(service1 == null)
		{
			//System.out.println(userRepo.findByEmail(user.getEmail()));
			serviceRepo.save(service);
			return "Added service Successfully";
		}
		else
			throw new ServiceAlreadyPresentException("Service already present");
		
	}

	@Override
	public String updateActiveStatus(boolean isActive, int serviceId)    {
		Services service = serviceRepo.findById(serviceId).orElse(null);
		if(service==null) {
			throw new ServiceNotFoundException("Service not found");
		}
		service.setActive(isActive);
		serviceRepo.save(service);
		return "activation status changed successfully";
	}





	//vendor

	@Override
	public List<ServicesDTO> getAllServicesForVendor(int vendorId)  {
		List<ServicesDTO> listService = cd.getAllServicesForVendor(vendorId);
		if(listService.isEmpty()) {
			throw new ServiceNotFoundException("Service not found");
		}
		return listService;
	}

	@Override
	public List<CourseDetails> getAllCoursesForVendorByService(int vendorId, int serviceId) {
		Services service = serviceRepo.findById(serviceId).orElse(null);
		if(service==null || service.isActive()==false) {
			throw new ServiceNotFoundException("Service not found");
		}
		List<CourseDetails> cdList = cd.getAllCoursesForVendorByService(vendorId,serviceId);
		if(cdList.isEmpty()) {
			throw new ListEmptyException();
		}
		return cdList;
	}


	//learner 

	@Override
	public List<ServicesDTO> getAllServicesPurchasedByLearner(int userId)  {
		List<ServicesDTO> listService = or.getAllServicesPurchasedByLearner(userId);
		if(listService.isEmpty()) {
			throw new ServiceNotFoundException("Service not found");
		}
		return listService;
	}

	@Override
	public List<Orders> getAllCoursesForLearnerByService(int userId, int serviceId)  {
		Services service = serviceRepo.findById(serviceId).orElse(null);
		if(service==null || service.isActive()==false) {
			throw new ListEmptyException();
		}
		List<Orders> cdList = or.getAllCoursesForLearnerByService(userId,serviceId);
		if(cdList.isEmpty()) {
			throw new ListEmptyException();
		}
		return cdList;
	}
	@Override
	public List<OrdersDTO> getAllOrdersForVendorByServiceId(int serviceId,int vendorId) {
		List<OrdersDTO> order = or.getAllOrdersForVendorByServiceId(serviceId,vendorId);
		if(order.isEmpty()) throw new ListEmptyException();
		System.out.println(order);
		return order;
	}

}
