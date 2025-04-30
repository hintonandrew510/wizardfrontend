package web.data;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import web.model.Agent;
import web.model.Contact;

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
