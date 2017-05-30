package com.hendi.webapp.service;

import com.hendi.webapp.domain.Employee;
import com.hendi.webapp.repository.EmployeeRepository;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class EmployeeServiceImplementation implements EmployeeServiceInterface{
	private List<Employee> listaEmpleados = new LinkedList<Employee>();
	@Autowired
	protected EmployeeRepository employeeRepository;
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	public void saveEmployee(Employee emp) {
		String sql = "insert into employee(emp_name, emp_designation, emp_salary) values(?,?,?)";
		jdbcTemplate.update(sql, emp.getEmpName(), emp.getEmpDesignation(), emp.getEmpSalary());

		listaEmpleados.add(emp);

	}

	@Override
	public Boolean deleteEmployee(String empId) {
		// TODO Auto-generated method stub
		Employee temp = employeeRepository.findOne(empId);
		if(temp!=null){
			 employeeRepository.delete(temp);
			 return true;
		}
		return false;
	}

	@Override
	public Employee editEmployee(Employee emp) {
		// TODO Auto-generated method stub
		return employeeRepository.save(emp);
	}

	@Override
	public Collection<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		Iterable<Employee> itr = employeeRepository.findAll();
		return (Collection<Employee>)itr;
	}

	@Override
	public Employee findEmployee(String empId) {
		// TODO Auto-generated method stub
		return employeeRepository.findOne(empId);
	}
	

}
