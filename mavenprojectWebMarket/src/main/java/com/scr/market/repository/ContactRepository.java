package com.scr.market.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


import com.scr.market.model.Contact;

public interface ContactRepository extends CrudRepository<Contact, Integer> {
   // @Modifying
   //@Query("select i.password from contact i where i.emailaddress = :emailaddress and i.password = :password")
	public Contact findByAddressAndPassword(@Param("address") String address,@Param("password") String password);
	public Contact findByEmailaddressAndPassword(@Param("address") String emailaddress,@Param("password") String password);
	public Contact findByEmailaddress(@Param("emailaddress") String emailaddresss);

}
