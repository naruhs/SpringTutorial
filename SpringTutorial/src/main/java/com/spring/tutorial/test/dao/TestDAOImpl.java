package com.spring.tutorial.test.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.tutorial.test.dto.EmployeesDTO;

@Repository( "testDAO" )
public class TestDAOImpl implements TestDAO {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public List< EmployeesDTO > getEmployeesList( Map< String, Object > paramMap ) {

		return sqlSession.selectList( "test.getEmployeesList", paramMap );
	}

}
