package com.example.unibelltest.repos;

import com.example.unibelltest.models.Contact;
import com.example.unibelltest.models.enums.ContactType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactRepo extends JpaRepository<Contact, Long> {
    List<Contact> findByTypeAndId(ContactType type, Long id);

    List<Contact> findByClientId(Long clientId);
}
