package com.scr.market.data;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import com.scr.market.model.Agent;
import com.scr.market.model.Contact;

public class MyUserPrincipal implements UserDetails {
	 private Contact contact;
	 
	    public MyUserPrincipal(Contact contact) {
	        this.contact = contact;
	    }

	public Contact getContact() {
			return contact;
		}

		public void setContact(Contact contact) {
			this.contact = contact;
		}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return AuthorityUtils.createAuthorityList("ROLE_USER");
		
	}

	@Override
	public String getPassword() {
		String password = contact.getPassword();
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return contact.getEmailaddress();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

}
