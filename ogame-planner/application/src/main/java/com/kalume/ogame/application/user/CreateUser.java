package com.kalume.ogame.application.user;

import com.kalume.ogame.domain.Email;
import com.kalume.ogame.domain.User;
import com.kalume.ogame.domain.UserName;
import com.kalume.ogame.domain.UserRepository;
import java.util.Objects;

/** Caso de uso: dar de alta un usuario. Recibe valores ya validados por el dominio. */
public class CreateUser {

    private final UserRepository users;

    public CreateUser(UserRepository users) {
        this.users = Objects.requireNonNull(users);
    }

    public User execute(UserName userName, Email email) {
        if (users.existsByUserName(userName)) {
            throw new UserAlreadyExistsException("Ya existe un usuario con el nombre '" + userName.value() + "'.");
        }
        if (users.existsByEmail(email)) {
            throw new UserAlreadyExistsException("Ya existe un usuario con el correo '" + email.value() + "'.");
        }
        var user = User.register(userName, email);
        users.save(user);
        return user;
    }
}
