package dev.khalil.daos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dev.khalil.entities.Request;
import dev.khalil.jdbc.JDBCConnection;

public class RequestDAOSImpl implements RequestDAOS {
	
	Connection conn = JDBCConnection.getConnection();

	@Override
	public Request getRequest(int reqId) {
		
		Request req = new Request();
		try {
			
			String sql = "select * from requests where request_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(reqId));
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				
			req.setDate(rs.getString("SUBMISSION_DATE"));
			req.setCost(rs.getInt("COST"));
			req.setDescription(rs.getString("DESCRIPTION"));
			req.setEmp_id(rs.getInt("EMPLOYEE_ID"));
			req.setEventType(rs.getInt("EVENT_TYPE"));
			req.setReqID(rs.getInt("REQUEST_ID"));
			req.setReimb_status(rs.getInt("REIMBURSMENT_STATUS"));
			//req.setGradeID(rs.getInt("GRADE_ID"));
			return req;
				
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public boolean addRequest(Request req) {
		
		
		//call add_request(63,'2020/12/12', 100, 'wc', '1','we',1,1);
		try {
			String sql = "call add_request(?,?, ?,?, ?, ?,?,?)";
			CallableStatement cs = conn.prepareCall(sql);
			cs.setString(1, Integer.toString(req.getEmp_id()));
			cs.setString(2, req.getDate());
			cs.setString(3, Integer.toString(req.getCost()));
			cs.setString(4, req.getDescription());
			cs.setString(5, Integer.toString(req.getEventType()));
			cs.setString(6, req.getImage());
			cs.setString(7, Integer.toString(req.getReimb_status()));
			cs.setString(8, Integer.toString(req.getGradeID()));
			
			cs.execute();
			return true;
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Request> getAllRequests() {
		try {
			
			List<Request> reqList = new ArrayList<Request>();
			
			String sql = "select * from requests";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Request request = new Request();
				request.setCost(rs.getInt("COST"));
				request.setDate(rs.getString("SUBMISSION_DATE"));
				request.setDescription(rs.getString("DESCRIPTION"));
				request.setReimb_status(rs.getInt("REIMBURSMENT_STATUS"));
				request.setReqID(rs.getInt("REQUEST_ID"));
				request.setEmp_id(rs.getInt("EMPLOYEE_ID"));
				//request.setGradeID(rs.getInt("GRADE_ID"));
				reqList.add(request);
				
			}
			return reqList;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean updateRequest(Request req) {
		try {
			
			String sql = "call update_req(?,?)";
			CallableStatement cs = conn.prepareCall(sql);
			cs.setString(1, Integer.toString(req.getReimb_status()));
			cs.setString(2, Integer.toString(req.getReqID()));
			cs.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateGrade(Request req) {
		
	try {
			
			String sql = "update requests set grade_id =? WHERE request_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(req.getGradeID()));
			ps.setString(2, Integer.toString(req.getReqID()));
			ps.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	

}
