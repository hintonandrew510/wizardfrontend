package web.configuration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
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
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import web.data.MyUserPrincipal;
import web.model.Agent;
import web.model.Contact;
import web.repository.AgentRepository;
import web.repository.ContactRepository;
import web.service.AgentService;
import web.service.ContactService;

//import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



//@Component
//public class CustomAuthenticationProvider  implements AuthenticationProvider
public class CustomAuthenticationProvider  {

	

	

	//private static final Logger mLog = LoggerFactory.getLogger(CustomAuthenticationProvider.class.getName());
	private static final Logger mLog = LoggerFactory.getLogger(CustomAuthenticationProvider.class);
	/*
	  @Qualifier("agentRepository")
	@Autowired
	private AgentService agentService;
	@Autowired
	private ContactService contactService;

	public CustomAuthenticationProvider() {
		super();
	}
	
	 


	@Override
	public Authentication authenticate(final Authentication authentication) throws AuthenticationException {
		mLog.info("------------Starting authenticate-------------");
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
			Agent agent = agentService.findByAddressAndPassword(name, password);

			if (agent == null) {
				mLog.info("could not find agent [" + name);
				//return null;
				throw new BadCredentialsException("Invalid email address or password");
				
			}
			mLog.info("found agent [" + name);
			Optional<Contact> contactOpt = contactService.findById(agent.getContactId());
			contact = contactOpt.orElse(null);
			if (contact == null) {
				mLog.info("could not find contact---------" + agent.getContactId());
				AuthenticationException ex=new AuthenticationCredentialsNotFoundException("Credentials Not Found");
				throw ex;
				//return null;
			}
			// determine if contact is valid
			boolean hasExpired = web.util.CalendarHelper.hasExpired(contact.getStartDate(), contact.getEndDate());
			String formattedEndDate = web.util.CalendarHelper.formatTimestamp( contact.getEndDate());
			StringBuilder message= new StringBuilder();
			message.append("License has expired  " );
			message.append(" contact ");
			message.append(formattedEndDate);
			message.append(contact.getName() );
			message.append(" or email ");
			message.append( contact.getEmailaddress());
			message.append( " ");
			
			
			mLog.info("Has an invalid license [" + hasExpired + "]");
			if (hasExpired) {
				AuthenticationException ex=new AccountExpiredException(message.toString());
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
*/
}
