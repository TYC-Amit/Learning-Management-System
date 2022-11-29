package com.te.leraningmanagementsystem.exceptionhandler;

@SuppressWarnings("serial")
public class EmployeeNotFoundException extends RuntimeException{
         
	public EmployeeNotFoundException(String message) {
		super(message);
	}
}