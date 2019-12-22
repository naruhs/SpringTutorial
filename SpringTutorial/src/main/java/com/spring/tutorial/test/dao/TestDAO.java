package com.spring.tutorial.test.dao;

import java.util.List;
import java.util.Map;

import com.spring.tutorial.test.dto.EmployeesDTO;

public abstract interface TestDAO {

	public abstract List< EmployeesDTO > getEmployeesList( Map< String, Object > paramMap );

}
