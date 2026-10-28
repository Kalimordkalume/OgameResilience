package com.kalume.ogame.cli;

import com.kalume.ogame.domain.DomainValidationException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.UncheckedIOException;
import java.util.function.Function;

/** Lee y escribe por consola. Recibe los flujos para poder probarlo con texto preparado. */
public class Console {

    private final BufferedReader in;
    private final PrintStream out;

    public Console(InputStream in, PrintStream out) {
        this.in = new BufferedReader(new InputStreamReader(in));
        this.out = out;
    }

    public void println(String text) {
        out.println(text);
    }

    public String ask(String prompt) {
        out.print(prompt);
        out.flush();
        try {
            String line = in.readLine();
            if (line == null) {
                throw new InputClosedException();
            }
            return line;
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    /**
     * Pregunta hasta que el dominio acepta el valor. No valida nada por su cuenta: intenta construir el
     * objeto y, si el dominio lo rechaza, enseña su mensaje y vuelve a preguntar.
     */
    public <T> T askValid(String prompt, Function<String, T> parser) {
        while (true) {
            String raw = ask(prompt);
            try {
                return parser.apply(raw);
            } catch (DomainValidationException e) {
                println("  Error: " + e.getMessage());
            }
        }
    }
}
