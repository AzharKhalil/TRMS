package dev.khalil.daos;

import dev.khalil.entities.Employee;

public interface EmployeeDAOS {
	
	
	public Employee getEmployee(String userName, String password); 
	
	public Employee getEmpbyId(int id);
	public boolean addEmployee(Employee emp);
	public boolean updateEmp(Employee emp);

}
