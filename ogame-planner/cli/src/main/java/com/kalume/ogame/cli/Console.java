package com.kalume.ogame.cli;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.UncheckedIOException;
import java.nio.charset.Charset;

public class Console {

    private final BufferedReader in;
    private final PrintStream out;

    public Console(InputStream in, PrintStream out, Charset charset) {
        this.in = new BufferedReader(new InputStreamReader(in, charset));
        this.out = out;
    }

    public void println(String text) {
        out.println(text);
        out.flush();
    }

    public void print(String text) {
        out.print(text);
        out.flush();
    }

    public String ask(String prompt) {
        out.print(prompt);
        out.flush();
        try {
            String input = in.readLine();
            if (input == null) {
                throw new InputClosedException();
            }
            return input;
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

}
