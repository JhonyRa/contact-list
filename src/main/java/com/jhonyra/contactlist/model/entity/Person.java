package com.jhonyra.contactlist.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Embeddable
@Data
@Table(name = "PERSON")
public class Person{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "NICKNAME", nullable = true)
    private String nikname;

    @OneToMany(mappedBy = "person", fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private List<Contact> contacts;

}