package com.scr.market.configuration;


import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;



import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Created by JavaDeveloperZone on 13-11-2017.
 * Spring Security will send control to CustomAuthenticationFailureHandler when authentication will get failed
 */
public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {
	private static final Logger mLog = LoggerFactory.getLogger(CustomAuthenticationFailureHandler.class.getName());

	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		// TODO Auto-generated method stub
		mLog.info("AUTH ERROR " + exception.getMessage());
		
		
		if (exception instanceof BadCredentialsException) {
			mLog.info("BadCredentialsException");
			request.getSession().setAttribute("BadCredentialsException", "BadCredentialsException");
			request.getSession().setAttribute("ExceptionMessage", exception.getMessage());
			
		}
		if (exception instanceof AuthenticationCredentialsNotFoundException) {
			mLog.info("AuthenticationCredentialsNotFoundException");
			request.getSession().setAttribute("ExceptionMessage", exception.getMessage());
			request.getSession().setAttribute("AuthenticationCredentialsNotFoundException", "AuthenticationCredentialsNotFoundException");
			
		}
		if (exception instanceof AccountExpiredException) {
			mLog.info("AccountExpiredException");
			request.getSession().setAttribute("ExceptionMessage", exception.getMessage());
			request.getSession().setAttribute("AccountExpiredException", "AccountExpiredException");
			
		}	
		
	
		response.sendRedirect("login");
		
	}

	@Override
	public void onAuthenticationFailure(jakarta.servlet.http.HttpServletRequest request,
			jakarta.servlet.http.HttpServletResponse response, AuthenticationException exception)
	
			throws IOException, jakarta.servlet.ServletException {
		
		mLog.info("onAuthenticationFailure " + exception.getMessage());
		
		// TODO Auto-generated method stub
		
	}

	
}