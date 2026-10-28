package com.kalume.ogame.domain;

import java.util.regex.Pattern;

/** Nombre de usuario: de 3 a 20 caracteres entre letras, números y guion bajo. */
public record UserName(String value) {

    private static final Pattern FORMAT = Pattern.compile("[A-Za-z0-9_]{3,20}");

    public UserName {
        if (value == null || value.isBlank()) {
            throw new DomainValidationException("El nombre de usuario no puede estar vacío.");
        }
        value = value.trim();
        if (!FORMAT.matcher(value).matches()) {
            throw new DomainValidationException(
                    "El nombre de usuario debe tener de 3 a 20 caracteres: letras, números o guion bajo.");
        }
    }
}
