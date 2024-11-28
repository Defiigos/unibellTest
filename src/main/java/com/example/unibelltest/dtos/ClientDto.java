package com.example.unibelltest.dtos;

import com.example.unibelltest.models.Client;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.val;

import java.util.List;

@Data
@AllArgsConstructor
public class ClientDto {
    private Long id;
    private String name;
    private List<ContactDto> contacts;

    public static ClientDto build(Client client) {
        val contacts = client.getContacts().stream()
                .map(ContactDto::build)
                .toList();
        return new ClientDto(
                client.getId(),
                client.getName(),
                contacts
        );
    }
}
