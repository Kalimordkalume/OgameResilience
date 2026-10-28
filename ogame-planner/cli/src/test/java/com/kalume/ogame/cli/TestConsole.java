package com.kalume.ogame.cli;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/** Consola de pruebas: lee un texto preparado y guarda todo lo que se escribe. */
public class TestConsole {

    private final ByteArrayOutputStream written = new ByteArrayOutputStream();
    private final Console console;

    /** @param lines lo que "teclea" el usuario, una entrada por línea */
    public TestConsole(String... lines) {
        var input = String.join("\n", lines) + (lines.length > 0 ? "\n" : "");
        this.console = new Console(
                new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8)),
                new PrintStream(written, true, StandardCharsets.UTF_8));
    }

    public Console console() {
        return console;
    }

    public String output() {
        return written.toString(StandardCharsets.UTF_8);
    }
}
