package com.fatec.agenda.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fatec.agenda.entities.Contact;

public interface ContactRepository extends JpaRepository<Contact, Integer>{
    
}
