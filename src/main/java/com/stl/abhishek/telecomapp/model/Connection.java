package com.stl.abhishek.telecomapp.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
//this is nothing but our pojo class

@Entity
@Table(name="connection")
public class Connection {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="connectionNumber")
	private String connectionNumber;
	
	@Column(name="email")
	private String email;
	
	@Column(name="connectionPlan")
	private String connectionPlan;
	
	@Column(name="name")
	private String name;
	

	@Column(name="status")
	private String status;
	
	@Enumerated(EnumType.STRING)
	private plan plandetails;
	
	
	


	public plan getPlandetails() {
		return plandetails;
	}


	public void setPlandetails(plan plandetails) {
		this.plandetails = plandetails;
	}


	public Connection(Integer id, String connectionNumber, String connectionPlan, String name, String status) {
		super();
		this.id = id;
		this.connectionNumber = connectionNumber;
		this.connectionPlan = connectionPlan;
		this.name = name;
		this.status = status;
	}


	public Connection() {
		super();
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getConnectionNumber() {
		return connectionNumber;
	}


	public void setConnectionNumber(String connectionNumber) {
		this.connectionNumber = connectionNumber;
	}
	
	


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getConnectionPlan() {
		return connectionPlan;
	}


	public void setConnectionPlan(String connectionPlan) {
		this.connectionPlan = connectionPlan;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "Connection [id=" + id + ", connectionNumber=" + connectionNumber + ", connectionPlan=" + connectionPlan
				+ ", name=" + name + ", status=" + status + "]";
	}
	
	
	
	

}
