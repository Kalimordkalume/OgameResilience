package com.kalume.ogame.cli;

public sealed interface MenuInputError {
    record NotANumber(String input) implements MenuInputError {
    }

    record UnknownOption(int id) implements MenuInputError {
    }

    record EmptyInput() implements MenuInputError {
    }

}
