package com.kalume.ogame.cli;

import java.util.List;

/**
 * Traduce el texto que escribe el usuario a una opción del menú. No escribe
 * mensajes: solo devuelve la opción o el motivo por el que no pudo traducirla.
 */
public class MenuInputParser<T extends MenuOption> {

    private final List<T> options;

    public MenuInputParser(List<T> options) {
        this.options = options;
    }

    public ParseResult<T> parse(String userInput) {
        if (userInput.isBlank()) {
            return new ParseResult.Rejected<>(new MenuInputError.EmptyInput());

        }
        String trimmed = userInput.trim();
        int id;
        try {
            id = Integer.parseInt(trimmed);

        } catch (NumberFormatException e) {
            return new ParseResult.Rejected<>(new MenuInputError.NotANumber(trimmed));
        }

        for (T option : options) {
            if (option.getId() == id) {
                return new ParseResult.Parsed<>(option);
            }

        }
        return new ParseResult.Rejected<>(new MenuInputError.UnknownOption(id));
    }

}
