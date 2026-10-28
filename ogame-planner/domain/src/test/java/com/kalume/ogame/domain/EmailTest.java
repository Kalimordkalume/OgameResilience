package com.kalume.ogame.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class EmailTest {

    @Test
    void trimsAndLowercases() {
        assertEquals("abraham@example.com", new Email("  Abraham@Example.COM ").value());
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"   ", "sin-arroba.com", "a@b", "a@@b.com", "a b@c.com", "@c.com", "a@.com"})
    void rejectsInvalidEmails(String raw) {
        assertThrows(DomainValidationException.class, () -> new Email(raw));
    }

    @Test
    void rejectsTooLongEmails() {
        assertThrows(DomainValidationException.class, () -> new Email("a".repeat(250) + "@b.com"));
    }
}
