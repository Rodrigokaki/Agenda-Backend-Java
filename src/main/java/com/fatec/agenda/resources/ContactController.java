package com.fatec.agenda.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.agenda.dtos.ContactRequest;
import com.fatec.agenda.dtos.ContactResponse;
import com.fatec.agenda.services.ContactService;

@RestController
@RequestMapping("contacts")
public class ContactController {
    
    @Autowired
    private ContactService contactService;

    @GetMapping
    public List<ContactResponse> getContacts(){
        return contactService.getContacts();
    }

    @GetMapping("{id}")
    public ContactResponse getContactById(@PathVariable int id){
        return contactService.getContactById(id);
    }

    @DeleteMapping("{id}")
    public void deleteContactById(@PathVariable int id){
        this.contactService.deleteContactById(id);
    }

    @PostMapping
    public ContactResponse saveContact(@RequestBody ContactRequest contact){
        return this.contactService.saveContact(contact);
    }

    @PutMapping("{id}")
    public void updateContact(@PathVariable int id, @RequestBody ContactRequest contact){
        this.contactService.updateContact(id, contact);
    }
}
