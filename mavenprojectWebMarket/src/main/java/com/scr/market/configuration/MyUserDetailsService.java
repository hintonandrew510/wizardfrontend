package com.scr.market.configuration;

import com.scr.market.model.Agent;
import com.scr.market.model.Contact;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;



public class MyUserDetailsService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Agent agent = null;
		Contact contact = null;
		if (agent == null) {
			throw new UsernameNotFoundException(username);
		}
		return new MyUserPrincipal(agent, contact);

	}

}
