package com.kalume.ogame.cli.commands;

import com.kalume.ogame.application.user.CreateUser;
import com.kalume.ogame.application.user.UserAlreadyExistsException;
import com.kalume.ogame.cli.Console;
import com.kalume.ogame.domain.Email;
import com.kalume.ogame.domain.UserName;

public class CreateUserCommand implements Command {

    private final Console console;
    private final CreateUser createUser;

    public CreateUserCommand(Console console, CreateUser createUser) {
        this.console = console;
        this.createUser = createUser;
    }

    @Override
    public String name() {
        return "Crear usuario";
    }

    @Override
    public void run() {
        UserName userName = console.askValid("Nombre de usuario: ", UserName::new);
        Email email = console.askValid("Correo electrónico: ", Email::new);
        try {
            var user = createUser.execute(userName, email);
            console.println("Usuario creado: " + user.getUserName().value() + " (id " + user.getId() + ")");
        } catch (UserAlreadyExistsException e) {
            console.println("No se ha creado el usuario. " + e.getMessage());
        }
    }
}
