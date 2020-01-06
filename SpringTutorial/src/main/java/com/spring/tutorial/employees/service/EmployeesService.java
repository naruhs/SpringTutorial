package com.spring.tutorial.employees.service;

import java.util.List;

import com.spring.tutorial.employees.dto.EmployeesDTO;

public abstract interface EmployeesService {

	public abstract List< EmployeesDTO > getEmployeesList( Integer page );

}
