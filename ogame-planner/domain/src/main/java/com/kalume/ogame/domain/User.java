package com.kalume.ogame.domain;

import java.util.Objects;
import java.util.UUID;

public class User {
    private final UUID id;
    private final UserName userName;
    private final Email email;

    private User(UUID id, UserName userName, Email email) {
        this.id = Objects.requireNonNull(id);
        this.userName = Objects.requireNonNull(userName);
        this.email = Objects.requireNonNull(email);
    }

    /** Da de alta un usuario nuevo: el identificador lo genera el sistema, nunca el usuario. */
    public static User register(UserName userName, Email email) {
        return new User(UUID.randomUUID(), userName, email);
    }

    public UUID getId() {
        return id;
    }

    public UserName getUserName() {
        return userName;
    }

    public Email getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object other) {
        return other instanceof User user && id.equals(user.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
