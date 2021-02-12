package dev.khalil.services;

import dev.khalil.entities.Employee;

public interface EmployeeServices {
	
	
	public Employee getEmployee(String userName, String password);
	public Employee getEmpbyid(int id); 
	public boolean addEmployee(Employee emp);
	public boolean updateEmployee(Employee emp);

}
