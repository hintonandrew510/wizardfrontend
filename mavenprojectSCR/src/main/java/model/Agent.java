package web.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity

public class Agent {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer agentid;

	private Integer contactId;
	private String address;
	private String password;
	private String googleprofile;

	public String getGoogleprofile() {
		return googleprofile;
	}

	public void setGoogleprofile(String googleprofile) {
		this.googleprofile = googleprofile;
	}

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
