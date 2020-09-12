package com.jhonyra.contactlist.repository;

import com.jhonyra.contactlist.model.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}
