package web.configuration;

import java.security.Principal;

public class UserInfo implements Principal {
	private String username;
	private Integer agentid;

	private Integer contactId;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

}
