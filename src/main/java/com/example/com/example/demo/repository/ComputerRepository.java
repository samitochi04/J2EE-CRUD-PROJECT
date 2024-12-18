package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Computer;

public interface ComputerRepository extends JpaRepository<Computer, Long>{
	
	 // Custom method to find users by their name
    List<Computer> findComputerBySerialNumber(String serialNumber);

    // Custom method to find a user by their email
    Optional<Computer> findComputerByModel(String model);

}
