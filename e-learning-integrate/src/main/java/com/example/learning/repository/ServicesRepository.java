package com.example.learning.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.learning.model.Services;

public interface ServicesRepository extends JpaRepository<Services,Integer> {

	Services findByServiceName(String serviceName);

}
