package com.kalume.ogame.domain;

import java.text.Normalizer;
import java.util.regex.Pattern;

/** Nombre de usuario: de 3 a 20 caracteres entre letras de cualquier idioma, números y guion bajo. */
public record UserName(String value) {

    private static final Pattern FORMAT = Pattern.compile("[\\p{L}\\p{N}_]{3,20}");

    public UserName {
        if (value == null || value.isBlank()) {
            throw new DomainValidationException("El nombre de usuario no puede estar vacío.");
        }
        // NFC: una "ñ" escrita como n + tilde suelta (frecuente en macOS) se guarda como la letra única.
        value = Normalizer.normalize(value.trim(), Normalizer.Form.NFC);
        if (!FORMAT.matcher(value).matches()) {
            throw new DomainValidationException(
                    "El nombre de usuario debe tener de 3 a 20 caracteres: letras, números o guion bajo.");
        }
    }
}
