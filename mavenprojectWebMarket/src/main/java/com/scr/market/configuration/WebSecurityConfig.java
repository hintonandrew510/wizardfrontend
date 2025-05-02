package com.scr.market.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import static org.springframework.security.config.Customizer.withDefaults;

//.antMatchers("/css/**", "/js/**", "/img/**").permitAll().anyRequest().permitAll()    
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    private static final Logger mLog = LoggerFactory.getLogger(WebSecurityConfig.class.getName());
    private final MyUserDetailService myUserDetailService;
    //@Autowired
    //private CustomAuthenticationProvider authProvider;

    // Constructor injection for MyUserDetailService
    public WebSecurityConfig(MyUserDetailService myUserDetailService) {
        mLog.info("WebSecurityConfig");
        this.myUserDetailService = myUserDetailService;
    }

    /**
     * Configures the security filter chain.
     *
     * @param httpSecurity the HttpSecurity object to configure
     * @return the configured SecurityFilterChain
     * @throws Exception in case of any configuration error
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        mLog.info("securityFilterChain");
        return httpSecurity.authorizeHttpRequests(authorize -> {
            // Permit access to static resources and login, home, and error pages
            authorize.requestMatchers("/css/**", "/js/**", "/images/**").permitAll();
            authorize.requestMatchers("/login", "/error/**", "/logout", "/", "/index.html","/contacts").permitAll();
            // Restrict access to admin and user pages based on roles
            authorize.requestMatchers("/admin/**").hasRole("ADMIN");
            authorize.requestMatchers("/user/**").hasRole("USER");
            // All other requests require authentication
            authorize.anyRequest().authenticated();
        }).formLogin(formLogin -> formLogin.loginPage("/login") // Custom login page
                .defaultSuccessUrl("/", true) // Redirect to home after successful login
                .failureHandler(customAuthenticationFailureHandler())
                .permitAll()).logout(logout -> logout.logoutUrl("/logout").logoutSuccessUrl("/login?logout") // Redirect
                // to
                // login
                // page
                // after
                // logout
                .permitAll())
                .csrf(AbstractHttpConfigurer::disable) // Disable CSRF for simplicity (not recommended for production)
                .build();
    }

//	@Bean
    //public UserDetailsService userDetailService() {
//		return myUserDetailService;
//	}
    /**
     * Configures the AuthenticationProvider.
     *
     * @return the configured AuthenticationProvider
     */
    @Bean
    public AuthenticationProvider authenticationProvider() {
        mLog.info("authenticationProvider");

        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(myUserDetailService);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
    }

    @SuppressWarnings("deprecation")
    @Bean
    public PasswordEncoder passwordEncoder() {
        mLog.info("passwordEncoder()");
        return new MyCustomPasswordEncoder();
    }

    @Bean
    public AuthenticationFailureHandler customAuthenticationFailureHandler() {

        return new CustomAuthenticationFailureHandler();
    }

}
