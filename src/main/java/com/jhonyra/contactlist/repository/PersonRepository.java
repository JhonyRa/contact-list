package com.jhonyra.contactlist.repository;

import com.jhonyra.contactlist.model.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
