package com.moveone.app.errors;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHanderController {
	
	@ExceptionHandler(NullPointerException.class)
	public String handler1() {
		System.out.println("nullptr Exception");
		return "errors/error";
	}
	@ExceptionHandler(RuntimeException.class)
	public String handler4() {
		System.out.println("RuntimeException");
		return "errors/error";
	}
	
	@ExceptionHandler(Exception.class)
	public String handler2() {
		System.out.println("Exception");
		return "errors/error";
	}
	
	@ExceptionHandler(Throwable.class)
	public String handler3() {
		System.out.println("Throwable");
		return "errors/error";
	}
}
