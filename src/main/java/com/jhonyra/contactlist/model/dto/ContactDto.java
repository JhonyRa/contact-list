package com.jhonyra.contactlist.model.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.jhonyra.contactlist.model.entity.Contact;
import lombok.Data;

@Data
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class ContactDto {

    private Long id;
    private String phone;
    private String email;
    private PersonDto person;

    public Contact transformDtoToContactWithId() {

        Contact contact = new Contact();
        contact.setId(this.getId());
        contact.setPhone(this.getPhone());
        contact.setEmail(this.getEmail());

        if(this.getPerson() != null) {
            contact.setPerson(this.getPerson().transformDtoToPersonWithId());
        }

        return contact;
    }

    public Contact transformDtoToContactWithoutId() {

        Contact contact = new Contact();
        contact.setPhone(this.getPhone());
        contact.setEmail(this.getEmail());

        if(this.getPerson() != null) {
            contact.setPerson(this.getPerson().transformDtoToPersonWithId());
        }

        return contact;
    }

}
