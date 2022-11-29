package com.te.leraningmanagementsystem.exceptionhandler;

@SuppressWarnings("serial")
public class MentorNotFoundException extends RuntimeException{
         
	public MentorNotFoundException(String message) {
		super(message);
	}
}