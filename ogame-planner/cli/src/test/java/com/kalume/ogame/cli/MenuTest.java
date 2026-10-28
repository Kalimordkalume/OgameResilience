package com.kalume.ogame.cli;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.kalume.ogame.cli.commands.Command;
import java.util.List;
import org.junit.jupiter.api.Test;

class MenuTest {

    private static class CountingCommand implements Command {
        int runs;

        @Override
        public String name() {
            return "Contar";
        }

        @Override
        public void run() {
            runs++;
        }
    }

    private final CountingCommand counting = new CountingCommand();

    @Test
    void runsTheChosenCommandAndExitsWithZero() {
        var terminal = new TestConsole("1", "1", "0");

        new Menu(terminal.console(), List.of(counting)).run();

        assertEquals(2, counting.runs);
        assertTrue(terminal.output().contains("1. Contar"));
        assertTrue(terminal.output().contains("0. Salir"));
    }

    @Test
    void rejectsOptionsThatDoNotExist() {
        var terminal = new TestConsole("7", "abc", "-1", "0");

        new Menu(terminal.console(), List.of(counting)).run();

        assertEquals(0, counting.runs);
        assertEquals(3, terminal.output().split("Opción no válida", -1).length - 1);
    }
}
