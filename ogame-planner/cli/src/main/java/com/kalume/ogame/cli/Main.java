package com.kalume.ogame.cli;

import java.nio.charset.Charset;
import java.util.List;

import com.kalume.ogame.cli.users.UsersMenu;

public class Main {

    public static void main(String[] args) {

        String name = System.getProperty("stdin.encoding");
        Charset charset = (name != null) ? Charset.forName(name) : Charset.defaultCharset();
        Console console = new Console(System.in, System.out, charset);

        console.println("Programa iniciado...");

        console.println("Iniciando consola interactiva...");
        // MAIN MENU
        MenuInputParser<MainMenuOption> mainMenuParser = new MenuInputParser<>(List.of(MainMenuOption.values()));
        MainMenu mainMenu = new MainMenu(console, mainMenuParser, "MENÚ PRINCIPAL");

        // USERS MENU
        MenuInputParser<UsersMenuOption> usersMenuParser = new MenuInputParser<>(List.of(UsersMenuOption.values()));
        UsersMenu usersMenu = new UsersMenu(console, usersMenuParser, "USUARIOS");

        CLI cliClient = new CLI(console, mainMenu, usersMenu);

        cliClient.start();

    }
}
