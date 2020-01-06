package com.spring.tutorial.employees.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.tutorial.employees.dto.EmployeesDTO;

@Repository
public class EmployeesDAOImpl implements EmployeesDAO {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public List< EmployeesDTO > getEmployeesList( Map< String, Object > paramMap ) {

		return sqlSession.selectList( "employees.getEmployeesList", paramMap );
	}

}
