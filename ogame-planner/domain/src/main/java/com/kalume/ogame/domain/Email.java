package com.kalume.ogame.domain;

import java.util.Locale;
import java.util.regex.Pattern;

/** Correo electrónico, guardado en minúsculas. La comprobación es de forma, no de que exista. */
public record Email(String value) {

    private static final int MAX_LENGTH = 254;
    private static final Pattern FORMAT = Pattern.compile("[^@\\s]+@[^@\\s]+\\.[^@\\s]+");

    public Email {
        if (value == null || value.isBlank()) {
            throw new DomainValidationException("El correo electrónico no puede estar vacío.");
        }
        value = value.trim().toLowerCase(Locale.ROOT);
        if (value.length() > MAX_LENGTH || !FORMAT.matcher(value).matches()) {
            throw new DomainValidationException("El correo electrónico no tiene un formato válido.");
        }
    }
}
