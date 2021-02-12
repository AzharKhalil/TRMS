package dev.khalil.services;

import dev.khalil.daos.EmployeeDAOS;
import dev.khalil.daos.EmployeeDAOSImpl;
import dev.khalil.entities.Employee;

public class EmployeeServicesImpl implements EmployeeServices {

	EmployeeDAOS edaos = new EmployeeDAOSImpl();
	@Override
	public Employee getEmployee(String userName, String password) {
		
		return edaos.getEmployee(userName, password);
	}

	@Override
	public boolean addEmployee(Employee emp) {
		emp.setReimbursment_status(1000);
		int dep_id = emp.getDep_id();
		switch(dep_id) {
		case 1:{
			
			emp.setSupervisor_id(100);
			break;
		}
		case 2:{
			emp.setSupervisor_id(100);
			break;
		}
		case 3:{
			emp.setSupervisor_id(101);
			break;
		}
		}
		
		return edaos.addEmployee(emp);
	}

	@Override
	public Employee getEmpbyid(int id) {
		return edaos.getEmpbyId(id);
		
	}

	@Override
	public boolean updateEmployee(Employee emp) {
		return edaos.updateEmp(emp);
		
	}

}
