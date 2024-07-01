package com.fatec.agenda.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fatec.agenda.dtos.ContactRequest;
import com.fatec.agenda.dtos.ContactResponse;
import com.fatec.agenda.services.ContactService;

@CrossOrigin
@RestController
@RequestMapping("contacts")
public class ContactController {
    
    @Autowired
    private ContactService contactService;

    @GetMapping
    public ResponseEntity<List<ContactResponse>> getContacts(){
        return ResponseEntity.ok(contactService.getContacts());
    }

    @GetMapping("{id}")
    public ResponseEntity<ContactResponse> getContactById(@PathVariable int id){
        return ResponseEntity.ok(contactService.getContactById(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteContactById(@PathVariable int id){
        this.contactService.deleteContactById(id);

        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<ContactResponse> saveContact(@Validated @RequestBody ContactRequest contact){
        ContactResponse newContact = this.contactService.saveContact(contact);

        URI location = ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(newContact.id())
                        .toUri();

        return ResponseEntity.created(location).body(newContact);

    }

    @PutMapping("{id}")
    public ResponseEntity<Void> updateContact(@PathVariable int id, @Validated @RequestBody ContactRequest contact){
        this.contactService.updateContact(id, contact);

        return ResponseEntity.ok().build();
    }
}
