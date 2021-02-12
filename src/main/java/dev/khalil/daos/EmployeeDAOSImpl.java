package dev.khalil.daos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dev.khalil.entities.Employee;
import dev.khalil.jdbc.JDBCConnection;

public class EmployeeDAOSImpl implements EmployeeDAOS {

	Connection conn = JDBCConnection.getConnection();

	@Override
	public Employee getEmployee(String userName, String password) {
		Employee emp = new Employee();

		try {

			String sql = "select * from employees where username = ? and password = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, userName);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				emp.setEmp_id(rs.getInt("EMP_ID"));
				emp.setEmployeeFirstName(rs.getString("FIRST_NAME"));
				emp.setEmployeeLastName(rs.getString("LAST_NAME"));
				emp.setPassword(rs.getString("PASSWORD"));
				emp.setRoleId(rs.getInt("ROLE_ID"));
				emp.setUserName(rs.getString("USERNAME"));
				emp.setSupervisor_id(rs.getInt("SUPERVISOR_ID"));
				emp.setDep_id(rs.getInt("DEPARTMENT_ID"));
				emp.setReimbursment_status(rs.getInt("REIMBURSMENT_STATUS"));
				emp.setEmail(rs.getString("EMAIL"));
				emp.setIsfetched(true);

				return emp;

			} else {

				System.out.println("Wrong usernae and password!");
				Employee employee = new Employee();
				employee.setIsfetched(false);
				return employee;
			}

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return null;
	}

	@Override
	public boolean addEmployee(Employee emp) {
		
		
	
		
		try {
			
			String sql = " call add_emp(?, ?, ?, ?, ?, ?, ?,?,?)";
			CallableStatement cs = conn.prepareCall(sql);
			cs.setString(1, emp.getEmployeeFirstName());
			cs.setString(2, emp.getEmployeeLastName());
			cs.setString(3, emp.getEmail());
			cs.setString(4, emp.getUserName());
			cs.setString(5, emp.getPassword());
			cs.setString(6, Integer.toString(emp.getRoleId()));
			cs.setString(7, Integer.toString(emp.getDep_id()));
			cs.setString(8, Integer.toString(emp.getSupervisor_id()));
			cs.setString(9, Integer.toString(emp.getReimbursment_status()));
			cs.execute();
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		
		}

		return false;
	}

	@Override
	public Employee getEmpbyId(int id) {
		
		Employee emp = new Employee();
		try {
		String sql = "select * from employees where emp_id = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, Integer.toString(id));
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			
			
			emp.setEmp_id(rs.getInt("EMP_ID"));
			emp.setEmployeeFirstName(rs.getString("FIRST_NAME"));
			emp.setEmployeeLastName(rs.getString("LAST_NAME"));
			emp.setPassword(rs.getString("PASSWORD"));
			emp.setRoleId(rs.getInt("ROLE_ID"));
			emp.setUserName(rs.getString("USERNAME"));
			emp.setSupervisor_id(rs.getInt("SUPERVISOR_ID"));
			emp.setDep_id(rs.getInt("DEPARTMENT_ID"));
			emp.setReimbursment_status(rs.getInt("REIMBURSMENT_STATUS"));
			emp.setEmail(rs.getString("EMAIL"));
			emp.setIsfetched(true);
			return emp;
			
		}
		else
		{
			emp.setIsfetched(true);
			return emp;
		}
		
		
		
		
		
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean updateEmp(Employee emp) {
		
		try {
			System.out.println("before eecution");
			String sql = "update employees set reimbursment_status =? where emp_id = ?";
			System.out.println("after string sql");
			PreparedStatement ps = conn.prepareStatement(sql);
			System.out.println("aftr prepare call");
			ps.setString(1, Integer.toString(emp.getReimbursment_status()));
			System.out.println(emp.getReimbursment_status());
			System.out.println("aftr str 1 set");
			ps.setString(2, Integer.toString(emp.getEmp_id()));
			System.out.println(emp.getEmp_id());
			System.out.println("after str 2 set");
			
			ps.execute();
			return true;
			
			
			//System.out.println("after execute");
			//System.out.println("executed");
			//return true;
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
