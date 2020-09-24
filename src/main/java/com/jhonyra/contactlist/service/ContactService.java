package com.jhonyra.contactlist.service;

import com.jhonyra.contactlist.model.entity.Contact;
import com.jhonyra.contactlist.model.entity.Person;
import com.jhonyra.contactlist.repository.ContactRepository;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

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

    public Contact update(Contact contact){

        if(contact.getId() == null) { //verifica se o id do contato é igual a null
            throw new ServiceException("Nao eh possivel alterar, pois o id nao esta preenchido"); //se for null exibe exceção
        }

        Optional<Contact> currentContact = this.contactRepository.findById(contact.getId()); //valida se o id recebido existe no banco.

        if(!currentContact.isPresent()) {
            throw new ServiceException("Nao eh possivel salvar pois o contato nao existe");
        }

        this.contactRepository.save(contact);

        return contact;
    }

    public boolean delete(Long contactId) {

        Optional<Contact> currentContact = this.contactRepository.findById(contactId);

        if(!currentContact.isPresent()) {
            throw new ServiceException("Nao eh possivel deletar pois o objeto nao existe");
        }

        this.contactRepository.delete(currentContact.get());

        return true;
    }
}
