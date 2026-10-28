package com.kalume.ogame.domain;

/** Un valor no cumple las reglas del dominio. El mensaje está pensado para mostrárselo al usuario. */
public class DomainValidationException extends RuntimeException {

    public DomainValidationException(String message) {
        super(message);
    }
}
