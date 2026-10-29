package com.kalume.ogame.cli.users;

import java.util.Arrays;
import java.util.stream.Collectors;

import com.kalume.ogame.cli.Console;
import com.kalume.ogame.cli.MenuInputError;
import com.kalume.ogame.cli.MenuInputParser;
import com.kalume.ogame.cli.ParseResult;

public class UsersMenu {

    private final Console console;
    private final String title;
    private final MenuInputParser<UsersMenuOption> parser;

    public UsersMenu(Console console, MenuInputParser<UsersMenuOption> parser, String title) {
        this.console = console;
        this.title = title;
        this.parser = parser;
    }

    public UsersMenuOption askOption() {
        while (true) {
            showMenu();
            String userInput = console.ask("Seleccione una opción: ");

            ParseResult<UsersMenuOption> result = parser.parse(userInput);

            switch (result) {
                case ParseResult.Parsed<UsersMenuOption> parsed -> {
                    return parsed.value();
                }
                case ParseResult.Rejected<UsersMenuOption> rejected -> {
                    console.println("Hay un error: " + describe(rejected.error()));

                }

            }
        }

    }

    private String describe(MenuInputError error) {
        return switch (error) {
            case MenuInputError.EmptyInput _ -> "No has escrito nada.";
            case MenuInputError.NotANumber e -> "'" + e.input() + "' no es un número válido.";
            case MenuInputError.UnknownOption e -> "La opción " + e.id() + " no existe. Opciones disponibles: "
                    + Arrays.stream(UsersMenuOption.values())
                            .map(option -> String.valueOf(option.getId()))
                            .collect(Collectors.joining(", "))
                    + ".";
        };
    }

    private void showMenu() {
        console.println("----- " + title + " -----");
        for (UsersMenuOption option : UsersMenuOption.values()) {
            console.println(option.getId() + ". " + option.getLabel());

        }
    }

}
