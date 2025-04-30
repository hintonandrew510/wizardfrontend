package web.service;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import web.configuration.WebSecurityConfig;
import web.data.MyUserPrincipal;
import web.model.Agent;
import web.model.Contact;
import web.repository.AgentRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class MyUserDetailService implements UserDetailsService {
	private static final Logger mLog = LoggerFactory.getLogger(MyUserDetailService.class.getName());

	 @Autowired
    private final AgentServiceImpl myUserRepository;
	 
	 @Autowired
	 private ContactServiceImpl contactServiceImpl;

    // Constructor injection for MyUserRepository
    public MyUserDetailService(AgentServiceImpl myUserRepository) {
    	mLog.info("MyUserDetailService");
        this.myUserRepository = myUserRepository;
    }
    
    //@Override
    //public Collection<GrantedAuthority> getAuthorities() {
   // 	return null;
   // /}

    /**
     * Loads the user by username.
     * 
     * @param username the username to search for
     * @return the UserDetails object
     * @throws UsernameNotFoundException if the username is not found
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	mLog.info("loadUserByUsername");
    	
    	mLog.info(username);
        Agent agent = myUserRepository.findByAddress(username);
        if (agent != null) {
        	
        	Optional<Contact> contactOpt = contactServiceImpl.findById(agent.getContactId());
        	Contact contact = contactOpt.orElse(null);
        	mLog.info("contact" + contact.getName());
        	MyUserPrincipal myUserPrincipal = new MyUserPrincipal(agent, contact);
        	mLog.info("found");
        	mLog.info("contact " + contact.getName());
        	mLog.info("agent " + agent.getAddress());
        	
        	//myUserPrincipal.
            return myUserPrincipal;

                    
                   
        } else {
            throw new UsernameNotFoundException(username);
        }
    }







}