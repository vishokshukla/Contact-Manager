package com.contact.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.contact.model.Contact;

class ContactDAOTest {
	private DriverManagerDataSource dataSource;
	private ContactDAO dao;

	@BeforeEach
	void setupBeforeEach() {
		dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/contacts");
		dataSource.setUsername("root");
		dataSource.setPassword("VishokShukla@121097");
		
		dao = new ContactDAOImpl(dataSource);
	}
	
	@Test
	void testSave() {
		Contact contact = new Contact("Anurag","anurag@gmail.com","Varanasi","9876540212");
		int result = dao.save(contact);
		
		assertTrue(result > 0);
	}

	@Test
	void testUpdate() {
		Contact contact = new Contact(2,"Anurag","anurag.rawat@gmail.com","Varanasi","9876540212");
		int result = dao.update(contact);
		
		assertTrue(result > 0);
	}

	@Test
	void testGetContact() {
		int id = 1;
		Contact contact = dao.getContact(id);
		if(contact != null)
			System.out.println(contact);
		assertNotNull(contact);
	}

	@Test
	void testDelete() {
		int id = 3;
		int result = dao.delete(id);
		assertTrue(result > 0);
	}

	@Test
	void testListContact() {
		List<Contact> listContact = dao.listContact();
		for(Contact c : listContact)
			System.out.println(c);
		assertTrue(!listContact.isEmpty());
	}

}
