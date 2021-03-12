package com.example.learning.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity(name = "user")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userid")
	private Integer userId;
	@NotEmpty(message = "Email should not be empty")
	@Email(message = "Email should be of the pattern \"[a-zA-Z0-9]@"
			+ "[a-zA-Z0-9].[a-zA-Z0-9]")
	private String email;
	@Size(min=4, max=50,message = "Size should be between 4-50")
	private String name;
	@Size(min=10,max=10,message="Contact number should be of 10 digits")
	private String contactNo;
	@Size(min=6, message="password should be minimum 6 letters")
	private String password;
	private String role;
	private Boolean isActive;
	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;
	private Boolean hasSubscribed;
	
	public User(
			@NotEmpty(message = "Email should not be empty") @Email(message = "Email should be of the pattern \"[a-zA-Z0-9]@[a-zA-Z0-9].[a-zA-Z0-9]")
			String email,
			@Size(min = 4, max = 50, message = "Size should be between 4-50") String name,
			@Size(min = 10, max = 10, message = "Contact number should be of 10 digits") String contactNo,
			@Size(min = 6, message = "password should be minimum 6 letters") String password, String role,
			Boolean isActive, Date dateOfBirth) {
		super();
		this.email = email;
		this.name = name;
		this.contactNo = contactNo;
		this.password = password;
		this.role = role;
		this.isActive = isActive;
		this.dateOfBirth = dateOfBirth;
		this.hasSubscribed = false;
	}
	
}
