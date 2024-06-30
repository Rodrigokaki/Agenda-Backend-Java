package com.fatec.agenda.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.agenda.dtos.ContactRequest;
import com.fatec.agenda.dtos.ContactResponse;
import com.fatec.agenda.entities.Contact;
import com.fatec.agenda.mappers.ContactMapper;
import com.fatec.agenda.repositories.ContactRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ContactService {
    
    @Autowired
    private ContactRepository contactRepository;


    public List<ContactResponse> getContacts(){
        List<Contact> contacts = contactRepository.findAll();

        return contacts.stream().map(c -> ContactMapper.toDTO(c)).collect(Collectors.toList());
    }

    public ContactResponse getContactById(int id){
        Contact contact = contactRepository.findById(id).orElseThrow(
            () -> new EntityNotFoundException("Contato não cadastrado")
        );

        return ContactMapper.toDTO(contact);
    }

    public void deleteContactById(int id){
        if (this.contactRepository.existsById(id)){
            this.contactRepository.deleteById(id);
        }
        else {
            throw new EntityNotFoundException("Contato não cadastrado");
        }
    }

    public ContactResponse saveContact(ContactRequest request){
        Contact contact = ContactMapper.toEntity(request);

        return ContactMapper.toDTO(this.contactRepository.save(contact));
    }

    public void updateContact(int id, ContactRequest request){
        try{
            Contact aux = contactRepository.getReferenceById(id);

            aux.setName(request.name());
            aux.setAge(request.age());
            aux.setGender(request.gender());
            aux.setTelephone(request.telephone());
            aux.setFavorite(request.favorite());

            this.contactRepository.save(aux);
        } catch (EntityNotFoundException e){
            throw new EntityNotFoundException("Contato não cadastrado");
        }
    }
}
