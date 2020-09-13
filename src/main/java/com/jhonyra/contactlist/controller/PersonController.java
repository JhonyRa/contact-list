package com.jhonyra.contactlist.controller;

import com.jhonyra.contactlist.model.dto.PersonDto;
import com.jhonyra.contactlist.model.entity.Person;
import com.jhonyra.contactlist.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/list")
    public List<Person> personList(){
        List<Person> listAll = this.personService.listAll();

        return listAll;
    }

    @PostMapping("/create")
    public Person createPerson(@RequestBody PersonDto personDto){

        Person person = personDto.transformDtoToPersonWithoutId();

        this.personService.create(person);

        return person;
    }

}
