package com.example.learning.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.learning.model.Orders;
import com.example.learning.model.OrdersDTO;
import com.example.learning.model.ServicesDTO;
import com.example.learning.model.VendorCourses;
@Repository
public interface OrdersRepository extends CrudRepository<Orders, Integer> 
{
	@Query(value="SELECT * from Orders o where o.userId=?1",nativeQuery = true)
	List<Orders> findByUserId(int userid);

	@Query(value="SELECT * from Orders o where o.courseId=?1",nativeQuery = true)
	List<Orders> findByCoursesId(int courseId);
	
	@Query(value="SELECT * from Orders o where o.courseId=?1 and o.userId=?2",nativeQuery = true)
	Orders findByCoursesIdandUserId(int courseId, int userId);

	@Query( value="SELECT Orders.orderId,Orders.userId,Orders.courseId,Orders.paymentNo,courses_table.course_name,Orders.isComplete,"
			+ "Orders.serviceId from Orders JOIN courses_table where Orders.courseId=?1 and courses_table.course_id=?2",nativeQuery = true)
	List<VendorCourses> findByVendorCoursesId(int ocourseId,int ccourseId);
	
	@Query(value="select services.serviceId,services.serviceName from orders join services ON services.serviceId=orders.serviceId  where orders.userId=?1  group by services.serviceName;",nativeQuery=true)
	List<ServicesDTO> getAllServicesPurchasedByLearner(int userId);

	@Query(value="select * from orders where userId=?1 and serviceId=?2",nativeQuery=true)
	List<Orders> getAllCoursesForLearnerByService(int userId, int serviceId);
	
	@Query(value="select * from orders where courseId in (SELECT course_id from courses_table where serviceId=?1 and vendor_id=?2)",nativeQuery=true)
	List<OrdersDTO> getAllOrdersForVendorByServiceId(int serviceId,int vendorId);
}
