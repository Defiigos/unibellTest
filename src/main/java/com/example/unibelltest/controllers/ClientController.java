package com.example.unibelltest.controllers;

import com.example.unibelltest.dtos.ClientCreateDto;
import com.example.unibelltest.dtos.ClientDto;
import com.example.unibelltest.dtos.ContactCreateDto;
import com.example.unibelltest.services.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    /**
     * Добавление нового клиента
     */
    @PostMapping("/create")
    public ResponseEntity<String> createClient(@RequestBody ClientCreateDto newClient) {
        return clientService.createClient(newClient);
    }

    /**
     * Добавление нового контакта клиента (телефон или email)
     */
    @PostMapping("/{id}/addContact")
    public ResponseEntity<String> addContactToClient(@PathVariable(value = "id") Long clientId,
                                                     @RequestBody ContactCreateDto contact) {
        return clientService.addContactToClient(clientId, contact);
    }

    /**
     * Получение списка клиентов
     */
    @GetMapping
    public ResponseEntity<List<ClientDto>> getClients() {
        return clientService.getClients();
    }

    /**
     * Получение информации по заданному клиенту (по id)
     */
    @GetMapping("/{id}")
    public ResponseEntity<ClientDto> getClient(@PathVariable(value = "id") Long clientId) {
        return clientService.getClient(clientId);
    }

}
