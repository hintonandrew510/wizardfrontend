package com.scr.market.configuration;

import com.scr.market.data.MyUserPrincipal;
import com.scr.market.model.Agent;
import com.scr.market.model.Contact;
import com.scr.market.service.AgentServiceImpl;
import com.scr.market.service.ContactServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class MyUserDetailService implements UserDetailsService {

    private static final Logger mLog = LoggerFactory.getLogger(MyUserDetailService.class.getName());

    @Autowired
    private final ContactServiceImpl contactServiceImpl;

    // Constructor injection for MyUserRepository
    public MyUserDetailService(ContactServiceImpl contactServiceImpl) {
        mLog.info("MyUserDetailService");
        this.contactServiceImpl = contactServiceImpl;
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
        Contact contact = contactServiceImpl.findByEmailaddress(username);
        if (contact != null) {

             mLog.info("contact" + contact.getName());
            MyUserPrincipal myUserPrincipal = new MyUserPrincipal(contact);
            mLog.info("found");
            mLog.info("contact " + contact.getName());
           

            //myUserPrincipal.
            return myUserPrincipal;

        } else {
            throw new UsernameNotFoundException(username);
        }
    }

}
