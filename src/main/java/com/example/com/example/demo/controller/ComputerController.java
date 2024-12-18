package com.example.demo.controller;


import com.example.demo.exception.NoSuchComputerExistsException;
import com.example.demo.model.Computer;
import com.example.demo.service.ComputerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/computers")
public class ComputerController {
	
	private final ComputerService computerService;

    @Autowired
    public ComputerController(ComputerService computerService) {
        this.computerService = computerService;
    }

    // GET all users
    @GetMapping
    public ResponseEntity<List<Computer>> getAllComputers() {
        List<Computer> computers = computerService.getAllComputers();
        return new ResponseEntity<>(computers, HttpStatus.OK);
    }

    // GET user by ID
    @GetMapping("/{id}")
    public ResponseEntity<Computer> getComputerById(@PathVariable("id") Long id) {
    	Computer computer = computerService.getComputerById(id).orElseThrow(() -> new NoSuchComputerExistsException("User with ID " + id + " not found"));
    	return new ResponseEntity<>(computer, HttpStatus.OK);
    }

    // POST: Create a new user
    @PostMapping
    public ResponseEntity<Computer> createComputer(@RequestBody Computer computer) {
    	Computer createdComputer = computerService.saveComputer(computer);
        return new ResponseEntity<>(createdComputer, HttpStatus.CREATED);
    }

    // PUT: Update an existing user
    @PutMapping("/{id}")
    public ResponseEntity<Computer> updateComputer(@PathVariable("id") Long id, @RequestBody Computer computer) {
    	// No need to check for the user's existence here as the service will handle it
    	computer.setId(id); // Ensure the updated user has the correct ID
        Computer updatedComputer = computerService.updateComputer(computer);
        return new ResponseEntity<>(updatedComputer, HttpStatus.OK);
    }

    // DELETE: Remove a user by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComputer(@PathVariable("id") Long id) {
    	// No need to check for existence, let the service handle the exception
    	computerService.deleteComputerById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // GET: Find users by name
    @GetMapping("/search/serialNumber")
    public ResponseEntity<List<Computer>> findUsersByName(@RequestParam("serialNumber") String serialNumber) {
        List<Computer> computers = computerService.findComputerBySerialNumber(serialNumber);
        return new ResponseEntity<>(computers, HttpStatus.OK);
    }

    // GET: Find user by email
    @GetMapping("/search/model")
    public ResponseEntity<Computer> findUserByEmail(@RequestParam("model") String model) {
    	Computer computer = computerService.findComputerByModel(model).orElseThrow(() -> new NoSuchComputerExistsException("Computer with model " + model + " not found"));
    	return new ResponseEntity<>(computer, HttpStatus.OK);
    }

}
