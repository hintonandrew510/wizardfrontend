package web.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

//.antMatchers("/css/**", "/js/**", "/img/**").permitAll().anyRequest().permitAll()    
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private CustomAuthenticationProvider authProvider;
	private static final Logger mLog = LoggerFactory.getLogger(WebSecurityConfig.class.getName());

	@Override

	protected void configure(HttpSecurity http) throws Exception {
		http
		// ...
		.headers()
			.frameOptions().sameOrigin()
			.httpStrictTransportSecurity().disable();
		
		
		 http.formLogin()
	        .failureHandler(customAuthenticationFailureHandler());
		
		
		//http.ignoring().antMatchers("/api/v1/signup");
		//http.failureHandler(customAuthenticationFailureHandler());
		http.csrf().disable().authorizeRequests().antMatchers("/", "/copyright.html","/index.html", "/header.html","/privacypolicy.html", "/footer.html")
				.permitAll().antMatchers("/css/**", "/fonts/**","/vendor/**", "/js/**", "/img/**","copyright.html").permitAll().anyRequest()
				.permitAll().anyRequest().authenticated()
			        .and()
			        .formLogin().loginPage("/login").permitAll()
			        .and()
				.logout().permitAll()
			        .and()
			      	.logout()
      				.invalidateHttpSession(true)
      				.clearAuthentication(true)
      				.and()
      				.httpBasic();
	}

	@Override
	protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
		
		auth.authenticationProvider(authProvider);
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/PublishClient");
		 web.ignoring().antMatchers("/resources/**");
		 
		 
		 
	}

	@Bean
    public AuthenticationFailureHandler customAuthenticationFailureHandler() {
		//mLog.log("customAuthenticationFailureHandler");
        return new CustomAuthenticationFailureHandler();
    }

}
