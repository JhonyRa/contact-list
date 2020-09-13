package com.jhonyra.contactlist.controller;

import com.jhonyra.contactlist.model.dto.ContactDto;
import com.jhonyra.contactlist.model.entity.Contact;
import com.jhonyra.contactlist.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping("/list")
    public List<Contact> contactList(){

        return this.contactService.listAll();
    }

    @PostMapping("/create")
    public Contact createContact(@RequestBody ContactDto contactDto){

        Contact contact = contactDto.transformDtoToContactWithoutId();

        this.contactService.create(contact);

        return contact;
    }

}
