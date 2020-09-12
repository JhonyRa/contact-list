package com.jhonyra.contactlist.model.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "CONTACT")
@Data
public class Contact {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name = "PHONE", nullable = false)
    private String phone;

    @Column(name = "EMAIL", nullable = false)
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PERSON", referencedColumnName = "ID", nullable = false)
    private Person person;
}
