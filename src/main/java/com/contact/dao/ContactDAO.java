package com.contact.dao;

import java.util.List;

import com.contact.model.Contact;

public interface ContactDAO {
	
	public int save(Contact contact);
	
	public int update(Contact contact);
	
	public Contact getContact(int id);
	
	public int delete(int id);
	
	public List<Contact> listContact();

}
