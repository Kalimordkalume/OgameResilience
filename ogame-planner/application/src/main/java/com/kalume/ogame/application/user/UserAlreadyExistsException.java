package com.kalume.ogame.application.user;

/** Ya hay un usuario con ese nombre o ese correo. */
public class UserAlreadyExistsException extends RuntimeException {

    public UserAlreadyExistsException(String message) {
        super(message);
    }
}
