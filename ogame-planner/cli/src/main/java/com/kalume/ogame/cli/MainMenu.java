package com.kalume.ogame.cli;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Menú principal: enseña las opciones, lee lo que escribe el usuario y no
 * devuelve hasta que la entrada es una opción válida. Qué hace cada opción no
 * lo sabe: eso le toca a quien lo usa.
 */
public class MainMenu {
    private final Console console;
    private final MenuInputParser<MainMenuOption> parser;
    private final String title;

    public MainMenu(Console console, MenuInputParser<MainMenuOption> parser, String title) {
        this.console = console;
        this.parser = parser;
        this.title = title;
    }

    /** Pregunta hasta obtener una opción válida y la devuelve. */
    public MainMenuOption askOption() {
        while (true) {
            showMenu();
            String userInput = console.ask("Seleccione una opción: ");
            switch (parser.parse(userInput)) {
                case ParseResult.Parsed<MainMenuOption> parsed -> {
                    return parsed.value();
                }
                case ParseResult.Rejected<MainMenuOption> rejected -> {
                    console.println("Hay un error: " + describe(rejected.error()));
                }
            }
        }
    }

    private void showMenu() {
        console.println("----- " + title + " -----");
        for (MainMenuOption option : MainMenuOption.values()) {
            console.println(option.getId() + ". " + option.getLabel());
        }
    }

    private String describe(MenuInputError error) {
        return switch (error) {
            case MenuInputError.EmptyInput e -> "No has escrito nada.";
            case MenuInputError.NotANumber e -> "'" + e.input() + "' no es un número válido.";
            case MenuInputError.UnknownOption e -> "La opción " + e.id() + " no existe. Opciones disponibles: "
                    + Arrays.stream(MainMenuOption.values())
                            .map(option -> String.valueOf(option.getId()))
                            .collect(Collectors.joining(", "))
                    + ".";
        };
    }
}
