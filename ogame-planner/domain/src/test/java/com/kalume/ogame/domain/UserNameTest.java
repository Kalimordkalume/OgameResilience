package com.kalume.ogame.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class UserNameTest {

    @Test
    void trimsSurroundingSpaces() {
        assertEquals("kalume_1", new UserName("  kalume_1 ").value());
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"   ", "ab", "con espacio", "tilde_ñ", "con-guion", "aaaaaaaaaaaaaaaaaaaaa"})
    void rejectsInvalidNames(String raw) {
        assertThrows(DomainValidationException.class, () -> new UserName(raw));
    }
}
