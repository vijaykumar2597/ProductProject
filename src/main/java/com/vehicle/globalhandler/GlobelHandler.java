package com.vehicle.globalhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.vehicle.customexception.BrandNotFoundException;
import com.vehicle.customexception.IdnotFoundExcpetion;

@RestControllerAdvice
public class GlobelHandler {

	@ExceptionHandler(BrandNotFoundException.class)
	public ResponseEntity<Object> brandHandler() {
		return new ResponseEntity<Object>("Brand does not exited",HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(IdnotFoundExcpetion.class)
	public ResponseEntity<Object> idHandler() {
		return new ResponseEntity<Object>("Id Does not excited",HttpStatus.BAD_REQUEST);
	}
}
