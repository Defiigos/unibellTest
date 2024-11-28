package com.example.unibelltest.services;

import com.example.unibelltest.dtos.ClientCreateDto;
import com.example.unibelltest.dtos.ClientDto;
import com.example.unibelltest.dtos.ContactCreateDto;
import com.example.unibelltest.models.Client;
import com.example.unibelltest.models.Contact;
import com.example.unibelltest.repos.ClientRepo;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepo clientRepo;

    /**
     * Добавление нового клиента
     */
    public ResponseEntity<String> createClient(ClientCreateDto newClient) {
        clientRepo.save(new Client(newClient));
        return ResponseEntity.ok("Client successfully create!");
    }

    /**
     * Добавление нового контакта клиента (телефон или email)
     */
    public ResponseEntity<String> addContactToClient(Long clientId, ContactCreateDto contact) {
        val client = clientRepo.findById(clientId)
                .orElseThrow(EntityNotFoundException::new);
        client.addContact(new Contact(contact));
        clientRepo.save(client);

        return ResponseEntity.ok("Contact add to client with id:" + clientId);
    }

    /**
     * Получение списка клиентов
     */
    public ResponseEntity<List<ClientDto>> getClients() {
        return ResponseEntity.ok(clientRepo.findAll().stream()
                .map(ClientDto::build).toList());
    }

    /**
     * Получение информации по заданному клиенту (по id)
     */
    public ResponseEntity<ClientDto> getClient(Long clientId) {
        val client = clientRepo.findById(clientId)
                .orElseThrow(EntityNotFoundException::new);
        return ResponseEntity.ok(ClientDto.build(client));
    }
}
