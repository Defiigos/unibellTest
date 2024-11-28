package com.example.unibelltest.models.enums;

import lombok.Getter;

@Getter
public enum ContactType {
    EMAIL ("Электронная почта"),
    PHONE ("Телефон");

    private String caption;

    ContactType(String caption) {
        this.caption = caption;
    }
}
