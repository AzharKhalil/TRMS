package dev.khalil.services;

import java.util.List;

import dev.khalil.entities.Request;

public interface ReqServices {
	
	public Request getRequest(int reqId);
	public boolean addRequest(Request req);
	public List<Request> getAllRequests();
	public boolean updateReq(Request req);
	public boolean updateGrade(Request req);

}
