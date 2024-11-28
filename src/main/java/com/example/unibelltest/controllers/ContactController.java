package com.example.unibelltest.controllers;

import com.example.unibelltest.dtos.ContactDto;
import com.example.unibelltest.models.enums.ContactType;
import com.example.unibelltest.services.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contact")
@RequiredArgsConstructor
public class ContactController {

    private final ContactService contactService;

    /**
     * Получение списка контактов заданного клиента (по id клиента и по типу контакта)
     */
    @GetMapping("/{clientId}")
    public ResponseEntity<List<ContactDto>> getContacts(@PathVariable(value = "clientId") Long clientId,
                                                        @RequestParam(value = "type", required = false) ContactType type) {
        return contactService.getContactsByClientAndType(clientId, type);
    }
}
