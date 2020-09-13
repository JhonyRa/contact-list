package com.jhonyra.contactlist.model.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.jhonyra.contactlist.model.entity.Person;
import lombok.Data;

@Data
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class PersonDto {

    private Long id;
    private String name;
    private String nikname;

    public Person transformDtoToPersonWithId() {

        Person person = new Person();
        person.setId(this.getId());
        person.setName(this.getName());
        person.setNikname(this.getNikname());

        return person;
    }

    public Person transformDtoToPersonWithoutId() {

        Person person = new Person();
        person.setName(this.getName());
        person.setNikname(this.getNikname());

        return person;
    }

}
