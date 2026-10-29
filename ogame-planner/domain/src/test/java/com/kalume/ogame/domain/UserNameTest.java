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
    @ValueSource(strings = {"ñandú", "Ángel_2", "José", "Müller", "Åsa"})
    void acceptsLettersFromOtherLanguages(String raw) {
        assertEquals(raw, new UserName(raw).value());
    }

    @Test
    void storesAccentedLettersInTheirComposedForm() {
        var decomposed = "ñandú"; // "ñandú" con la ñ escrita como n + tilde suelta

        assertEquals("ñandú", new UserName(decomposed).value());
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"   ", "ab", "con espacio", "con-guion", "emoji😀", "aaaaaaaaaaaaaaaaaaaaa"})
    void rejectsInvalidNames(String raw) {
        assertThrows(DomainValidationException.class, () -> new UserName(raw));
    }
}
