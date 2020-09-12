package com.jhonyra.contactlist.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "PERSON")
@Data
public class Person {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name = "NAME",  nullable = false)
    private String name;

    @Column(name = "NICKNAME", nullable = true)
    private String nikname;

    @OneToMany(mappedBy = "person", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Contact> contacts;

    public Set<Contact> getCategories(){
        if(this.contacts == null) {
            this.contacts = new HashSet<>();
        }
        return this.contacts;
    }
}
