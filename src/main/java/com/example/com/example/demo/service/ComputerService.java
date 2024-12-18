package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Computer;

public interface ComputerService {
		// Method to save a new user
		public Computer saveComputer(Computer computer);

	    // Method to get all users
	    List<Computer> getAllComputers();

	    // Method to find a user by their ID
	    Optional<Computer> getComputerById(Long id);

	    // Method to update a user
	    Computer updateComputer(Computer user);

	    // Method to delete a user by their ID
	    void deleteComputerById(Long id);

	    // Custom method to find users by their name
	    List<Computer> findComputerBySerialNumber(String serialNumber);

	    // Custom method to find a user by email
	    Optional<Computer> findComputerByModel(String model);



}
