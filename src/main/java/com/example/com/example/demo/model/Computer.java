package com.example.demo.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "computers")  // Change from "user" to "users" or another name
public class Computer {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    private String serialNumber;
    private String model;
    private LocalDate releaseDate;
    private String status;
    
 // Constructors
    public Computer() {}

    public Computer(String serialNumber, String model, LocalDate releaseDate, String status) {
        this.serialNumber = serialNumber;
        this.model = model;
        this.releaseDate = releaseDate;
        this.status = status;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }
    
    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }
    
    public String getModel() {
        return model;
    }
    
    public void setModel(String model) {
    	this.model = model;
    }
    
    public LocalDate getReleaseDate() {
        return releaseDate;
    }
    
    public void setReleaseDate(LocalDate releaseDate) {
    	this.releaseDate = releaseDate;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
    	this.status = status;
    }


}
