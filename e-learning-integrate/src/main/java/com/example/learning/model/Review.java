package com.example.learning.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter 
@Setter 
@NoArgsConstructor 
@AllArgsConstructor
@Entity
@ToString
@Table(name="review")
public class Review {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer reviewId;
	@Column(length=500)
	private String description;
	
	@ManyToOne
	@JoinColumn(name="courseId")
	private CourseDetails courseDetails;
	
	@ManyToOne
	@JoinColumn(name="userId")
	private User user;
	
	
	
	public Review(Integer reviewId,CourseDetails courseDetails,User user) {
		super();
		this.reviewId = reviewId;
		this.courseDetails=courseDetails;
		this.user=user;
		
	}
	
	
	public Review(Integer reviewId,CourseDetails courseDetails) {
		super();
		this.reviewId = reviewId;
		this.courseDetails=courseDetails;
	
	}

	public Review(Integer reviewId,CourseDetails courseDetails,User user,String description) {
		super();
		this.reviewId = reviewId;
		this.courseDetails=courseDetails;
		this.user=user;
		this.description=description;
		
	}
	
	
	
}
