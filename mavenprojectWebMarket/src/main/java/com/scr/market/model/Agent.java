package com.scr.market.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Entity;



import javax.persistence.Table;
@Entity // This tells Hibernate to make a table out of this class
@Table(name="agent")

public class Agent {
	@Id
        @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer agentid;
	
	private Integer contactId;
	private String address;
	private String password;
	public Integer getAgentid() {
		return agentid;
	}
	public void setAgentid(Integer agentid) {
		this.agentid = agentid;
	}
	public Integer getContactId() {
		return contactId;
	}
	public void setContactId(Integer contactId) {
		this.contactId = contactId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
