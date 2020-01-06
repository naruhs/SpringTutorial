package com.spring.tutorial.employees.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.tutorial.employees.service.EmployeesService;

@Controller
@RequestMapping( "/employees/*" )
public class EmployeesController {

	@Autowired
	private EmployeesService employeesServiceImpl;

	@RequestMapping( value = "list", method = RequestMethod.GET )
	public void list( Integer page ) {

		employeesServiceImpl.getEmployeesList( page );

		return;
	}

}
