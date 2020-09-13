package com.jhonyra.contactlist.service;

import com.jhonyra.contactlist.model.entity.Contact;
import com.jhonyra.contactlist.repository.ContactRepository;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public List<Contact> listAll() {
        return this.contactRepository.findAll();
    }

    public Contact create(Contact contact){

        if(contact.getId() != null) { //verifica se o id do contato é difetente de nulo.
            throw new ServiceException("Nao eh possivel salvar, pois o id esta preenchido"); //id gerado automático na criação
        }
        this.contactRepository.save(contact);

        return contact;
    }
}
