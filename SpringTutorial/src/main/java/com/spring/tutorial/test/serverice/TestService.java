package com.spring.tutorial.test.serverice;

import java.util.List;

import com.spring.tutorial.test.dto.EmployeesDTO;

public abstract interface TestService {

	public abstract List< EmployeesDTO > getEmployeesList( Integer page );

}
