package com.example.learning.service;

import java.util.List;

import com.example.learning.model.CourseDetails;
import com.example.learning.model.OrderRequestDTO;
import com.example.learning.model.Orders;
import com.example.learning.model.VendorCourses;

public interface OrdersService {
	public List<CourseDetails> getLearnerOrderedCourses(int userid) throws Exception;
	public String addOrder(OrderRequestDTO ord) throws Exception;
	public List<VendorCourses> getVendorCousesLearnerCount(int userid);
	public String updateCourseComplete(boolean iscomplete, int orderid, int userid);
	public Orders isCompleteCourse(int courseid, int userid);
}
