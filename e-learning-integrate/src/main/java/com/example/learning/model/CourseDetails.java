package com.example.learning.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
@Table(name="courses_table")
public class CourseDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "course_id")
	private int courseId;
	
	@NotEmpty(message = "Please provide course category")
	@Size(min = 2, max = 20, message = "Size within 2 to 20..")	
	@Column(name = "course_category")
	private String courseCategory;
	
	@NotNull(message = "Please provide name")
	@Column(name = "course_name")
	private String name;
	
	@NotEmpty(message = "Please provide short description")
	@Column(name = "short_description")
	private String shortDescription;
	
	@Min(1)
	@Column(name = "vendor_id")
	private int vendorId;
	
	@NotNull(message = "Please provide true/false")
	@Column(name = "is_active")
	private boolean isActive;
	
	@Min(1)
	@Column(name = "price")
	private int price;
	
	@Min(1)
	@Column(name = "duration")
	private int duration;
	
	@NotNull(message = "Please provide date of launch")
	@Temporal(TemporalType.DATE)
	@Column(name = "date_of_launch")
	private Date dateOfLaunch;
	
//	@Column(name = "noOfSubscription")
//	private int noOfSubscription;
	
	@NotEmpty(message = "Please provide url of picture")
	@Column(name = "picture")
	private String picture;
	
	@NotEmpty(message = "Please provide languages supported")
	@Column(name = "languages")
	private String languages;
	
	@NotEmpty(message = "Please provide learning goals")
	@Column(name = "learning_goals")
	private String learningGoals;
	
	@NotEmpty(message = "Please provide pre-requirements")
	@Column(name = "requirements")
	private String requirements;
	
	@NotEmpty(message = "Please provide pre-requirements")
	@Column(name = "course_description",length=800)
	private String description;
	
	@NotEmpty(message = "Please provide author name")
	@Column(name = "author")
	private String author;
	
	@ManyToOne
	@JoinColumn(name = "serviceId")
	private Services service;
	
	//instead of vendorid write many to one private user  user;
	
//	@OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL )
//	 @JoinColumn(name="fk_cd_cdt")
//	private CourseDescription courseDescription;
	
//	@OneToMany(mappedBy="course",fetch = FetchType.EAGER)
//	private List<Orders> orders=new ArrayList<Orders>();

	
	
//	@OneToMany(mappedBy="courseDetails",fetch = FetchType.EAGER)
//	private List<Review> review=new ArrayList<Review>();
	
}
