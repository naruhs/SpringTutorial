package com.spring.tutorial.jacksonmapperasl.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.tutorial.employees.dto.EmployeesDTO;
import com.spring.tutorial.employees.service.EmployeesService;

@Controller
@RequestMapping( "/jacson-mapper-asl/*" )
public class JacksonMapperASLController {

	/*
	 * 참고 사이트 : https://soulduse.tistory.com/22 
	 */
	
	@Autowired
	private EmployeesService employeesServiceImpl;

	@RequestMapping( value = "test001", method = RequestMethod.GET )
	public void test001( Integer page ) {

		List< EmployeesDTO > empList = employeesServiceImpl.getEmployeesList( page );

		ObjectMapper mapper = new ObjectMapper();
		try {

			// Convert object to JSON string and save into file directly
			// mapper.writeValue( new File( "D:\\test01.json" ), empList );

			// Convert object to JSON string
			String jsonInString = mapper.writeValueAsString( empList );
			System.out.println(
					"\n================================================== [ convert object to JSON string ]" );
			System.out.println( jsonInString );

			// Convert object to JSON string and pretty print			
			jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString( empList );
			System.out.println(
					"\n================================================== [ convert object to JSON string and pretty print ]" );
			System.out.println( jsonInString );
		} catch( JsonGenerationException e ) {

			e.printStackTrace();
		} catch( JsonMappingException e ) {

			e.printStackTrace();
		} catch( IOException e ) {

			e.printStackTrace();
		}

		return;
	}

	@RequestMapping( value = "test002", method = RequestMethod.GET )
	public void test002() {

		ObjectMapper mapper = new ObjectMapper();
		try {

			// map -> json
			List< Map< String, String > > list = new ArrayList< Map< String, String > >();
			Map< String, String > map = new HashMap< String, String >();

			map.put( "name", "steave" );
			map.put( "age", "32" );
			map.put( "job", "baker" );
			list.add( map );

			map = new HashMap< String, String >();
			map.put( "name", "matt" );
			map.put( "age", "25" );
			map.put( "job", "soldier" );
			list.add( map );

			System.out.println( "\n================================================== [ map -> json ]" );
			System.out.println( mapper.writeValueAsString( list ) );

			// json -> map			
			String jsn = "[{\"age\":\"32\",\"name\":\"steave\",\"job\":\"baker\"},"
					+ "{\"age\":\"25\",\"name\":\"matt\",\"job\":\"soldier\"}]";
			list = mapper.readValue( jsn, new TypeReference< ArrayList< HashMap< String, String > > >() {
			} );

			System.out.println( "\n================================================== [ json -> map ]" );
			System.out.println( list );

		} catch( JsonGenerationException e ) {

			e.printStackTrace();
		} catch( JsonMappingException e ) {

			e.printStackTrace();
		} catch( IOException e ) {

			e.printStackTrace();
		}

		return;
	}

	@RequestMapping( value = "test003", method = RequestMethod.GET )
	public void test003() {

		List< String > list = new ArrayList< String >();
		list.add( "list1" );
		list.add( "list2" );
		list.add( "list3" );

		Map< String, Object > map = new HashMap< String, Object >();
		map.put( "list", list );
		map.put( "a", "va" );
		map.put( "b", "vb" );

		ObjectMapper mapper = new ObjectMapper();
		try {
			// Map or List Object 를 JSON 문자열로 변환
			String jsonStr = mapper.writeValueAsString( map );
			System.out.println(
					"\n================================================== [ Map or List Object 를 JSON 문자열로 변환 ]" );
			System.out.println( "object to json : " + jsonStr );

			// JSON 문자열을 Map or List Object 로 변환
			map = mapper.readValue( jsonStr, new TypeReference< Map< String, Object > >() {
			} );
			System.out.println(
					"\n================================================== [ JSON 문자열을 Map or List Object 로 변환 ]" );
			System.out.println( "json to object : " + map );

			// JSON 문자열을 xml 다루는것과 비슷하게 트리로 맨들어서 트래버싱하기(Tree Model)
			JsonNode root = mapper.readTree( jsonStr );

			// 단일값 가져오기
			System.out.println( "\n================================================== [ 단일값 가져오기 ]" );
			System.out.println( "b의 값 : " + root.path( "b" ).asText() );

			// 배열에 있는 값들 가져오기
			if( root.path( "list" ).isArray() ) {
				Iterator< JsonNode > it = root.path( "list" ).iterator();

				// 요래 해도 됨
				// Iterator<jsonnode> it = root.path("list").getElements()
				while( it.hasNext() ) {
					System.out.println( "\n================================================== [ 배열에 있는 값들 가져오기 ]" );
					System.out.println( it.next().getTextValue() );
				}
			}
		} catch( JsonGenerationException e ) {

			e.printStackTrace();
		} catch( JsonMappingException e ) {

			e.printStackTrace();
		} catch( IOException e ) {

			e.printStackTrace();
		}

		return;
	}

	@RequestMapping( value = "test004", method = RequestMethod.GET )
	public void test004( Integer page ) {

		Map< String, Object > jsonMap = new HashMap< String, Object >();
		List< EmployeesDTO > empList = employeesServiceImpl.getEmployeesList( page );
		Map< String, String > paramMap = new HashMap< String, String >();
		List< Map< String, String > > paramListMap = new ArrayList< Map< String, String > >();
		paramMap.put( "param1", "param1" );
		paramMap.put( "param2", "param3" );
		paramMap.put( "param3", "param3" );
		paramListMap.add( paramMap );
		
		jsonMap.put( "paramListMap", paramListMap );
		jsonMap.put( "empList", empList );
		
		ObjectMapper mapper = new ObjectMapper();
		try {

			// Map or List Object 를 JSON 문자열로 변환
			// String jsonStr = mapper.writeValueAsString( jsonMap );
			String jsonStr = mapper.writerWithDefaultPrettyPrinter().writeValueAsString( jsonMap );
			System.out.println(
					"\n================================================== [ Map or List Object 를 JSON 문자열로 변환 ]" );
			System.out.println( "object to json : " + jsonStr );

		} catch( JsonGenerationException e ) {

			e.printStackTrace();
		} catch( JsonMappingException e ) {

			e.printStackTrace();
		} catch( IOException e ) {

			e.printStackTrace();
		}

		return;
	}
}
