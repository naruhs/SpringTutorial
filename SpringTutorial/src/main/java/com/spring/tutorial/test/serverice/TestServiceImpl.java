package com.spring.tutorial.test.serverice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.tutorial.test.dao.TestDAO;
import com.spring.tutorial.test.dto.EmployeesDTO;

@Service
public class TestServiceImpl implements TestService {

	@Autowired
	private TestDAO testDAOImpl;

	@Override
	public List< EmployeesDTO > getEmployeesList( Integer page ) {

		if( page == null ) {

			page = 0;
		}

		Map< String, Object > paramMap = new HashMap< String, Object >();
		paramMap.put( "start", page );
		paramMap.put( "end", ( page + 10 ) );
		
		List< EmployeesDTO > employeesList = testDAOImpl.getEmployeesList( paramMap );
		
		StringBuffer sb = new StringBuffer();
		int index01 = 0;
		for( index01 = 0 ; index01 < employeesList.size(); index01++ ) {
			
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

		return testDAOImpl.getEmployeesList( paramMap );
	}

}
