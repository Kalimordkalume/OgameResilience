package com.kalume.ogame.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

class UserTest {

    private final UserName name = new UserName("kalume");
    private final Email email = new Email("k@example.com");

    @Test
    void registerKeepsTheGivenData() {
        var user = User.register(name, email);
        assertEquals(name, user.getUserName());
        assertEquals(email, user.getEmail());
    }

    @Test
    void registeredUsersGetDifferentIds() {
        assertNotEquals(User.register(name, email), User.register(name, email));
    }
}
