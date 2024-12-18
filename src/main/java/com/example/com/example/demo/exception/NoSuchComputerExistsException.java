package com.example.demo.exception;

//Creating a custom exception that can be thrown when a user tries to update/delete a customer that doesn't exist


public class NoSuchComputerExistsException extends RuntimeException {
 private String message;

 public NoSuchComputerExistsException() {}

 public NoSuchComputerExistsException(String msg) {
     super(msg);
     this.message = msg;
 }
}

