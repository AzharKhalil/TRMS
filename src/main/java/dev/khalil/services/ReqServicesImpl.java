package dev.khalil.services;

import java.util.List;

import dev.khalil.daos.RequestDAOS;
import dev.khalil.daos.RequestDAOSImpl;
import dev.khalil.entities.Employee;
import dev.khalil.entities.Request;

public class ReqServicesImpl implements ReqServices {
	
	RequestDAOS rdaos = new RequestDAOSImpl();
	

	@Override
	public Request getRequest(int reqId) {
		return rdaos.getRequest(reqId);
	
	}

	@Override
	public boolean addRequest(Request req) {
		
		EmployeeServices eserv = new EmployeeServicesImpl();
		Employee emp = eserv.getEmpbyid(req.getEmp_id());
		
		switch(emp.getRoleId())
		{
		
		case 1:{
			req.setReimb_status(1);
			break;
		}
		
		case 2:{
			req.setReimb_status(2);
			break;
		}
		case 3:{
			req.setReimb_status(3);
			break;
		}
		}
		
		
		
		return rdaos.addRequest(req);
	}

	@Override
	public List<Request> getAllRequests() {
		return rdaos.getAllRequests();
		
	}

	@Override
	public boolean updateReq(Request req) {
		req.setReimb_status(req.getReimb_status()+1);
		return rdaos.updateRequest(req);
		
	}

	@Override
	public boolean updateGrade(Request req) {
		return rdaos.updateGrade(req);
		
	}
	

}
