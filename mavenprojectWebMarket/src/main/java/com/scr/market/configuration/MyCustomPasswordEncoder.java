package com.scr.market.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;

public class MyCustomPasswordEncoder implements PasswordEncoder {
	private static final Logger mLog = LoggerFactory.getLogger(MyCustomPasswordEncoder.class.getName());


    @Override
    public String encode(CharSequence rawPassword) {
        // Your custom encoding logic here
            	mLog.info("encoded_" + rawPassword );
        return "encoded_" + rawPassword; // Example: Prefix with "encoded_"
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        // Your custom matching logic here
    	mLog.info("matches");
        mLog.info("Raw[" + rawPassword.toString() + "]");
    	mLog.info("Encode [" + encodedPassword + "]");
        return rawPassword.toString().equalsIgnoreCase(encodedPassword);
       
    }
}