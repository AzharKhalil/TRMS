package dev.khalil.entities;

public class Employee {
	
	
	private int emp_id;
	private String employeeFirstName;
	private String employeeLastName;
	private String userName;
	private String password;
	private String email;
	private int dep_id;
	private int supervisor_id;
	private int reimbursment_status;
	private boolean isfetched;
	private int roleId;
	

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Employee(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	
	public Employee(int id) {
		this.emp_id = id;
	}
	
	
	public boolean isIsfetched() {
		return isfetched;
	}


	public void setIsfetched(boolean isfetched) {
		this.isfetched = isfetched;
	}



	public int getEmp_id() {
		return emp_id;
	}


	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getEmployeeFirstName() {
		return employeeFirstName;
	}


	public void setEmployeeFirstName(String employeeFirstName) {
		this.employeeFirstName = employeeFirstName;
	}


	public String getEmployeeLastName() {
		return employeeLastName;
	}


	public int getRoleId() {
		return roleId;
	}


	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}


	public void setEmployeeLastName(String employeeLastName) {
		this.employeeLastName = employeeLastName;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public int getDep_id() {
		return dep_id;
	}


	public void setDep_id(int dep_id) {
		this.dep_id = dep_id;
	}


	public int getSupervisor_id() {
		return supervisor_id;
	}


	public void setSupervisor_id(int supervisor_id) {
		this.supervisor_id = supervisor_id;
	}


	public int getReimbursment_status() {
		return reimbursment_status;
	}


	public void setReimbursment_status(int reimbursment_status) {
		this.reimbursment_status = reimbursment_status;
	}


	@Override
	public String toString() {
		return "Employee [emp_id=" + emp_id + ", employeeFirstName=" + employeeFirstName + ", employeeLastName="
				+ employeeLastName + ", userName=" + userName + ", password=" + password + ", email=" + email
				+ ", dep_id=" + dep_id + ", supervisor_id=" + supervisor_id + ", reimbursment_status="
				+ reimbursment_status + ", isfetched=" + isfetched + ", roleId=" + roleId + "]";
	}
	
	
	
	
	
	

}
