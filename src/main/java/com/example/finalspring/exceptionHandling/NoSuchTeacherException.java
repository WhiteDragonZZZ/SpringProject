package com.example.finalspring.exceptionHandling;

public class NoSuchTeacherException extends RuntimeException{
	public NoSuchTeacherException(String message) {
		super(message);
	}
}
