package com.elms.mohamed.service;

import java.util.ArrayList;
import java.util.List;

import com.elms.mohamed.model.Employee;


public class EmployeeManager {
static List<Employee> employeeList = new ArrayList<Employee>();
	
	static {
		Employee employee1 = new Employee();
		employee1.setName("Mohamed");
		employee1.setId(2627);
		employee1.setUsername("moha2627");
		employee1.setPassword("pass1234");
		employeeList.add(employee1);
		Employee employee2 = new Employee();
		employee2.setName("Halith");
		employee2.setId(2628);
		employee2.setUsername("hali2628");
		employee2.setPassword("pass1234");
		employeeList.add(employee2);
	}
	
	public static List<Employee> getEmployeeList() {
		return employeeList;
	}
}
