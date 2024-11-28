package com.example.unibelltest.models;

import com.example.unibelltest.dtos.ContactCreateDto;
import com.example.unibelltest.models.enums.ContactType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private ContactType type;

    @Column(nullable = false)
    private String contact;

    @ManyToOne(fetch = FetchType.LAZY)
    private Client client;

    public Contact(ContactCreateDto newContact) {
        this.type = newContact.getContactType();
        this.contact = newContact.getContact();
    }
}
