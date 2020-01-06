package com.spring.tutorial.employees.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.tutorial.employees.dao.EmployeesDAO;
import com.spring.tutorial.employees.dto.EmployeesDTO;

@Service
public class EmployeesServiceImpl implements EmployeesService {

	@Autowired
	private EmployeesDAO employeesDAOImpl;

	@Override
	public List< EmployeesDTO > getEmployeesList( Integer page ) {

		if( page == null ) {

			page = 0;
		}

		Map< String, Object > paramMap = new HashMap< String, Object >();
		paramMap.put( "start", page );
		paramMap.put( "end", ( page + 10 ) );

		List< EmployeesDTO > employeesList = employeesDAOImpl.getEmployeesList( paramMap );

		StringBuffer sb = new StringBuffer();
		int index01 = 0;
		for( index01 = 0; index01 < employeesList.size(); index01++ ) {

			sb.append( "\n==================================================\n" );
			sb.append( "EMPLOYEE_ID : " );
			sb.append( employeesList.get( index01 ).getEmployeeId() );
			sb.append( "\n" );
			sb.append( "NAME : " );
			sb.append( employeesList.get( index01 ).getFirstName() );
			sb.append( " " );
			sb.append( employeesList.get( index01 ).getLastName() );
			sb.append( "\n" );
			sb.append( "==================================================\n" );
		}

		System.out.println( sb.toString() );

		return employeesDAOImpl.getEmployeesList( paramMap );
	}

}
