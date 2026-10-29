package com.kalume.ogame.cli;

/**
 * Traduce el texto que escribe el usuario a una opción del menú. No escribe
 * mensajes: solo devuelve la opción o el motivo por el que no pudo traducirla.
 */
public class MenuInputParser {

    public ParseResult<MainMenuOption> parse(String userInput) {
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

        for (MainMenuOption option : MainMenuOption.values()) {
            if (option.getId() == id) {
                return new ParseResult.Parsed<>(option);
            }
        }
        return new ParseResult.Rejected<>(new MenuInputError.UnknownOption(id));
    }

}
