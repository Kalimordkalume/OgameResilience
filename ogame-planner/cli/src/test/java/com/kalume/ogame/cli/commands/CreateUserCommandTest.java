package com.kalume.ogame.cli.commands;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.kalume.ogame.application.user.CreateUser;
import com.kalume.ogame.cli.InputClosedException;
import com.kalume.ogame.cli.TestConsole;
import com.kalume.ogame.domain.Email;
import com.kalume.ogame.domain.UserName;
import com.kalume.ogame.infrastructure.memory.InMemoryUserRepository;
import org.junit.jupiter.api.Test;

class CreateUserCommandTest {

    private final InMemoryUserRepository repository = new InMemoryUserRepository();

    private CreateUserCommand commandWith(TestConsole terminal) {
        return new CreateUserCommand(terminal.console(), new CreateUser(repository));
    }

    @Test
    void createsAUserFromValidInput() {
        var terminal = new TestConsole("kalume", "k@example.com");

        commandWith(terminal).run();

        assertTrue(terminal.output().contains("Usuario creado: kalume"));
        assertTrue(repository.existsByUserName(new UserName("kalume")));
    }

    @Test
    void asksAgainWhenTheDomainRejectsTheInput() {
        var terminal = new TestConsole("ab", "kalume", "no-es-un-correo", "k@example.com");

        commandWith(terminal).run();

        assertTrue(terminal.output().contains("Error: El nombre de usuario debe tener de 3 a 20"));
        assertTrue(terminal.output().contains("Error: El correo electrónico no tiene un formato válido"));
        assertTrue(repository.existsByEmail(new Email("k@example.com")));
    }

    @Test
    void reportsADuplicatedUserWithoutCreatingIt() {
        commandWith(new TestConsole("kalume", "k@example.com")).run();
        var terminal = new TestConsole("kalume", "otro@example.com");

        commandWith(terminal).run();

        assertTrue(terminal.output().contains("No se ha creado el usuario. Ya existe un usuario con el nombre 'kalume'"));
        assertFalse(repository.existsByEmail(new Email("otro@example.com")));
    }

    @Test
    void stopsWhenTheInputEnds() {
        var terminal = new TestConsole("kalume");

        assertThrows(InputClosedException.class, () -> commandWith(terminal).run());
    }
}
