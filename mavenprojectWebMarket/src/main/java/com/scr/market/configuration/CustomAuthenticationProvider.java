package com.scr.market.configuration;

import com.scr.market.data.MyUserPrincipal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;


import com.scr.market.model.Contact;
import com.scr.market.repository.ContactRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
	private static final Logger mLog = LoggerFactory.getLogger(CustomAuthenticationProvider.class.getName());
	@Autowired
	private ContactRepository mContactRepository;
    public CustomAuthenticationProvider() {
        super();
    }

    // API

    @Override
    public Authentication authenticate(final Authentication authentication) throws AuthenticationException {
	     mLog.info("starting authenticate");
        final String name = authentication.getName();
        Contact contact = null;
        final String password = authentication.getCredentials().toString();
        if (name.equals("admin") && password.equals("admin")) {
            final List<GrantedAuthority> grantedAuths = new ArrayList<>();
            grantedAuths.add(new SimpleGrantedAuthority("ROLE_USER"));
            final UserDetails principal = new User(name, password, grantedAuths);
            final Authentication auth = new UsernamePasswordAuthenticationToken(principal, password, grantedAuths);
            return auth;
        } else {
        	try {
        	contact = mContactRepository.findByAddressAndPassword(name,password);
        	} catch (Exception e) {
        		mLog.error(e.getMessage() );
        		UsernameNotFoundException usernameNotFoundException = new UsernameNotFoundException("duplicate email addresses");
        	    throw usernameNotFoundException;
        	}
        	if (contact == null ) {
        		mLog.info("Invalid [" + name + " " +  password + "]" );
        		AuthenticationException ex=new AuthenticationCredentialsNotFoundException("Credentials Not Found");
				throw ex;
        		
        	}
		//determine if contact is valid
		boolean hasExpired = com.scr.market.util.CalendarHelper.hasExpired(contact.getStartDate(),contact.getEndDate());
		 mLog.info("Has an invalid license [" + hasExpired + "]" );
		if (hasExpired) {
			AuthenticationException ex=new AccountExpiredException("License has expired");
			throw ex;
		}
        	//Contact contact = contactList.get(0);
        	final List<GrantedAuthority> grantedAuths = new ArrayList<>();
            grantedAuths.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            MyUserPrincipal myUserPrincipal = new MyUserPrincipal(contact);
            final Authentication auth = new UsernamePasswordAuthenticationToken(myUserPrincipal, password, grantedAuths);
            return auth;
        }
    }

    @Override
    public boolean supports(final Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

}
