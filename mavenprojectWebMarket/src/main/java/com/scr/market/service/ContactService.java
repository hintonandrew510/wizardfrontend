package com.scr.market.service;

import com.scr.market.model.Contact;
import java.util.Optional;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;


@Service
public interface ContactService {
	public Contact findByEmailaddressAndPassword(@Param("emailaddress") String emailaddress,
			@Param("password") String password);

	public Contact findByEmailaddress(@Param("emailaddress") String emailaddresss);
	public Optional<Contact>  findById(int contactId);

}
