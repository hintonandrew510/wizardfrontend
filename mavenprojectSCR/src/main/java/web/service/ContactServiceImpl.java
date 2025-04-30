package web.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.model.Contact;
import web.repository.AgentRepository;
import web.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {
	 @Autowired
	    private ContactRepository contactRepository;

	@Override
	public Contact findByEmailaddressAndPassword(String emailaddress, String password) {
		// TODO Auto-generated method stub
		return contactRepository.findByEmailaddressAndPassword(emailaddress, password);
	}

	@Override
	public Contact findByEmailaddress(String emailaddresss) {
		// TODO Auto-generated method stub
		return contactRepository.findByEmailaddress(emailaddresss);
	}
	
	public Optional<Contact> findById(int contactId) {
		return contactRepository.findById(contactId);
		
	}

}
