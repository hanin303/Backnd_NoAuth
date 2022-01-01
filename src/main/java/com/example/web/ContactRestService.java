package com.example.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.Contact;
import com.example.metier.InterContactMetier;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class ContactRestService {
	@Autowired
	private InterContactMetier contactMetier;

	@RequestMapping(value="/contact",method = RequestMethod.GET)
	@PreAuthorize("hasAuthority('ADMIN')")
	public List<Contact> getContact(){
		return contactMetier.getContact();
	}


	@RequestMapping(value="/contact/{id_Contact}",method = RequestMethod.GET)
	@PreAuthorize("hasAuthority('ADMIN')")
    public Contact getContact(@PathVariable long id_Contact) {
		return contactMetier.getOneContact(id_Contact);
	}

	@RequestMapping(value="/contact",method = RequestMethod.POST)
	public Contact AddContact(@RequestBody Contact contact){
    	return contactMetier.AddContact(contact);
	}



	@RequestMapping(value="/contact/{id_Contact}",method = RequestMethod.DELETE)
	@ResponseBody
	@PreAuthorize("hasAuthority('ADMIN')")
	public void deleteContact(@PathVariable long id_Contact) {
			contactMetier.deleteContact(id_Contact);
	}


}
