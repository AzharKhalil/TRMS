package test;

import dev.khalil.entities.Employee;
import dev.khalil.entities.Request;
import dev.khalil.services.EmployeeServices;
import dev.khalil.services.EmployeeServicesImpl;
import dev.khalil.services.ReqServices;
import dev.khalil.services.ReqServicesImpl;

public class test {

	
	public static void main(String[] args) {
		ReqServices rserv = new ReqServicesImpl();
		//System.out.println(rserv.getAllRequests());
		//System.out.println(rserv.getRequest(2));
		Employee e = new Employee();
		e.setEmp_id(64);
		e.setReimbursment_status(350);
		EmployeeServices eserv = new EmployeeServicesImpl();
		System.out.println(eserv.updateEmployee(e));
		
		
		//Request r= new Request();
		//r.setReqID(39);
		//r.setGradeID(2);
		//System.out.println(rserv.updateGrade(r));
		
		
	}
	
}
