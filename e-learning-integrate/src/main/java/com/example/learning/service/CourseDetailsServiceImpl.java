package com.example.learning.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.learning.exception.CourseDetailsNotFoundException;
import com.example.learning.exception.UserNotFoundException;
import com.example.learning.model.CourseDetails;
import com.example.learning.model.Services;
import com.example.learning.repository.CourseDetailsRepository;
import com.example.learning.repository.ServicesRepository;
import com.example.learning.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CourseDetailsServiceImpl implements CourseDetailsService{
	
	@Autowired
	CourseDetailsRepository courseDetailsRepository;
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ServicesRepository serviceRepo;
	
	@Autowired
	NotificationService notificationService;


	public List<CourseDetails> getAllCoursesForServices(int serviceId) throws Exception {
		Services service = serviceRepo.findById(serviceId).get();
		if(service==null || service.isActive()==false) {
			throw new Exception();
		}
		List<CourseDetails> cdList = courseDetailsRepository.getAllCoursesLIst(serviceId);
		return cdList;
	}

	
	@Transactional
	public void addCourseDetails(CourseDetails courseDetails) {
		if((userRepository.findById(courseDetails.getVendorId()).isPresent()) && (userRepository.findById(courseDetails.getVendorId()).get().getRole().equalsIgnoreCase("vendor") )) {
			System.out.println(courseDetails.getService());
			courseDetailsRepository.save(courseDetails);
			if(courseDetails.isActive()==true) {
				notificationService.addNotification(courseDetails.getName());
			}
		}
		else 
			throw new UserNotFoundException("Vendor not found");
		//notification.save
	}
	
	@Transactional
	public List<CourseDetails> getAllCourseDetailsListUser() {
		log.info(" !!!!!!!!!!!!!!!!!!!!!!!!!!!!inside getallcoursedetailslistuser");
		List<CourseDetails> list = new ArrayList<>();
		list=courseDetailsRepository.getAllCourseDetailsListUser();
		if(list.size()!=0) {
			log.info("{}",list);
			log.info("######################before returning list value");
		return list;
		}
		else
			throw new CourseDetailsNotFoundException("Course details not found");
	}
	
	@Transactional
	public CourseDetails getCourseDetails(int courseId) {
		
		CourseDetails courseDetails= null;
		courseDetails= courseDetailsRepository.getCourseDetails(courseId);
		if(courseDetails==null)
			throw new CourseDetailsNotFoundException("Course details not found");
		
		else
			return courseDetails;
		
	}
	
	@Transactional
	public List<CourseDetails> getAllCourseDetailsListVendor(int vendorId) {
		if((userRepository.findById(vendorId).isPresent() ) && (userRepository.findById(vendorId).get().getRole().equalsIgnoreCase("vendor") )) {
			log.info("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
			log.info("{}",userRepository.findById(vendorId).get());
		List<CourseDetails> list = new ArrayList<>();
		list=courseDetailsRepository.getAllCourseDetailsListVendor(vendorId);
		if(list.size()!=0)
		return list;
		else
			throw new CourseDetailsNotFoundException("Course details not found");
		}
		else
			throw new UserNotFoundException("Vendor not found");
		
		
	}
	
	/*
	 * @Transactional public void removeCourseDetails(int courseId,int vendorId) {
	 * if((userRepository.findById(vendorId).isPresent()) &&
	 * (userRepository.findById(vendorId).get().getRole().equalsIgnoreCase("vendor")
	 * )) { if(courseDetailsRepository.findById(courseId).isPresent()) {
	 * courseDetailsRepository.removeCourseDetails(courseId); } else throw new
	 * CourseDetailsNotFoundException("Course details not found"); } else throw new
	 * UserNotFoundException("Vendor not found");
	 * 
	 * }
	 */
	@Override
	public CourseDetails getCourseDetailsByCourseId(int courseId) {
		// TODO Auto-generated method stub
		return courseDetailsRepository.findById(courseId).get();
	}
	

}
