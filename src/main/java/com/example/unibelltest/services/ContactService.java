package com.example.unibelltest.services;

import com.example.unibelltest.dtos.ContactDto;
import com.example.unibelltest.models.enums.ContactType;
import com.example.unibelltest.repos.ContactRepo;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContactService {

    private final ContactRepo contactRepo;

    /**
     * Получение списка контактов заданного клиента (по id клиента и по типу контакта)
     */
    public ResponseEntity<List<ContactDto>> getContactsByClientAndType(Long clientId, ContactType contactType) {
        val contacts = contactType == null ? contactRepo.findByClientId(clientId)
                : contactRepo.findByTypeAndId(contactType, clientId);

        return ResponseEntity.ok(contacts.stream().map(ContactDto::build).toList());
    }
}
