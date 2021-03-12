package com.example.learning.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.learning.model.CourseDetails;
import com.example.learning.model.ServicesDTO;

@Repository
public interface CourseDetailsRepository extends JpaRepository<CourseDetails, Integer> {
	
	
	@Query("select u from CourseDetails u where u.isActive=true order by u.dateOfLaunch desc")
	List<CourseDetails> getAllCourseDetailsListUser();
	
	@Query("select u from CourseDetails u where u.isActive=true and u.courseId=:courseId")
	CourseDetails getCourseDetails(@Param("courseId") int courseId);
	
	@Query("select u from CourseDetails u where u.vendorId=:vendorId")
	List<CourseDetails> getAllCourseDetailsListVendor(@Param("vendorId") int vendorId);
	
	@Query(value="select cd.courseId from CourseDetails cd where cd.vendorId=?1")
	List<Integer> findByVendorId(int userid);

	@Query(value="select * from courses_table where serviceId=?1 and is_active=true",nativeQuery=true)
	List<CourseDetails> getAllCoursesLIst(int serviceId);

	@Query(value="select services.serviceId,services.serviceName from courses_table join services ON services.serviceId=courses_table.serviceId  where courses_table.vendor_id=?1  group by services.serviceName;",nativeQuery=true)
	List<ServicesDTO> getAllServicesForVendor(int vendorId);

	@Query(value="select * from courses_table where vendor_id=?1 and serviceId=?2",nativeQuery=true)
	List<CourseDetails> getAllCoursesForVendorByService(int vendorId, int serviceId);


}
