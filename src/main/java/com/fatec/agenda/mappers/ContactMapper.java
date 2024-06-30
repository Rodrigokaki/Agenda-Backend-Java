package com.fatec.agenda.mappers;

import com.fatec.agenda.dtos.ContactRequest;
import com.fatec.agenda.dtos.ContactResponse;
import com.fatec.agenda.entities.Contact;

public class ContactMapper {
    public static Contact toEntity(ContactRequest request){
        Contact contact = new Contact();
        contact.setName(request.name());
        contact.setAge(request.age());
        contact.setGender(request.gender());
        contact.setTelephone(request.telephone());
        contact.setFavorite(request.favorite());
        return contact;
    }

    public static ContactResponse toDTO(Contact contact){
        return new ContactResponse(contact.getId(), contact.getName(), contact.getAge(), contact.getGender(), contact.getTelephone(), contact.getFavorite());
    }
}
