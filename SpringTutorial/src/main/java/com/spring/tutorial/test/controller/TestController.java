package com.spring.tutorial.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.tutorial.test.serverice.TestService;

@Controller
public class TestController {

	@Autowired
	private TestService testServiceImpl;

	@RequestMapping( value = "/employees-list", method = RequestMethod.GET )
	public void getEmployeesList( Integer page ) {

		testServiceImpl.getEmployeesList( page );
		
		return;
	}

}
