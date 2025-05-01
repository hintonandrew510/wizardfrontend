package com.scr.market.data;

import com.scr.market.configuration.CustomAuthenticationProvider;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import com.scr.market.model.Agent;
import com.scr.market.model.Contact;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyUserPrincipal implements UserDetails {

    private Contact contact;
    private static final Logger mLog = LoggerFactory.getLogger(MyUserPrincipal.class.getName());

    public MyUserPrincipal(Contact contact) {
        this.contact = contact;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        mLog.info("getAuthorities");
        final List<GrantedAuthority> grantedAuths = new ArrayList<>();
        grantedAuths.add(new org.springframework.security.core.authority.SimpleGrantedAuthority("ROLE_ADMIN"));
        //

        for (GrantedAuthority item : grantedAuths) {
            mLog.info("getAuthority" + item.getAuthority());
        }
        return grantedAuths;

    }

    @Override
    public String getPassword() {
        String password = contact.getPassword();
        return password;
    }

    @Override
    public String getUsername() {
        // TODO Auto-generated method stub
        return contact.getEmailaddress();
    }

    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return true;
    }

}
