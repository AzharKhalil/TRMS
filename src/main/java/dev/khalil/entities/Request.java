package dev.khalil.entities;

public class Request {

	private int reqID;
	private int emp_id;
	private String date;
	private int cost;
	private String description;
	private int eventType;
	private String image;
	private int reimb_status;
	private int gradeID;
	
	
	public int getGradeID() {
		return gradeID;
	}


	public void setGradeID(int gradeID) {
		this.gradeID = gradeID;
	}


	public Request() {
		super();
	}


	public int getReqID() {
		return reqID;
	}


	public void setReqID(int reqID) {
		this.reqID = reqID;
	}


	public int getEmp_id() {
		return emp_id;
	}


	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public int getCost() {
		return cost;
	}


	public void setCost(int cost) {
		this.cost = cost;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public int getEventType() {
		return eventType;
	}


	public void setEventType(int eventType) {
		this.eventType = eventType;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public int getReimb_status() {
		return reimb_status;
	}


	public void setReimb_status(int reimb_status) {
		this.reimb_status = reimb_status;
	}


	@Override
	public String toString() {
		return "Request [reqID=" + reqID + ", emp_id=" + emp_id + ", date=" + date + ", cost=" + cost + ", description="
				+ description + ", eventType=" + eventType + ", image=" + image + ", reimb_status=" + reimb_status
				+ ", gradeID=" + gradeID + "]";
	}
	
	
	
	
}
