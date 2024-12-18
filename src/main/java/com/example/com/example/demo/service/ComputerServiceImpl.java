package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.NoSuchComputerExistsException;
import com.example.demo.exception.ComputerAlreadyExistsException;
import com.example.demo.model.Computer;
import com.example.demo.repository.ComputerRepository;

@Service 
public class ComputerServiceImpl implements ComputerService {
	
	private final ComputerRepository computerRepository;

    @Autowired
    public ComputerServiceImpl(ComputerRepository computerRepository) {
        this.computerRepository = computerRepository;
    }

    @Override
    public Computer saveComputer(Computer computer) {
    	// Check if a user with the same email already exists
        Optional<Computer> existingComputer = computerRepository.findComputerByModel(computer.getModel());
        if (existingComputer.isPresent()) {
            throw new ComputerAlreadyExistsException("Computer with model " + computer.getModel() + " already exists.");
        }
        return computerRepository.save(computer);
        
    }

    @Override
    public List<Computer> getAllComputers() {
        return computerRepository.findAll();
    }

    @Override
    public Optional<Computer> getComputerById(Long id) {
    	Optional<Computer> computer = computerRepository.findById(id);
        if (computer.isEmpty()) {
            throw new NoSuchComputerExistsException("No computer exists with ID: " + id);
        }
        return computer;
    }
        
    @Override
    public Computer updateComputer(Computer computer) {
    	// Check if the user exists before updating
        if (!computerRepository.existsById(computer.getId())) {
            throw new NoSuchComputerExistsException("Cannot update. No computer found with ID: " + computer.getId());
        }
        return computerRepository.save(computer); // save() method can also be used for updating an existing entity
    }

    @Override
    public void deleteComputerById(Long id) {
    	// Check if the user exists before deleting
        if (!computerRepository.existsById(id)) {
            throw new NoSuchComputerExistsException("Cannot delete. No computer found with ID: " + id);
        }
        computerRepository.deleteById(id);
    }

    @Override
    public List<Computer> findComputerBySerialNumber(String serialNumber) {
        return computerRepository.findComputerBySerialNumber(serialNumber);
    }

    @Override
    public Optional<Computer> findComputerByModel(String model) {
    	Optional<Computer> computer = computerRepository.findComputerByModel(model);
        if (computer.isEmpty()) {
            throw new NoSuchComputerExistsException("No computer exists with model: " + model);
        }
        return computer;
    }

}
