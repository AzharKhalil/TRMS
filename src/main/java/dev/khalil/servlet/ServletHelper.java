package dev.khalil.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.khalil.controller.Controller;

public class ServletHelper {
	
	
	public static void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		
		String uri= request.getRequestURI();
		
		switch(uri) {
		
		case "/Project1/signin.do" :{
			
			Controller.signin(request, response);
			break;
			
		}
		
		case "/Project1/signup.do":{
			Controller.signup(request, response);
			break;
			
		}
		
		case "/Project1/dashboard.do":{
			Controller.dashboardData(request, response);
			
			break;
		}
		
		case "/Project1/addrequest.do":{
			Controller.addRequest(request, response);
			break;
		}
		case "/Project1/getAllrequests.do":{
			
			Controller.getAllRequests(request, response);
			break;
			
		}
		
		case "/Project1/getbyid.do":{
			
			Controller.getReqbyID(request, response);
			break;
		}
		case "/Project1/updatereq.do":{
			
			Controller.updateReq(request, response);
			break;
		}
		
		case "/Project1/updateemp.do":{
			
			Controller.updateEmp(request, response);
			break;
		}
		
		case "/Project1/updategrade.do":{
			
			Controller.updateGrade(request, response);
			break;
		}
		
		
		}
		
		
	}
	

}
