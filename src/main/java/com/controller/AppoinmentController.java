package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ServiceInterface.AppoinmentServiceInterface;

@RestController
@RequestMapping("/appinment")
public class AppoinmentController 
{
	@Autowired
	private AppoinmentServiceInterface appoinmentServiceInterface;
	
	

}
