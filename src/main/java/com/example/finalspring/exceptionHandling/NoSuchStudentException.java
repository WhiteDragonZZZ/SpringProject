package com.example.finalspring.exceptionHandling;

public class NoSuchStudentException extends RuntimeException{
	public NoSuchStudentException(String message) {
		super(message);
	}
}
