package dev.khalil.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dev.khalil.entities.Employee;
import dev.khalil.entities.Request;
import dev.khalil.services.EmployeeServices;
import dev.khalil.services.EmployeeServicesImpl;
import dev.khalil.services.ReqServices;
import dev.khalil.services.ReqServicesImpl;

public class Controller {

	public static Gson gson = new Gson();

	public static void signin(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		EmployeeServices eserv = new EmployeeServicesImpl();
		Employee emp = eserv.getEmployee(username, password);

		response.getWriter().append(emp != null ? gson.toJson(emp) : "{}");
	}

	public static void signup(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String requestData = request.getReader().lines().collect(Collectors.joining());
		// response.getWriter().append(request.getReader().toString());
		Employee emp = gson.fromJson(requestData, Employee.class);
		// response.getWriter().append(e.toString());
		EmployeeServices eserv = new EmployeeServicesImpl();
		Boolean val = eserv.addEmployee(emp);

		response.getWriter().append(val.toString());

		// Employee e = gson.fromJson(request.getReader(), Employee.class);
		// response.getWriter().append(e.toString());
	}

	public static void dashboardData(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String strid = request.getParameter("id");
		Integer id = Integer.parseInt(strid);

		EmployeeServices eserv = new EmployeeServicesImpl();
		Employee e = eserv.getEmpbyid(id);
		response.getWriter().append(e != null ? gson.toJson(e) : "{}");
	}
	
	
	
	public static void addRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		
		
		String requestData = request.getReader().lines().collect(Collectors.joining());
		
		
		Request req = gson.fromJson(requestData, Request.class);
		//response.getWriter().append(req.toString());
		
		ReqServices rserv = new ReqServicesImpl();
		Boolean val = rserv.addRequest(req);
		
		response.getWriter().append(val? val.toString():"{}");
	}
	
	
	public static void getAllRequests(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		ReqServices rserv = new ReqServicesImpl();
		
		List<Request> rList = rserv.getAllRequests();
		response.getWriter().append(rList != null ?gson.toJson(rList):"{}");
	}
	
	public static void getReqbyID(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String str = request.getParameter("reqid");
		Integer reqid =Integer.parseInt(str);
		
		ReqServices rserv = new ReqServicesImpl();
		Request req = rserv.getRequest(reqid);
		
		response.getWriter().append(req!= null? gson.toJson(req):"{}");
		
	}
	
	public static void updateReq(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String data = request.getReader().lines().collect(Collectors.joining());
		Request req = gson.fromJson(data, Request.class);
		ReqServices rserv = new ReqServicesImpl();
		Boolean b = rserv.updateReq(req);
		response.getWriter().append(b.toString());
	}
	
	public static void updateEmp(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String data = request.getReader().lines().collect(Collectors.joining());
		Employee emp = gson.fromJson(data, Employee.class);
		EmployeeServices eserv = new EmployeeServicesImpl();
		Boolean result = eserv.updateEmployee(emp);
		response.getWriter().append(result? result.toString(): "false");
		
		
		
	}
	
	public static void updateGrade(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String data = request.getReader().lines().collect(Collectors.joining());
		Request req = gson.fromJson(data, Request.class);
		ReqServices rserv = new ReqServicesImpl();
		Boolean b = rserv.updateReq(req);
		response.getWriter().append(b.toString());
	}

}
