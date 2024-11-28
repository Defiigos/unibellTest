package com.example.unibelltest.dtos;

import com.example.unibelltest.models.Contact;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ContactDto {
    private Long id;
    private String contactType;
    private String contact;

    public static ContactDto build(Contact contact) {
        return new ContactDto(
                contact.getId(),
                contact.getType().getCaption(),
                contact.getContact()
        );
    }
}
