package com.jhonyra.contactlist.service;

import com.jhonyra.contactlist.model.entity.Person;
import com.jhonyra.contactlist.repository.PersonRepository;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

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
}
