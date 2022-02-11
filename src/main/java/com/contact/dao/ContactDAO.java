package com.contact.dao;

import java.util.List;

import com.contact.model.Contact;

public interface ContactDAO {
	
	public Integer save(Contact contact);
	
	public Integer update(Contact contact);
	
	public Contact getContact(Integer id);
	
	public Integer delete(Integer id);
	
	public List<Contact> listContact();

}
