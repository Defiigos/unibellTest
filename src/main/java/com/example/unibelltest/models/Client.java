package com.example.unibelltest.models;

import com.example.unibelltest.dtos.ClientCreateDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "contact", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Contact> contacts = new HashSet<>();

    public Client(ClientCreateDto newClient) {
        this.name = newClient.getName();
    }

    public void addContact(Contact contact) {
        this.contacts.add(contact);
        contact.setClient(this);
    }
}
