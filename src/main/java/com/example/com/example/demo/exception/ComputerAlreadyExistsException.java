package com.example.demo.exception;
//Creating a custom exception that can be thrown when a user tries to add a customer that already exists


public class ComputerAlreadyExistsException extends RuntimeException {
 private String message;

 public ComputerAlreadyExistsException() {}

 public ComputerAlreadyExistsException(String msg) {
     super(msg);
     this.message = msg;
 }
}
