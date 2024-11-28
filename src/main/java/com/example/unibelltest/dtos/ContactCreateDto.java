package com.example.unibelltest.dtos;

import com.example.unibelltest.models.enums.ContactType;
import lombok.Data;

@Data
public class ContactCreateDto {
    private ContactType contactType;
    private String contact;
}
