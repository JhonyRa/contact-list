package com.jhonyra.contactlist.service;

import com.jhonyra.contactlist.model.entity.Contact;
import com.jhonyra.contactlist.model.entity.Person;
import com.jhonyra.contactlist.repository.PersonRepository;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public List<Person> listAll() {
        return this.personRepository.findAll();
    }

    public Person create(Person person){

        if(person.getId() != null) { //verifica se o id da pesso é difetente de nulo.
            throw new ServiceException("Nao eh possivel salvar, pois o id esta preenchido"); //id gerado automático na criação
        }
        this.personRepository.save(person);

        return person;
    }

    public Person update(Person person){

        if(person.getId() == null) { //verifica se o id do person é igual a null
            throw new ServiceException("Nao eh possivel alterar, pois o id nao esta preenchido"); //se for null exibe exceção
        }

        Optional<Person> currentPerson = this.personRepository.findById(person.getId()); //valida se o id recebido existe no banco.

        if(!currentPerson.isPresent()) {
            throw new ServiceException("Nao eh possivel salvar pois a pessoa nao existe");
        }

        this.personRepository.save(person);

        return person;
    }

    public boolean delete(Long pesonId) {

        Optional<Person> currentGame = this.personRepository.findById(pesonId);

        if(!currentGame.isPresent()) {
            throw new ServiceException("Nao eh possivel deletar pois o objeto nao existe");
        }

        this.personRepository.delete(currentGame.get());

        return true;
    }
}
