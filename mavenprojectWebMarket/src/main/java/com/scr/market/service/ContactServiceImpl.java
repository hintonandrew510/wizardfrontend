/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.scr.market.service;

import com.scr.market.model.Contact;
import com.scr.market.repository.ContactRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author andrewhinton
 */
public class ContactServiceImpl implements ContactService{
  @Autowired
	    private ContactRepository contactRepository;
    @Override
    public Contact findByEmailaddressAndPassword(String emailaddress, String password) {
        return contactRepository.findByEmailaddressAndPassword(emailaddress, password);
    }

    @Override
    public Contact findByEmailaddress(String emailaddresss) {
        return contactRepository.findByEmailaddress(emailaddresss);
    }

    @Override
    public Optional<Contact> findById(int contactId) {
        return contactRepository.findById(contactId);
    }
    
}
