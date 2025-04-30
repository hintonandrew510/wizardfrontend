package web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import web.model.Contact;

public interface ContactRepository extends CrudRepository<Contact, Integer> {

	public Contact findByEmailaddressAndPassword(@Param("emailaddress") String emailaddress,
			@Param("password") String password);

	public Contact findByEmailaddress(@Param("emailaddress") String emailaddresss);

}
