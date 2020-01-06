package com.spring.tutorial.employees.dto;

import java.util.Date;

public class EmployeesDTO {

	int employeeId; 		/* NUMBER(6,0) 			NOT NULL */ /* Primary key of employees table. */
	String firstName; 		/* VARCHAR2(20 BYTE) 	NULLABLE */ /* First name of the employee. A not null column. */
	String lastName; 		/* VARCHAR2(25 BYTE)	NOT NULL */ /* Last name of the employee. A not null column. */
	String email; 			/* VARCHAR2(25 BYTE)	NOT NULL */ /* Email id of the employee */
	String phoneNumber; 	/* VARCHAR2(20 BYTE)	NULLABLE */ /* Phone number of the employee; includes country code and area code */
	Date hireDate; 			/* DATE					NOT NULL */ /* Date when the employee started on this job. A not null column. */
	String jobId; 			/* VARCHAR2(10 BYTE)	NOT NULL */ /* "Current job of the employee; foreign key to job_id column of the jobs table. A not null column." */
	Double salary; 			/* NUMBER(8,2)			NULLABLE */ /* "Monthly salary of the employee. Must be greater than zero (enforced by constraint emp_salary_min)" */
	Double commissionPct; 	/* NUMBER(2,2)			NULLABLE */ /* "Commission percentage of the employee; Only employees in sales department elgible for commission percentage" */
	Integer managerId; 		/* NUMBER(6,0)			NULLABLE */ /* "Manager id of the employee; has same domain as manager_id in departments table. Foreign key to employee_id column of employees table. (useful for reflexive joins and CONNECT BY query)" */
	Integer departmentId; 	/* NUMBER(4,0)			NULLABLE */ /* "Department id where employee works; foreign key to department_id column of the departments table" */

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId( int employeeId ) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName( String firstName ) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName( String lastName ) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail( String email ) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber( String phoneNumber ) {
		this.phoneNumber = phoneNumber;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate( Date hireDate ) {
		this.hireDate = hireDate;
	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId( String jobId ) {
		this.jobId = jobId;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary( Double salary ) {
		this.salary = salary;
	}

	public Double getCommissionPct() {
		return commissionPct;
	}

	public void setCommissionPct( Double commissionPct ) {
		this.commissionPct = commissionPct;
	}

	public Integer getManagerId() {
		return managerId;
	}

	public void setManagerId( Integer managerId ) {
		this.managerId = managerId;
	}

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId( Integer departmentId ) {
		this.departmentId = departmentId;
	};

}
