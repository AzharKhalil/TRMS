package dev.khalil.daos;

import java.util.List;

import dev.khalil.entities.Request;

public interface RequestDAOS {
	
	public Request getRequest(int reqId);
	public boolean addRequest(Request req);
	public List<Request> getAllRequests();
	public boolean updateRequest(Request req);
	public boolean updateGrade(Request req);
	

}
