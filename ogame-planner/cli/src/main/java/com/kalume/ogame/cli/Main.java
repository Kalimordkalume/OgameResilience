package com.kalume.ogame.cli;

import com.kalume.ogame.application.user.CreateUser;
import com.kalume.ogame.cli.commands.CreateUserCommand;
import com.kalume.ogame.cli.commands.ListBuildingsCommand;
import com.kalume.ogame.infrastructure.memory.InMemoryUserRepository;
import java.util.List;

/** Punto de entrada: monta las piezas y arranca el menú. Aquí (y solo aquí) se eligen las implementaciones. */
public class Main {

    public static void main(String[] args) {
        var console = new Console(System.in, System.out);
        var users = new InMemoryUserRepository();

        var menu = new Menu(console, List.of(
                new CreateUserCommand(console, new CreateUser(users)),
                new ListBuildingsCommand(console)));

        try {
            menu.run();
        } catch (InputClosedException e) {
            console.println("");
        }
        console.println("Hasta luego.");
    }
}
