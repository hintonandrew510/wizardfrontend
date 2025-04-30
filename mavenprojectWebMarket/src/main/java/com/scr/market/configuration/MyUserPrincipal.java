package com.scr.market.configuration;

import com.scr.market.model.Agent;
import com.scr.market.model.Contact;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;


public class MyUserPrincipal implements UserDetails {
	private static final Logger mLog = LoggerFactory.getLogger(MyUserPrincipal.class.getName());
	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	private Agent agent;
	private Contact contact;

	public MyUserPrincipal(Agent agent, Contact contact) {
		this.agent = agent;
		this.contact = contact;
		
	}


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		mLog.info("getAuthorities");
		final List<GrantedAuthority> grantedAuths = new ArrayList<>();
		grantedAuths.add(new org.springframework.security.core.authority.SimpleGrantedAuthority("ROLE_ADMIN"));
		//
		
		for (GrantedAuthority item : grantedAuths) {
			mLog.info("getAuthority" + item.getAuthority());
	    }
		return grantedAuths;

	}

	@Override
	public String getPassword() {
		String password = agent.getPassword();
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return agent.getAddress();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		mLog.info("isAccountNonExpired true");
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		mLog.info("isAccountNonExpired true");
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		mLog.info("isCredentialsNonExpired true");
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		mLog.info("isEnabled true");
		return true;
	}
	@Override
	public String toString() {
		return "";
	}

}
