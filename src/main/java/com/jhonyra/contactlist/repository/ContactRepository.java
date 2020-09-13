package com.jhonyra.contactlist.repository;

import com.jhonyra.contactlist.model.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, Long> {

    @Query(value= "SELECT m FROM Contact m ")
    List<Contact> findAll();


}
