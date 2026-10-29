package com.kalume.ogame.cli;

public sealed interface ParseResult<T> {
    record Parsed<T>(T value) implements ParseResult<T> {
    }

    record Rejected<T>(MenuInputError error) implements ParseResult<T> {
    }
}
