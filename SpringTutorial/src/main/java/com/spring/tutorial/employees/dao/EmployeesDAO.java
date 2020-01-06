package com.spring.tutorial.employees.dao;

import java.util.List;
import java.util.Map;

import com.spring.tutorial.employees.dto.EmployeesDTO;

public abstract interface EmployeesDAO {

	public abstract List< EmployeesDTO > getEmployeesList( Map< String, Object > paramMap );

}
