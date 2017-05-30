package com.hendi.webapp.service;

import com.hendi.webapp.domain.Employee;
import java.util.Collection;


public interface EmployeeServiceInterface {

	public void saveEmployee(Employee emp);
	public Boolean deleteEmployee(String empId);
	public Employee editEmployee(Employee emp);
	public Employee findEmployee(String empId);
	public Collection<Employee> getAllEmployees();
}
