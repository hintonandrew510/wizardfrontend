package web.configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import web.data.MyUserPrincipal;
import web.model.Agent;
import web.model.Contact;
import web.repository.AgentRepository;
import web.repository.ContactRepository;

//import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
	//private static final Logger mLog = LoggerFactory.getLogger(CustomAuthenticationProvider.class.getName());
	private static final Logger mLog = LoggerFactory.getLogger(CustomAuthenticationProvider.class);
	
	@Autowired
	private AgentRepository mAgentRepository;
	@Autowired
	private ContactRepository mContactRepository;

	public CustomAuthenticationProvider() {
		super();
	}

	// API

	@Override
	public Authentication authenticate(final Authentication authentication) throws AuthenticationException {
		mLog.info("------------starting authenticate-------------");
		Contact contact = null;
	
		final String name = authentication.getName();
		final String password = authentication.getCredentials().toString();
		if (name.equals("admin") && password.equals("admin")) {
			final List<GrantedAuthority> grantedAuths = new ArrayList<>();
			grantedAuths.add(new SimpleGrantedAuthority("ROLE_USER"));
			final UserDetails principal = new User(name, password, grantedAuths);
			final Authentication auth = new UsernamePasswordAuthenticationToken(principal, password, grantedAuths);
			return auth;
		} else {
			Agent agent = mAgentRepository.findByAddressAndPassword(name, password);

			if (agent == null) {
				mLog.info("could not find agent [" + name);
				//return null;
				throw new BadCredentialsException("Could not find agent");
				
			}
			mLog.info("found agent [" + name);
			Optional<Contact> contactOpt = mContactRepository.findById(agent.getContactId());
			contact = contactOpt.orElse(null);
			if (contact == null) {
				mLog.info("could not find contact---------" + agent.getContactId());
				AuthenticationException ex=new AuthenticationCredentialsNotFoundException("Credentials Not Found");
				throw ex;
				//return null;
			}
			// determine if contact is valid
			boolean hasExpired = web.util.CalendarHelper.hasExpired(contact.getStartDate(), contact.getEndDate());
			mLog.info("Has an invalid license [" + hasExpired + "]");
			if (hasExpired) {
				AuthenticationException ex=new AccountExpiredException("License has expired  contact " + contact.getName() + " or email " + contact.getEmailaddress() );
				mLog.info("Has an invalid license [" + ex.getMessage() + "]");
				//System.out.println("Has an invalid license [" + ex.getMessage() + "]");
				
				throw ex;
				//return null;
			}
			// Contact contact = contactList.get(0);
			final List<GrantedAuthority> grantedAuths = new ArrayList<>();
			grantedAuths.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
			MyUserPrincipal myUserPrincipal = new MyUserPrincipal(agent, contact);
			final Authentication auth = new UsernamePasswordAuthenticationToken(myUserPrincipal, password,
					grantedAuths);
			return auth;
		}
	}

	@Override
	public boolean supports(final Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
